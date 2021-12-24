<template>
  <div class='mod-menu' v-loading="loading">
    <!--查询模块-->
    <el-form :inline='true' :model='dataForm' class='demo-form-inline' @keyup.enter.native="selectOrdersList()">
      <!-- 工单详情 -->
      <el-form-item label=''>
        <el-input v-model="dataForm.quesDesc" placeholder='工单详情' clearable></el-input>
      </el-form-item>
      <!-- 下拉框-来源系统 -->
      <el-form-item label="">
        <el-select v-model="dataForm.sourceSystem" placeholder="来源系统" clearable>
          <el-option
           v-for="item in optionList.sourceSystemList"
           :key="item" 
           :label="item" 
           :value="item">
          </el-option>
        </el-select>
      </el-form-item>
      <!-- 下拉框-目标系统 -->
      <el-form-item label="">
        <el-select v-model="dataForm.targetSystem"  placeholder="目标系统" clearable>
          <el-option 
           v-for="item in optionList.targetSystemList"
           :key="item" 
           :label="item" 
           :value="item"></el-option>
        </el-select>
      </el-form-item>
      <!-- 下拉框-是否审批 -->
      <el-form-item label="">
        <el-select v-model="dataForm.isApproval"  placeholder="是否审批" clearable>
          <el-option 
           v-for="item in optionList.isApproval"
           :key="item.value" 
           :label="item.label" 
           :value="item.value"></el-option>
        </el-select>
      </el-form-item>
      <!-- 查询 -->
      <el-form-item>
        <el-button type='primary' @click='selectOrdersList()'>查询</el-button>
        <el-button @click="resetDataForm('dataForm')">重置</el-button>
      </el-form-item>
    </el-form>

    <!--多个操作模块-->
    <el-form :inline='true' :model='dataForm' class='demo-form-inline'>
      <el-form-item>
        <el-button @click='batchApproval()'>批量审批</el-button>
        <el-button @click="batchOverrule()">批量驳回</el-button>
        <!-- 自动审批 -->
        <el-button v-if="config.paramValue === '0'" type="success" @click="openAutoApproval()">开启自动审批</el-button>
        <el-button v-else-if="config.paramValue === '1'" type="danger" @click="closeAutoApproval()">关闭自动审批</el-button>
        <el-button v-else type="warning" disabled>加载中</el-button>
      </el-form-item>
    </el-form>

    <!-- 工单列表 -->
    <el-table
      :data='dataList.data'
      row-key='id'
      border 
      ref="elTable"
      style='width: 100%; '>
      <el-table-column
        type="selection"
        prop='id'
        header-align='center'
        :show-overflow-tooltip='true'
        min-width="100"
        align='center'>
      </el-table-column>
      <el-table-column
        prop='quesDesc'
        header-align='center'
        :show-overflow-tooltip='true'
        label='工单详情' >
        <template slot-scope='scope'>
          <span @click='getOrders(scope.row.id)'>
            {{scope.row.quesDesc}}
          </span>
        </template>
      </el-table-column>
      <el-table-column
        prop='sourceSystem'
        header-align='center'
        width="150"
        align='center'
        label='来源系统'>
      </el-table-column>
      <el-table-column
        prop='targetSystem'
        header-align='center'
        align='center'
        width="150"
        label='目标系统'>
      </el-table-column>
      <el-table-column
        prop='questionType'
        header-align='center'
        align='center'
        width="150"
        :show-overflow-tooltip='true'
        label='类型'>
      </el-table-column>
      <el-table-column
        prop='qusetaskState'
        header-align='center'
        width="150"
        align='center'
        :show-overflow-tooltip='true'
        label='审批状态'
        filter-placement='bottom-end'>
        <template slot-scope='scope'>
          <el-tag
            :type="scope.row.examineStatus === 1 ? 'success' : 'primary'"
            disable-transitions>
            <span v-if="scope.row.examineStatus === 1">已审批</span>    
            <span v-else-if="scope.row.examineStatus === 2">已驳回</span>    
            <span v-else>未审批</span>
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
        prop='state'
        header-align='center'
        align='center'
        width='150'
        label='操作'>
        <template slot-scope='scope'>
          <el-button type='primary' v-if="scope.row.examineStatus === 0" @click="approval(scope.row.id)" size="mini">审批</el-button>
          <el-button v-else  type='primary' size="mini" disabled>审批</el-button>
          <el-button v-if="scope.row.examineStatus === 0" type="danger" @click="overrule(scope.row.id)" size="mini">驳回</el-button>
          <el-button v-else type="danger"  size="mini" disabled>驳回</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <el-pagination
      class="el_pagination"
      background
      layout="prev, pager, next, total, sizes"
      @current-change="getOrdersData"
      :current-page="page"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="10"
      @size-change="handleSizeChange"
      :total="dataList.total">
    </el-pagination>

    <!-- 弹窗工单详情,关闭弹出后刷新当前页数据 -->
    <orders-list-view v-if='ordersListViewVisible' ref='OrdersListView' @refreshDataList='getOrdersData'></orders-list-view>

  </div>

</template>

<script>
  import OrdersListView from './ordersmanage-view'
  import { treeDataTranslate } from '@/utils'
  export default {
    data () {
      return {
        // 查询条件
        dataForm: {
          quesDesc: '',     // 工单详情
          sourceSystem: [], // 来源系统
          targetSystem: [], // 目标系统
          isApproval: []     // 是否审批
        },
        // 当前页
        page: 1,
        size: 10,
        // 工单列表
        dataList: {
          data: [],
          total: 0
        },
        // 筛选条件数据
        optionList: {
          sourceSystemList: [],
          targetSystemList: []
        },
        // 弹窗
        ordersListViewVisible: true,
        // 自动审批, 0: 关闭, 1: 开启
        config: {
          id: '',               // 参数id
          paramKey: '',         // 参数key
          paramValue: '3',      // 参数值
          remark: ''            // 备注
        },
        // 加载动画,true:显示,false:隐藏
        loading: true
      }
    },
    components: {
      OrdersListView
    },
    activated () {
      // 获取初始数据
      this.selectOrdersList()
      // 获取筛选条件初始数据
      this.getCondtionData()
      // 获取自动审批状态
      this.getAutoData()
    },
    methods: {
      // 获取筛选条件数据
      getCondtionData () {
        // 目标系统、来源系统
        this.$http({
          url: this.$http.adornUrl('/orderexamine/type'),
          method: 'get',
          params: this.$http.adornParams({}, false)
        }).then(({data}) => {
          console.log('系统分类:', data)
          if (data && data.code === 0) {
            this.optionList.sourceSystemList = data.sourceSystemTypeList
            this.optionList.targetSystemList = data.targetSystemTypeList
          } else {
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
            this.optionList.sourceSystemList = ['无']
            this.optionList.targetSystemList = ['无']
          }
        })
        // 审批状态
        this.optionList.isApproval = [
          {
            value: '1',
            label: '已审批'
          },
          {
            value: '2',
            label: '已驳回'
          },
          {
            value: '0',
            label: '未审批'
          }
        ]
      },
      // 获取审批工单数据列表
      getOrdersData (value) {
        // 初始化：筛选条件和分页
        // 分页数据
        if (value) {
          this.page = value
        } else {
          this.page = 1
        }
        console.log('当前页:', this.page)
        this.$http({
          url: this.$http.adornUrl('/orderexamine/list'),
          method: 'get',
          params: this.$http.adornParams({
            currentPage: this.page,
            size: this.size,
            quesDesc: this.dataForm.quesDesc,
            isApproval: this.dataForm.isApproval,
            sourceSystem: this.dataForm.sourceSystem,
            targetSystem: this.dataForm.targetSystem
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
      // 获取工单详情数据
      getOrders (id) {
        console.log('id:', id)
        this.ordersListViewVisible = true
        this.$nextTick(() => {
          this.$refs.OrdersListView.init(id)
        })
      },
      // 筛选分页查询
      selectOrdersList () {
        console.log('筛选条件：', {
          currentPage: this.page,
          size: this.size,
          quesDesc: this.dataForm.quesDesc,
          isApproval: this.dataForm.isApproval,
          sourceSystem: this.dataForm.sourceSystem,
          targetSystem: this.dataForm.targetSystem
        })
        this.getOrdersData()
      },
      // 重置筛选查询条件
      resetDataForm () {
        this.dataForm.quesDesc = ''
        this.dataForm.sourceSystem = ''
        this.dataForm.questionType = ''
        this.dataForm.isApproval = ''
        this.dataForm.targetSystem = ''
        this.page = 1
        this.getOrdersData()
      },
      // 审批
      approval (id) {
        this.$confirm('此操作将审批工单, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/orderexamine/approval'),
            method: 'get',
            params: this.$http.adornParams({id: id}, false)
          }).then(({data}) => {
            console.log('data:', data)
            if (data && data.code === 0) {
              this.$message({
                message: '审批成功',
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
            }
          })
        }).catch(() => {
        })
        console.log('审批id:', id)
      },
      // 驳回
      overrule (id) {
        console.log('驳回id:', id)
        this.$http({
          url: this.$http.adornUrl('/orderexamine/overrule'),
          method: 'get',
          params: this.$http.adornParams({id: id}, false)
        }).then(({data}) => {
          console.log('data:', data)
          if (data && data.code === 0) {
            this.$message({
              message: '驳回成功',
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
          }
        })
      },
      // 批量审批
      batchApproval () {
        console.log('批量审批selection:', this.$refs.elTable.selection)
        // 所有选择的工单
        let selectionObjects = this.$refs.elTable.selection
        // 未选时提示
        if (selectionObjects.length === 0) {
          this.$message({
            message: '请选择工单',
            type: 'warning',
            duration: 1000
          })
          return
        }
        // 获取所有选择的id
        var ids = []
        selectionObjects.forEach(item => {
          ids.push(item.id)
        })
        console.log('批量审批ids:', ids)
        // 发起批量审批
        this.$http({
          url: this.$http.adornUrl('/orderexamine/batchapproval'),
          method: 'post',
          data: this.$http.adornData(ids)
        }).then(({data}) => {
          console.log('data:', data)
          if (data && data.code === 0) {
            this.$message({
              message: '批量审批成功',
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
          }
        })
      },
      // 批量驳回
      batchOverrule () {
        console.log('批量驳回selection:', this.$refs.elTable.selection)
        // 所有选择的工单
        let Objects = this.$refs.elTable.selection
        // 未选时提示
        if (Objects.length === 0) {
          this.$message({
            message: '请选择工单',
            type: 'warning',
            duration: 1000
          })
          return
        }
        // 过滤出所有id
        var ids = []
        Objects.forEach(item => {
          ids.push(item.id)
        })
        console.log('批量驳回ids:', ids)
        this.$http({
          url: this.$http.adornUrl('/orderexamine/batchoverrule'),
          method: 'post',
          data: this.$http.adornData(ids)
        }).then(({data}) => {
          console.log('data:', data)
          this.$message({
            message: '批量驳回成功',
            type: 'success',
            duration: 1000,
            onClose: () => {
              this.visible = false
            }
          })
          // 刷新列表
          this.selectOrdersList()
        })
      },
      // 获取自动审批数据
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
          console.log('获取自动审批数据:', data)
          if (data && data.code === 0) {
            data.page.list.forEach(item => {
              // 保存自动审批数据
              if (item.paramKey === '自动审批') {
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
      // 打开自动审批
      openAutoApproval () {
        this.$confirm('此操作将开启自动审批, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 显示等待按钮
          this.config.paramValue = '3'
          // 打开自动审批
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
                title: '自动审批',
                message:
                  h(
                    'i',
                    {
                      style: 'color: teal'
                    },
                    '已成功开启自动审批'
                  )
              })
            } else {
              this.$message({
                message: '自动审批开启失败',
                type: 'error',
                duration: 1000
              })
            }
          })
        }).catch(() => {
        })
      },
      // 关闭自动审批
      closeAutoApproval () {
        this.$confirm('此操作将关闭自动审批, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 显示等待按钮
          this.config.paramValue = '3'
          // 关闭自动审批
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
                title: '自动审批',
                message:
                  h(
                    'i',
                    {
                      style: 'color: teal'
                    },
                    '已成功关闭自动审批'
                  )
              })
            } else {
              this.$message({
                message: '自动审批关闭启失败',
                type: 'error',
                duration: 1000
              })
            }
          })
        }).catch(() => {
        })
      },
      // 处理页码大小变动
      handleSizeChange (val) {
        console.log(`每页 ${val} 条`)
        this.size = val
        this.getOrdersData(this.page)
      }
    }
  }
</script>

<style lang="scss" scoped>
 .el_pagination {
    text-align: center;
  }
</style>