<template>
  <div class='mod-menu' v-loading="loading">
    <!--查询模块-->
    <el-form :inline='true' :model='dataForm' class='demo-form-inline' @keyup.enter.native="selectOrdersList()">

      <!-- 告警详情 -->
      <el-form-item label=''>
        <el-input v-model="dataForm.alarmName" placeholder='告警名称'></el-input>
      </el-form-item>

      <!-- 下拉框-设备类型 -->
      <el-form-item label="">
        <el-select v-model="dataForm.alarmType"  placeholder="报警类型">
          <el-option 
           v-for="item in optionList.alarmTypeList"
           :key="item" 
           :label="item" 
           :value="item"></el-option>
        </el-select>
      </el-form-item>

      <!-- 查询 开启自动处理-->
      <el-form-item>
        <el-button type='primary' @click='selectOrdersList()'>查询</el-button>
        <el-button @click="resetDataForm('dataForm')">重置</el-button>
        <!-- 自动处理 -->
        <el-button v-if="config.paramValue === '0'" type="success" @click="openAutoApproval()">开启自动处理</el-button>
        <el-button v-else-if="config.paramValue === '1'" type="danger" @click="closeAutoApproval()">关闭自动处理</el-button>
        <el-button v-else type="warning" disabled>加载中</el-button>
      </el-form-item>
    </el-form>

    <!-- 告警列表 -->
    <el-table
      :data='dataList.data'
      row-key='id'
      border 
      style='width: 100%; '>
      <el-table-column
        prop='alarmName'
        header-align='center'
        :show-overflow-tooltip='true'
        min-width="100"
        align='left'
        label='告警名称' >
        <template slot-scope='scope'>
          <el-tooltip class="item" effect="dark" content="查看详情" placement="bottom" :open-delay="1000" transition="el-fade-in-linear">
            <span @click='getAlerts(scope.row.id)'>
              {{scope.row.alarmName}}
            </span>
          </el-tooltip>
        </template>
      </el-table-column>
      <el-table-column
        prop='deviceName'
        header-align='center'
        align='center'
        width="150"
        label='设备名'>
      </el-table-column>
      <el-table-column
        prop='alarmType'
        header-align='center'
        align='center'
        width="150"
        label='报警类型'>
      </el-table-column>
      <el-table-column
        prop='adtecStatus'
        header-align='center'
        width="150"
        align='center'
        :show-overflow-tooltip='true'
        label='状态'
        filter-placement='bottom-end'>
        <template slot-scope='scope'>
          <el-tag
            :type="scope.row.adtecStatus === 1 ? 'success' : 'primary'"
            disable-transitions>
            <span v-if="scope.row.adtecStatus === 1">已处理</span>    
            <span v-else-if="scope.row.adtecStatus === 2">已忽略</span>    
            <span v-else>未处理</span>
          </el-tag>
        </template>
      </el-table-column>
       <el-table-column
        prop='adtecCreateDate'
        header-align='center'
        align='center'
        width="150"
        :show-overflow-tooltip='true'
        label='创建时间'>
      </el-table-column>
      <el-table-column
        prop='adtecStatus'
        header-align='center'
        align='center'
        width='150'
        label='操作'>
        <template slot-scope='scope'>
          <el-button type='primary' v-if="scope.row.adtecStatus === 0" @click="approval(scope.row.id)" size="mini">处理</el-button>
          <el-button v-else  type='primary' size="mini" disabled>处理</el-button>
          <el-button v-if="scope.row.adtecStatus === 0" type="danger" @click="overrule(scope.row.id)" size="mini">忽略</el-button>
          <el-button v-else type="danger"  size="mini" disabled>忽略</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <el-pagination
      class="el_pagination"
      background
      layout="prev, pager, next, total, sizes"
      @current-change="getAlarmsData"
      :current-page="page"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="10"
      @size-change="handleSizeChange"
      :total="dataList.total">
    </el-pagination>

    <!-- 弹窗告警详情 -->
    <alert-list-view v-if='AlertListViewVisible' ref='AlertListView' @refreshDataList='getAlarmsData'></alert-list-view>
  </div>
</template>

<script>
  import AlertListView from './alertlist-view'
  import { treeDataTranslate } from '@/utils'
  export default {
    data () {
      return {
        // 查询条件
        dataForm: {
          alarmName: '',
          alarmType: ''
        },
        // 当前页
        page: 1,
        // 每页条数
        size: 10,
        // 告警列表
        dataList: {
          data: [],
          total: 1
        },
        // 告警类型
        optionList: {
          alarmTypeList: []
        },
        // 弹窗告警详情
        AlertListViewVisible: true,
        // 1-开启自动处理，0-关闭自动处理
        autoApprovalData: '1',
        // 自动处理, 0: 关闭, 1: 开启
        config: {
          id: '',               // 参数id
          paramKey: '',         // 参数key
          paramValue: '3',      // 参数值
          remark: ''            // 备注
        },
        // 告警webSocket
        websocket: null,
        // 加载动画,true:显示,false:隐藏
        loading: true
      }
    },
    components: {
      AlertListView
    },
    activated () {
      this.getCondtionData()
      this.getAlarmsData()
      this.getAutoData()
    },
    methods: {
      // 获取筛选条件数据
      getCondtionData () {
        // 目标系统、来源系统
        this.$http({
          url: this.$http.adornUrl('/alarms/type'),
          method: 'get',
          params: this.$http.adornParams({}, false)
        }).then(({data}) => {
          console.log('系统分类:', data)
          if (data && data.code === 0) {
            this.optionList.alarmTypeList = data.alarmTypeList
          } else {
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
            this.optionList.alarmTypeList = ['无']
          }
        })
      },
      // 获取告警数据列表
      getAlarmsData (value) {
        // 初始化：筛选条件和分页
        // 分页数据
        if (value) {
          this.page = value
        } else {
          this.page = 1
        }
        console.log('当前页:', this.page)
        this.$http({
          url: this.$http.adornUrl('/alarms/list'),
          method: 'get',
          params: this.$http.adornParams({
            currentPage: this.page,
            size: this.size,
            alarmName: this.dataForm.alarmName,
            alarmType: this.dataForm.alarmType
          }, false)
        }).then(({data}) => {
          console.log('data:', data)
          if (data && data.code === 0) {
            this.dataList.data = treeDataTranslate(data.data, 'id')
            this.dataList.total = data.total
            // 关闭加载动画loading
            this.loading = false
          } else {
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
            this.loading = false
          }
        })
      },
      // 获取告警详情数据
      getAlerts (id) {
        console.log('告警详情id:', id)
        this.AlertListViewVisible = true
        this.$nextTick(() => {
          this.$refs.AlertListView.init(id)
        })
      },
      // 筛选分页查询
      selectOrdersList () {
        console.log('筛选条件：', this.dataForm)
        this.getAlarmsData()
      },
      // 重置筛选查询条件
      resetDataForm () {
        this.dataForm.alarmName = ''
        this.dataForm.alarmType = ''
        this.getAlarmsData()
      },
      // 处理
      approval (id) {
        console.log('告警详情id:', id)
        this.getAlarmsData()
        // 传递告警详情id
        this.$router.push({path: 'orders-ordersadd', query: {alarmsId: id}})
      },
      // 忽略
      overrule (id) {
        this.$confirm('此操作将忽略该告警, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 忽略
          console.log('忽略id:', id)
          this.$http({
            url: this.$http.adornUrl('/alarms/overrule'),
            method: 'get',
            params: this.$http.adornParams({id: id}, false)
          }).then(({data}) => {
            console.log('data:', data)
            if (data && data.code === 0) {
              this.$message({
                message: '已忽略',
                type: 'success',
                duration: 1000,
                onClose: () => {
                  this.visible = false
                }
              })
              // 刷新列表
              this.selectOrdersList()
            } else {
              this.$message({
                message: data.msg,
                type: 'error',
                duration: 1000
              })
              this.selectOrdersList()
            }
          })
        })
      },
      // 获取自动处理数据
      getAutoData () {
        this.$http({
          url: this.$http.adornUrl('/sys/config/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': 1,
            'limit': 10,
            'paramKey': ''
          })
        }).then(({data}) => {
          console.log('获取自动处理数据:', data)
          if (data && data.code === 0) {
            data.page.list.forEach(item => {
              // 保存自动处理数据
              if (item.paramKey === '自动处理') {
                this.config.id = item.id
                this.config.paramKey = item.paramKey
                this.config.paramValue = item.paramValue
                this.config.remark = item.remark
                console.log('this.config:', this.config)
              }
            })
          } else {
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
          }
        })
      },
      // 打开自动处理
      openAutoApproval () {
        this.$confirm('此操作将开启自动处理告警, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 显示等待按钮
          this.config.paramValue = '3'
          this.$http({
            url: this.$http.adornUrl('/sys/config/update'),
            method: 'post',
            data: this.$http.adornData({
              'id': this.config.id,
              'paramKey': this.config.paramKey,
              'paramValue': '1',
              'remark': this.dataForm.remark
            })
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.config.paramValue = '1'
              const h = this.$createElement
              this.$notify({
                title: '自动处理',
                message:
                  h(
                    'i',
                    {
                      style: 'color: teal'
                    },
                    '已成功开启自动处理'
                  )
              })
            } else {
              this.$message({
                message: '自动处理开启失败',
                type: 'error',
                duration: 1000
              })
            }
          })
        })
      },
      // 关闭自动处理
      closeAutoApproval () {
        this.$confirm('此操作将关闭自动处理告警, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 显示等待按钮
          this.config.paramValue = '3'
          this.$http({
            url: this.$http.adornUrl('/sys/config/update'),
            method: 'post',
            data: this.$http.adornData({
              'id': this.config.id,
              'paramKey': this.config.paramKey,
              'paramValue': '0',
              'remark': this.dataForm.remark
            })
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.config.paramValue = '0'
              const h = this.$createElement
              this.$notify({
                title: '自动处理',
                message:
                  h(
                    'i',
                    {
                      style: 'color: teal'
                    },
                    '已成功关闭自动处理'
                  )
              })
            } else {
              this.$message({
                message: '自动处理关闭失败',
                type: 'error',
                duration: 1000
              })
            }
          })
        })
      },
      // 处理页码大小变动
      handleSizeChange (val) {
        console.log(`每页 ${val} 条`)
        this.size = val
        this.getAlarmsData(this.page)
      }
    }
  }
</script>

<style lang="scss" scoped>
 .el_pagination {
    text-align: center;
  }
</style>