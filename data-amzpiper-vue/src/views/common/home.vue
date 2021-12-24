<template>
  <div class="mod-demo-echarts">
    <div class="echarts-box">
      <div class="echarts-title">
        概览
      </div>
      <div class="echarts-type">
        <el-tooltip class="item" effect="dark" content="来源分类" placement="bottom" :open-delay="1000"
                    transition="el-fade-in-linear">
          <el-select @change="ChangeAreaName" v-model="value" placeholder="全国" size="mini">
          <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
          </el-option>
          </el-select>
        </el-tooltip>
      </div>
      <div class="echarts-type-p">
        <el-tooltip class="item" effect="dark" content="来源分类" placement="bottom" :open-delay="1000"
                    transition="el-fade-in-linear">
          <el-select @change="ChangeProjectName" v-model="valueProject" placeholder="所有项目" size="mini">
          <el-option
          v-for="item in optionsProject"
          :key="item.value"
          :label="item.label"
          :value="item.value">
          </el-option>
          </el-select>
          <!--<el-cascader v-model="selectedOptions" :options="options1" @change="handleChange" clearable></el-cascader>-->
        </el-tooltip>
      </div>
    </div>

    <!-- 总数指标 -->
    <el-row :gutter="20">
      <el-col
        :span="6"
        class="hae-col"
        style="padding-left: 8px; padding-right: 8px;">
        <div class="hae-card hae-card-count">
          <div class="title">审批总数</div>
          <a class="content">{{dataForm.approvalAll}}</a>
        </div>
      </el-col>
      <el-col
        :span="6"
        class="hae-col"
        style="padding-left: 8px; padding-right: 8px;">
        <div class="hae-card hae-card-count2">
          <div class="title">驳回总数</div>
          <a class="content">{{dataForm.ovverruleAll}}</a>
        </div>
      </el-col>
      <el-col
        :span="6"
        class="hae-col"
        style="padding-left: 8px; padding-right: 8px;">
        <div class="hae-card hae-card-task">
          <div class="title">工单总数</div>
          <a class="content">{{dataForm.ordersAll}}</a>
        </div>
      </el-col>
      <el-col
        :span="6"
        class="hae-col"
        style="padding-left: 8px; padding-right: 8px;"
      >
        <div class="hae-card hae-card-taskcount">
          <div class="title">告警总数</div>
          <a class="content">{{dataForm.alertsAll}}</a>
        </div>
      </el-col>
    </el-row>

    <!-- 今日指标 -->
    <el-row :gutter="20">
      <el-col
        :span="6"
        class="hae-col"
        style="padding-left: 8px; padding-right: 8px;">
        <div class="hae-card hae-card-count">
          <div class="title">今日审批数</div>
          <a class="content">{{dataForm.approval}}</a>
        </div>
      </el-col>
      <el-col
        :span="6"
        class="hae-col"
        style="padding-left: 8px; padding-right: 8px;">
        <div class="hae-card hae-card-count2">
          <div class="title">今日驳回数</div>
          <a class="content">{{dataForm.ovverrule}}</a>
        </div>
      </el-col>
      <el-col
        :span="6"
        class="hae-col"
        style="padding-left: 8px; padding-right: 8px;">
        <div class="hae-card hae-card-task">
          <div class="title">今日工单数</div>
          <a class="content">{{dataForm.orders}}</a>
        </div>
      </el-col>
      <el-col
        :span="6"
        class="hae-col"
        style="padding-left: 8px; padding-right: 8px;"
      >
        <div class="hae-card hae-card-taskcount">
          <div class="title">今日告警数</div>
          <a class="content">{{dataForm.alerts}}</a>
        </div>
      </el-col>
    </el-row>

    <div class="echarts-box echarts-box2">
      <div class="echarts-title">
        统计
      </div>
       <div class="echarts-type-p">
        <el-select @change="ChangeDate" v-model="valueDate" placeholder="近7日" size="mini" style="width:100px">
        <el-option
        v-for="item in optionsDate"
        :key="item.value"
        :label="item.label"
        :value="item.value">
        </el-option>
        </el-select>
      </div>
    </div>
    <el-row :gutter="20">
      <!-- 折线图 -->
      <el-col :span="24">
        <el-card>
          <div id="J_chartLineBox" class="chart-box"></div>
        </el-card>
      </el-col>
      <!-- 柱状图 -->
      <el-col :span="24">
        <el-card>
          <div id="J_chartBarBox" class="chart-box"></div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import echarts from 'echarts'

  export default {
    data () {
      return {
        areaName: '全国',
        projectName: '所有项目',
        chartLine: null,
        chartBar: null,
        massage: '今日系统不停机更新!',
        // 指标
        dataForm: {
          approval: '0',
          ovverrule: '0',
          orders: '0',
          alerts: '0',
          approvalAll: '0',
          ovverruleAll: '0',
          ordersAll: '0',
          alertsAll: '0'
        },
        // 来源分公司分类
        options: [],
        // 来源分公司分类默认值
        value: '',
        // 来源项目分类
        optionsProject: [],
        // 默认项目分类
        valueProject: '',
        // 日期分类
        optionsDate: [
          {
            value: 'number',
            label: '近7日统计'
          },
          {
            value: 'month',
            label: '本月统计'
          },
          {
            value: 'year',
            label: '年度统计'
          }
        ],
        // 日期分类默认值
        valueDate: 'number'
      }
    },
    mounted () {
      // 获取初始化数据
      this.InitOptions()
    },
    activated () {
      // 修复bug, 由于给echart添加了resize事件, 在组件激活时需要重新resize绘画一次, 否则出现空白bug
      if (this.chartLine) {
        this.chartLine.resize()
      }
      if (this.chartBar) {
        this.chartBar.resize()
      }
    },
    methods: {
      // 初始化分类
      InitOptions () {
        this.GetInitOptions()
      },
      GetInitOptions () {
        // 请求分公司分类数据
        this.$http({
          url: this.$http.adornUrl('/buildingques/type'),
          method: 'get',
          params: this.$http.adornParams({areaName: this.areaName}, false)
        }).then(({data}) => {
          if (data && data.code === 0) {
            // 更新为真实数据
            console.log('data.areaNames:', data.areaNames)
            this.options.push(
              {
                value: '全国',
                label: '全国'
              }
            )
            this.optionsProject.push(
              {
                value: '所有项目',
                label: '所有项目'
              }
            )
            data.areaNames.map(item => {
              return this.options.push({
                value: item,
                label: item
              })
            })
            data.projectNames.map(item => {
              return this.optionsProject.push({
                value: item,
                label: item
              })
            })
            // 分公司默认值
            this.value = '全国'
            this.valueProject = '所有项目'
          } else {
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
          }
          this.GetNum(this.value, this.valueProject)
          this.GetChartLine(this.value, this.valueProject, this.valueDate)
          this.GetChartBar(this.value, this.valueProject, this.valueDate)
        })
      },
      GetProjectOptions () {
        // 请求分公司分类数据
        this.$http({
          url: this.$http.adornUrl('/buildingques/project'),
          method: 'get',
          params: this.$http.adornParams({areaName: this.areaName}, false)
        }).then(({data}) => {
          if (data && data.code === 0) {
            console.log('project------>', data)
            this.optionsProject = []
                // 更新为真实数据
            this.optionsProject.push({
              value: '所有项目',
              label: '所有项目'
            })
            data.projectNames.map(item => {
              return this.optionsProject.push({
                value: item,
                label: item
              })
            })
            this.valueProject = '所有项目'
            console.log('project2', this.optionsProject)
            this.GetNum(this.value, this.valueProject)
            this.GetChartLine(this.value, this.valueProject, this.valueDate)
            this.GetChartBar(this.value, this.valueProject, this.valueDate)
          } else {
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
          }
        })
      },
      // 指标数
      GetNum (areaName, projectName) {
        console.log(areaName, projectName)
        // 请求今日数据
        this.$http({
          url: this.$http.adornUrl('/home/today'),
          method: 'get',
          params: this.$http.adornParams({'areaName': areaName, 'projectName': projectName}, false)
        }).then(({data}) => {
          if (data && data.code === 0) {
            // 更新为真实数据
            console.log('datatoday:', data)
            this.dataForm.approval = data.examineApprovalNum
            this.dataForm.ovverrule = data.examineOverruleNum
            this.dataForm.orders = data.orderNum
            this.dataForm.alerts = data.alarmsNum
          } else {
            this.dataForm.approval = 0
            this.dataForm.ovverrule = 0
            this.dataForm.orders = 0
            this.dataForm.alerts = 0
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
          }
        })
        // 请求总数数据
        this.$http({
          url: this.$http.adornUrl('/home/all'),
          method: 'get',
          params: this.$http.adornParams({'areaName': areaName, 'projectName': projectName}, false)
        }).then(({data}) => {
          if (data && data.code === 0) {
            // 更新为真实数据
            console.log('datatoday:', data)
            this.dataForm.approvalAll = data.examineApprovalNumAll
            this.dataForm.ovverruleAll = data.examineOverruleNumAll
            this.dataForm.ordersAll = data.orderNumAll
            this.dataForm.alertsAll = data.alarmsNumAll
          } else {
            this.dataForm.approval = 0
            this.dataForm.ovverrule = 0
            this.dataForm.orders = 0
            this.dataForm.alerts = 0
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
          }
        })
      },
      // 折线图
      GetChartLine (areaName, projectName, date) {
        console.log(areaName, projectName)
        // 定义折线图
        var option = {
          // 标题
          title: {
            'text': '折线图'
          },
          tooltip: {
            trigger: 'axis'
          },
          color: ['#0490d6', '#8B4513', '#e99f25', '#e6607b'],
          legend: {
            data: ['审批数', '驳回数', '工单数', '告警数']
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          toolbox: {
            feature: {
              'saveAsImage': {}
            }
          },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
            axisLabel: {
              interval: 0,
              rotate: 0
            }
          },
          yAxis: {
            type: 'value'
          },
          series: [
            {
              name: '审批数',
              type: 'line',
              data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
              name: '驳回数',
              type: 'line',
              data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
              name: '工单数',
              type: 'line',
              data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
              name: '告警数',
              type: 'line',
              data: [0, 0, 0, 0, 0, 0, 0]
            }
          ]
        }
        // 请求真实数据:this.value为分公司名称
        this.$http({
          url: this.$http.adornUrl('/home/' + this.valueDate),
          method: 'get',
          params: this.$http.adornParams({'areaName': areaName, 'projectName': projectName}, false)
        }).then(({data}) => {
          if (data && data.code === 0) {
            // 更新为真实数据
            console.log('指标数据:', data)
            // 审批数
            if (data.examineApprovalList !== false && data.examineApprovalList.length > 0) {
              option.series[0].data = data.examineApprovalList
            } else {
              option.series[0].data = [0, 0, 0, 0, 0, 0, 0]
            }
            // 驳回数
            if (data.examineOverruleList !== false && data.examineOverruleList.length > 0) {
              option.series[1].data = data.examineOverruleList
            } else {
              option.series[1].data = [0, 0, 0, 0, 0, 0, 0]
            }
            // 工单数
            if (data.orderList !== false && data.orderList.length > 0) {
              option.series[2].data = data.orderList
            } else {
              option.series[2].data = [0, 0, 0, 0, 0, 0, 0]
            }
            // 告警数
            if (data.alarmsList !== false && data.alarmsList.length > 0) {
              option.series[3].data = data.alarmsList
            } else {
              option.series[3].data = [0, 0, 0, 0, 0, 0, 0]
            }
            // 日期
            if (data.dateList !== false && data.dateList.length > 0) {
              option.xAxis.data = data.dateList
            } else {
              option.xAxis.data = ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
            }
            // 渲染
            this.chartLine = echarts.init(document.getElementById('J_chartLineBox'))
            this.chartLine.setOption(option)
            window.addEventListener('resize', () => {
              this.chartLine.resize()
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
      // 柱状图
      GetChartBar (areaName, projectName, date) {
        console.log(areaName, projectName)
        // 定义柱状图
        var option = {
          // 标题
          title: {
            'text': '柱状图'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'shadow'
            }
          },
          color: ['#0490d6', '#8B4513', '#e99f25', '#e6607b'],
          legend: {
            data: ['审批数', '驳回数', '工单数', '告警数']
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          toolbox: {
            feature: {
              'saveAsImage': {}
            }
          },
          xAxis: {
            type: 'category',
            // boundaryGap: false,
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
            axisLabel: {
              interval: 0,
              rotate: 0
            }
          },
          yAxis: {
            type: 'value'
          },
          series: [
            {
              name: '审批数',
              type: 'bar',
              data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
              name: '驳回数',
              type: 'bar',
              data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
              name: '工单数',
              type: 'bar',
              data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
              name: '告警数',
              type: 'bar',
              data: [0, 0, 0, 0, 0, 0, 0]
            }
          ]
        }
        // 请求真实数据:this.value为分公司名称
        this.$http({
          url: this.$http.adornUrl('/home/' + this.valueDate),
          method: 'get',
          params: this.$http.adornParams({'areaName': areaName, 'projectName': projectName}, false)
        }).then(({data}) => {
          if (data && data.code === 0) {
            // 更新为真实数据
            console.log('指标数据:', data)
            // 审批数
            if (data.examineApprovalList !== false && data.examineApprovalList.length > 0) {
              option.series[0].data = data.examineApprovalList
            } else {
              option.series[0].data = [0, 0, 0, 0, 0, 0, 0]
            }
            // 驳回数
            if (data.examineOverruleList !== false && data.examineOverruleList.length > 0) {
              option.series[1].data = data.examineOverruleList
            } else {
              option.series[1].data = [0, 0, 0, 0, 0, 0, 0]
            }
            // 工单数
            if (data.orderList !== false && data.orderList.length > 0) {
              option.series[2].data = data.orderList
            } else {
              option.series[2].data = [0, 0, 0, 0, 0, 0, 0]
            }
            // 告警数
            if (data.alarmsList !== false && data.alarmsList.length > 0) {
              option.series[3].data = data.alarmsList
            } else {
              option.series[3].data = [0, 0, 0, 0, 0, 0, 0]
            }
            // 日期
            if (data.dateList !== false && data.dateList.length > 0) {
              option.xAxis.data = data.dateList
            } else {
              option.xAxis.data = ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
            }
            // 渲染
            this.chartBar = echarts.init(document.getElementById('J_chartBarBox'))
            this.chartBar.setOption(option)
            window.addEventListener('resize', () => {
              this.chartBar.resize()
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
      // 监听修改分类后执行
      ChangeAreaName (item) {
        console.log('分公司指标分类切换为:', item)
        this.areaName = item
        this.GetProjectOptions()
        // this.GetNum(this.value, this.valueProject)
        // this.GetChartLine(this.value, this.valueProject, this.valueDate)
        // this.GetChartBar(this.value, this.valueProject, this.valueDate)
      },
      ChangeProjectName (item) {
        console.log('项目分类切换为:', item)
        this.projectName = item
        this.GetNum(this.value, this.valueProject)
        this.GetChartLine(this.value, this.valueProject, this.valueDate)
        this.GetChartBar(this.value, this.valueProject, this.valueDate)
      },
      ChangeDate (item) {
        console.log('日期切换为:', item)
        this.valueDate = item
        this.GetNum(this.value, this.valueProject)
        this.GetChartLine(this.value, this.valueProject, this.valueDate)
        this.GetChartBar(this.value, this.valueProject, this.valueDate)
      },
      handleChange (value) {
        console.log(value)
      }
    }
  }
</script>

<style lang="scss">
  /* 指标图 */
  .mod-demo-echarts {
    > .el-alert {
      margin-bottom: 20px;
    }
    > .el-row {
      margin-top: -10px;
      margin-bottom: -10px;
      .el-col {
        padding-top: 10px;
        padding-bottom: 10px;
      }
    }
    .chart-box {
      min-height: 400px;
    }
  }

  /* 3个指标 */
  .hae-card {
    background-color: rgba(90, 182, 204, 0.2);
    border-radius: 3px;
    padding: 30px;
    box-shadow: 0 2px 12px 0 #fff;
    cursor: pointer;
  }

  .hae-card .title {
    font-size: 18px;
    font-weight: 400;
    margin-bottom: 10px;
  }

  .hae-card .content {
    font-size: 35px;
    font-weight: 500;
    display: inline-block;
    padding-left: 20px;
  }

  .hae-card-count {
    color: #0490d6;
  }

  .hae-card-count2 {
    color: #8B4513;
  }

  .hae-card-task {
    color: #e99f25;
  }

  .hae-card-taskcount {
    color: #e6607b;
  }

  /* 概览 */
  .echarts-box {
    position: relative;
    height: 20px;
    margin-bottom: 20px;
  }

  .echarts-title {
    font-size: 18px;
    font-weight: bold;
    color: #333;
    border-left: 3px solid #0490d6;
    padding-left: 3px;
    position: absolute;
    left: 0;
  }

  /* 分类 */
  .echarts-type {
    width: auto;
    position: absolute;
    right: 200px;
    top: -4px;
  }
  .echarts-type-p {
    width: auto;
    position: absolute;
    right: 0;
    top: -4px;
  }

  .el-dropdown-link {
    cursor: pointer;
    color: #17B3A3;
  }

  .el-icon-arrow-down {
    font-size: 12px;
  }

  /* 统计 */
  .echarts-box2 {
    margin-top: 20px;
  }
  .echarts-box2 .echarts-title {
    font-size: 18px;
    font-weight: bold;
    color: #333;
    border-left: 3px solid #0490d6;
    padding-left: 3px;
    position: absolute;
    left: 0;
  }
</style>
