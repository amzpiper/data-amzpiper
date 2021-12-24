<template>
  <div class='mod-menu' v-loading="loading">
    <!--  -->
    <el-form :inline='true' :model='dataForm' class='demo-form-inline' @keyup.enter.native="selectOrdersList()">
      <!-- 工单详情 -->
      <el-form-item label=''>
        <el-input v-model="dataForm.quesDesc" placeholder='工单详情' clearable size="small"></el-input>
      </el-form-item>
      <!-- 下拉框-来源系统 -->
      <el-form-item label="">
        <el-select v-model="dataForm.sourceSystem" placeholder="来源系统" clearable size="small">
          <el-option
           v-for="item in optionList.sourceSystemList"
           :key="item"
           :label="item"
           :value="item">
          </el-option>
        </el-select>
      </el-form-item>
      <!-- 下拉框-类型 -->
      <el-form-item label="">
        <el-select v-model="dataForm.questionType"  placeholder="工单类型" clearable size="small">
          <el-option
           v-for="item in optionList.questionTypeList"
           :key="item"
           :label="item"
           :value="item"></el-option>
        </el-select>
      </el-form-item>
      <!-- 下拉框-分公司 -->
      <el-form-item label="">
        <el-select v-model="dataForm.areaName"  placeholder="分公司" size="small">
          <el-option
           v-for="item in optionList.areaNameList"
           :key="item"
           :label="item"
           :value="item"></el-option>
        </el-select>
      </el-form-item>
      <!-- 下拉框-项目 -->
      <el-form-item label="">
        <el-select v-model="dataForm.projectName"  placeholder="项目" size="small">
          <el-option
           v-for="item in optionList.projectNameList"
           :key="item"
           :label="item"
           :value="item"></el-option>
        </el-select>
      </el-form-item>
      <!-- 查询 -->
      <el-form-item>
        <el-button type='primary' @click='selectOrdersList()' size="small">查询</el-button>
        <el-button @click="resetDataForm('dataForm')" size="small">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 工单列表 -->
    <el-table
      :data='dataList.data'
      row-key='menuId'
      border
      style='width: 100%;'>
      <el-table-column
        prop='quesDesc'
        header-align='center'
        :show-overflow-tooltip='true'
        label='工单详情' >
        <template slot-scope='scope'>
          <span @click='getOrders(scope.row.questaskId)'>
            {{scope.row.quesDesc}}
          </span>
        </template>
      </el-table-column>
      <el-table-column
        prop='qusetaskState'
        header-align='center'
        align='center'
        width='100'
        label='任务状态'>
      </el-table-column>
      <el-table-column
        prop='sourceSystem'
        header-align='center'
        align='center'
        label='来源系统'>
      </el-table-column>
      <el-table-column
        prop='questionType'
        header-align='center'
        align='center'
        :show-overflow-tooltip='true'
        label='工单类型'>
      </el-table-column>
      <el-table-column
        prop='areaName'
        header-align='center'
        align='center'
        :show-overflow-tooltip='true'
        label='分公司'>
      </el-table-column>
      <el-table-column
        prop='projectName'
        header-align='center'
        align='center'
        :show-overflow-tooltip='true'
        label='项目'>
      </el-table-column>
      <el-table-column
        prop='createDate'
        header-align='center'
        align='center'
        :show-overflow-tooltip='true'
        label='创建时间'>
      </el-table-column>
      <!-- <el-table-column
        fixed='right'
        header-align='center'
        align='center'
        width='150'
        label='操作'>
        <template slot-scope='scope'>
          <el-button type='text' size='big' @click='getOrders(scope.row.questaskId)'>查看详情</el-button>
        </template>
      </el-table-column> -->
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
    <!-- 弹窗工单详情,关闭弹出后不刷新当前页数据 -->
    <!-- <orders-list-view v-if='ordersListViewVisible' ref='OrdersListView'></orders-list-view> -->
  </div>

</template>

<script>
  import OrdersListView from './orderslist-view'
  import { treeDataTranslate } from '@/utils'
  export default {
    data () {
      return {
        // 筛选条件传输数据
        dataForm: {
          quesDesc: '',
          sourceSystem: '',
          questionType: '',
          areaName: '全国',
          projectName: '所有项目'
        },
        // 列表数据
        dataList: {
          data: [],
          // 数据总数
          total: 1
        },
        // 当前页
        page: 1,
        size: 10,
        // 筛选条件后台数据
        optionList: {
          sourceSystemList: [],
          questionTypeList: [],
          areaNameList: [],
          projectNameList: []
        },
        // 是否弹窗,true:显示,false:隐藏
        ordersListViewVisible: false,
        // 加载动画,true:显示,false:隐藏
        loading: true
      }
    },
    components: {
      // 详情组件
      OrdersListView
    },
    activated () {
      // 获取筛选条件初始数据
      this.getCondtionData()
      // 获取工单列表初始数据
      this.getOrdersData(1)
    },
    methods: {
      // 获取筛选条件数据
      getCondtionData () {
        // 请求真实数据
        this.$http({
          url: this.$http.adornUrl('/buildingques/type'),
          method: 'get',
          params: this.$http.adornParams({areaName: this.dataForm.areaName, projectName: this.dataForm.projectName}, false)
        }).then(({data}) => {
          console.log('data', data)
          this.optionList.sourceSystemList = ['一碑']
          this.optionList.questionTypeList = data.types
          this.optionList.areaNameList.push('全国')
          data.areaNames.map(item => {
            this.optionList.areaNameList.push(item)
          })
          this.optionList.projectNameList.push('所有项目')
          data.projectNames.map(item => {
            this.optionList.projectNameList.push(item)
          })
        })
      },
      // 获取工单数据
      getOrdersData (value) {
        // 初始化：筛选条件和分页
        // 分页数据
        if (value) {
          this.page = value
        } else {
          this.page = 1
        }
        console.log('当前页:', this.page)
        // 请求真实数据
        this.$http({
          url: this.$http.adornUrl('/buildingques/list'),
          method: 'get',
          params: this.$http.adornParams({
            currentPage: this.page,
            size: this.size,
            quesDesc: this.dataForm.quesDesc,
            sourceSystem: this.dataForm.sourceSystem,
            questionType: this.dataForm.questionType,
            areaName: this.dataForm.areaName,
            projectName: this.dataForm.projectName
          }, false)
        }).then(({data}) => {
          console.log('data:', data)
          if (data.code === 0) {
            // 真实列表数据
            this.dataList.data = treeDataTranslate(data.data, 'questaskId')
            // 真实总数数据
            this.dataList.total = data.total
            // 关闭加载动画loading
            this.loading = false
          } else {
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
            // 关闭加载动画loading
            this.loading = false
          }
        })
      },
      // 展示工单详情页
      getOrders (OrdersId) {
        // 传输要展示的工单ID
        console.log('id:', OrdersId)
        // 打开详情窗口
        this.ordersListViewVisible = true
        // 调用详情页初始化方法
        this.$nextTick(() => {
          this.$refs.OrdersListView.init(OrdersId)
        })
      },
      // 筛选查询
      selectOrdersList () {
        console.log('筛选条件：', this.dataForm)
        // 执行筛选查询, 获取第一页数据
        this.getOrdersData(1)
      },
      // 重置筛选条件
      resetDataForm () {
        this.dataForm.quesDesc = ''
        this.dataForm.sourceSystem = ''
        this.dataForm.questionType = ''
        this.dataForm.areaName = ''
        this.getOrdersData(1)
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
