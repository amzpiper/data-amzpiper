<template>
  <el-form :inline="false" :model="orderForm" :rules="rules" ref="orderForm" label-width="130px">
    <el-row>

      <el-col :span="24">
        <el-form-item label="问题描述" prop="quesDesc">
          <el-input v-model="orderForm.quesDesc" type="textarea" width="100%" clearable></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="8" >
        <el-form-item label="任务提交时间" required>
            <el-form-item prop="submitDate">
              <el-date-picker
                style="width: 100%;"
                v-model="orderForm.submitDate"
                type="datetime"
                placeholder="选择日期时间"
                default-time="00:00:00">
              </el-date-picker>
            </el-form-item>
        </el-form-item>
      </el-col>

      <!-- <el-col :span="8" >
        <el-form-item label="创建时间">
            <el-form-item>
              <el-date-picker
                v-model="orderForm.createDate"
                type="datetime"
                placeholder="选择日期时间"
                default-time="12:00:00">
              </el-date-picker>
            </el-form-item>
        </el-form-item>
      </el-col> -->

      <el-col :span="8" >
        <el-form-item label="开始时间" required>
            <el-form-item prop="startDate">
              <el-date-picker
                style="width: 100%;"
                v-model="orderForm.startDate"
                type="datetime"
                placeholder="选择日期时间"
                default-time="00:00:00">
              </el-date-picker>
            </el-form-item>
        </el-form-item>
      </el-col>

      <el-col :span="8">
        <el-form-item label="是否公共区域" >
          <el-input v-model="orderForm.isPublic" clearable></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="8">
        <el-form-item label="任务类型">
          <el-input v-model="orderForm.biProblemCategory" clearable></el-input>
        </el-form-item>
      </el-col>

      <!-- <el-col :span="8" >
        <el-form-item label="更新时间">
            <el-form-item>
              <el-date-picker
                v-model="orderForm.updateDate"
                type="datetime"
                placeholder="选择日期时间"
                default-time="12:00:00">
              </el-date-picker>
            </el-form-item>
        </el-form-item>
      </el-col> -->

      <el-col :span="8">
        <el-form-item label="任务状态">
          <el-input v-model="orderForm.qusetaskState" clearable></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="8">
        <el-form-item label="问题级别">
          <el-input v-model="orderForm.emergencyDegree" clearable></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="8">
        <el-form-item label="联系地址">
          <el-input v-model="orderForm.contactAddress" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item label="联系人">
          <el-input v-model="orderForm.contactName" clearable></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="8">
        <el-form-item label="联系电话">
          <el-input v-model="orderForm.contactPhone" clearable></el-input>
        </el-form-item>
      </el-col>
      
      <el-col :span="8">
        <el-form-item label="问题类型">
          <el-input v-model="orderForm.questionType" clearable></el-input>
        </el-form-item>
      </el-col>
      
      <el-col :span="8">
        <el-form-item label="请求来源">
          <el-input v-model="orderForm.taskSource" clearable></el-input>
        </el-form-item>
      </el-col>
      
      <el-col :span="8">
        <el-form-item label="任务类型">
          <el-input v-model="orderForm.taskType" clearable></el-input>
        </el-form-item>
      </el-col>
      
      <el-col :span="8">
        <el-form-item label="状态" required>
          <el-input v-model="orderForm.state" clearable></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="8">
        <el-form-item label="楼层" >
          <el-input v-model="orderForm.houseFloor" clearable></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="8">
        <el-form-item label="项目Id" >
          <el-input v-model="orderForm.projectId" clearable></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="8">
        <el-form-item label="项目名称" >
          <el-input v-model="orderForm.projectName" clearable></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="8">
        <el-form-item label="区域主键" >
          <el-input v-model="orderForm.areaId" clearable></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="8">
        <el-form-item label="区域名称" >
          <el-input v-model="orderForm.areaName" clearable></el-input>
        </el-form-item>
      </el-col>

       <el-col :span="8">
        <el-form-item label="功能分区名称" >
          <el-input v-model="orderForm.roomType" clearable></el-input>
        </el-form-item>
      </el-col>

       <el-col :span="8">
        <el-form-item label="部位名称" >
          <el-input v-model="orderForm.roomPartName" clearable></el-input>
        </el-form-item>
      </el-col>

       <el-col :span="8">
        <el-form-item label="楼栋名称" >
          <el-input v-model="orderForm.houseBuilding" clearable></el-input>
        </el-form-item>
      </el-col>
       <el-col :span="8">
        <el-form-item label="单元" >
          <el-input v-model="orderForm.houseCell" clearable></el-input>
        </el-form-item>
      </el-col>
       <el-col :span="8">
        <el-form-item label="房号" >
          <el-input v-model="orderForm.houseRoom" clearable></el-input>
        </el-form-item>
      </el-col>
       <el-col :span="8">
        <el-form-item label="派单人ID" >
          <el-input v-model="orderForm.sendUserid" clearable></el-input>
        </el-form-item>
      </el-col>
       <el-col :span="8">
        <el-form-item label="维修人ID" >
          <el-input v-model="orderForm.mtainUserid" clearable></el-input>
        </el-form-item>
      </el-col>
      <!-- 
      <el-col :span="8">
        <el-form-item label="起单来源" >
          <el-input v-model="orderForm.orignSource" clearable></el-input>
        </el-form-item>
      </el-col> -->
      <!-- <el-col :span="8">
        <el-form-item label="录单系统" >
          <el-input v-model="orderForm.sourceType" clearable></el-input>
        </el-form-item>
      </el-col> -->
      <el-col :span="8">
        <el-form-item label="是否房修单" >
          <el-input v-model="orderForm.houseFixStatus" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item label="目标系统" required>
          <el-select v-model="orderForm.targetSystem" placeholder="请选择目标系统">
            <el-option 
              v-for="item in condtionData.targetSystemList"
              :key="item" 
              :label="item" 
              :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>

      <el-col :span="24">
        <el-form-item style="text-align:right;">
          <el-button @click="resetForm('orderForm')">重置</el-button>
          <el-button type="primary" @click="submitForm('orderForm')">提交</el-button>
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>

</template>

<script>
  export default {
    data () {
      return {
        condtionData: {
          targetSystemList: []
        },
        // 工单数据
        orderForm: {
          submitDate: '',
          // createDate: '',
          isPublic: '',
          startDate: '',
          biProblemCategory: '',
          // updateDate: '',
          quesDesc: '',
          qusetaskState: '',
          emergencyDegree: '',
          contactAddress: '',
          contactName: '',
          contactPhone: '',
          questionType: '',
          taskSource: '',
          taskType: '',
          state: '',
          houseFloor: '',
          projectId: '',
          projectName: '',
          areaId: '',
          areaName: '',
          roomType: '',
          roomPartName: '',
          houseBuilding: '',
          houseCell: '',
          houseRoom: '',
          maintenanceMan: '',
          sendUserid: '',
          mtainUserid: '',
          orignSource: '',
          sourceType: '',
          houseFixStatus: '',
          targetSystem: ''
        },
        alarmsId: '',
        rules: {
          quesDesc: [
            { required: true, message: '请输入工单名称', trigger: 'blur' },
            { min: 1, max: 200, message: '长度在 1 到 200 个字符', trigger: 'blur' }
          ],
          submitDate: [
            { required: true, message: '请选择提交日期', trigger: 'change' }
          ],
          startDate: [
            { required: true, message: '请选择开始日期', trigger: 'change' }
          ]
        }
      }
    },
    components: {
    },
    activated () {
      this.init()
    },
    methods: {
      // 初始化
      init () {
        // 获取工单目标系统列表
        this.getCondtionData()
        // 判断是否从告警列表进入
        console.log('url:', window.location.href)
        var url = window.location.href
        if (url.indexOf('alarmsId') > 0) {
          var id = url.substring(url.indexOf('alarmsId') + 9, url.length)
          console.log('告警详情id:', id)
          this.alarmsId = id
          this.$http({
            url: this.$http.adornUrl('/alarms/search'),
            method: 'get',
            params: this.$http.adornParams({id: this.alarmsId}, false)
          }).then(({data}) => {
            console.log('告警详情:', data)
            if (data.code === 0) {
              this.orderForm.submitDate = this.format(Date.now(), 'YYYY-MM-DD HH:mm:ss')
              this.orderForm.createDate = this.format(Date.now(), 'YYYY-MM-DD HH:mm:ss')
              this.orderForm.startDate = this.format(Date.now(), 'YYYY-MM-DD HH:mm:ss')
              this.orderForm.updateDate = this.format(Date.now(), 'YYYY-MM-DD HH:mm:ss')
              this.orderForm.quesDesc =
              '告警名:' + data.data.alarmName + '; 告警描述: ' + data.data.description
              console.log('时间:', Date.now())
            } else {
              this.$message({
                message: '获取告警数据错误!',
                type: 'warning',
                duration: 1000
              })
            }
          }).then(() => {
          })
        }
      },
      getCondtionData () {
        this.condtionData.targetSystemList.push('融通系统')
        this.orderForm.targetSystem = '融通系统'
      },
      // 提交表单
      submitForm (formName) {
        // 格式化时间格式字段数据
        this.orderForm.submitDate = this.format(this.orderForm.submitDate, 'YYYY-MM-DD HH:mm:ss')
        // this.orderForm.createDate = this.format(this.orderForm.createDate, 'YYYY-MM-DD HH:mm:ss')
        this.orderForm.startDate = this.format(this.orderForm.startDate, 'YYYY-MM-DD HH:mm:ss')
        // this.orderForm.updateDate = this.format(this.orderForm.updateDate, 'YYYY-MM-DD HH:mm:ss')
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log('创建工单内容:', this.orderForm)
            this.$http({
              url: this.$http.adornUrl('/orderexamine/add'),
              method: 'post',
              data: this.$http.adornData(this.orderForm)
            }).then(({data}) => {
              console.log('data:', data)
              if (data && data.code === 0) {
                // 如果存在告警id,则为处理告警工单,需要更新告警状态,否则为一般工单
                if (this.alarmsId) {
                  this.$http({
                    url: this.$http.adornUrl('/alarms/approval'),
                    method: 'get',
                    params: this.$http.adornParams({id: this.alarmsId}, false)
                  }).then(({data}) => {
                    if (data && data.code === 0) {
                      this.$message({
                        message: '处理告警成功!',
                        type: 'success',
                        duration: 1000
                      })
                      // 刷新工单数据
                      // 返回告警列表页面
                      this.resetForm('orderForm')
                      this.$router.push({path: 'alert-alertlist'})
                    } else {
                      this.$message({
                        message: '处理告警失败,error:' + data.msg,
                        type: 'error',
                        duration: 1000
                      })
                    }
                  })
                } else {
                  this.$message({
                    message: '创建工单成功!',
                    type: 'success',
                    duration: 1000
                  })
                  // 刷新工单数据
                  // 返回审批列表页面
                  this.resetForm('orderForm')
                  this.$router.push({path: 'orders-ordersmanage'})
                }
              } else {
                this.$message({
                  message: '工单创建失败,error:' + data.msg,
                  type: 'error',
                  duration: 1000
                })
              }
            })
          } else {
            console.log('error submit!!')
            return false
          }
        })
      },
      // 重置表单
      resetForm (formName) {
        this[formName] = {
          submitDate: '',
          createDate: '',
          isPublic: '',
          startDate: '',
          biProblemCategory: '',
          updateDate: '',
          quesDesc: '',
          qusetaskState: '',
          emergencyDegree: '',
          contactAddress: '',
          contactName: '',
          contactPhone: '',
          questionType: '',
          taskSource: '',
          taskType: '',
          state: '',
          houseFloor: '',
          projectId: '',
          projectName: '',
          areaId: '',
          areaName: '',
          roomType: '',
          roomPartName: '',
          houseBuilding: '',
          houseCell: '',
          houseRoom: '',
          maintenanceMan: '',
          sendUserid: '',
          mtainUserid: '',
          orignSource: '',
          sourceType: '',
          houseFixStatus: ''
        }
      },
      // 格式化时间组件数据
      format (time, format) {
        var t = new Date(time)
        var tf = function (i) { return (i < 10 ? '0' : '') + i }
        return format.replace(/YYYY|MM|DD|HH|mm|ss/g, function (a) {
          switch (a) {
            case 'YYYY':
              return tf(t.getFullYear())
            case 'MM':
              return tf(t.getMonth() + 1)
            case 'DD':
              return tf(t.getDate())
            case 'HH':
              return tf(t.getHours())
            case 'mm':
              return tf(t.getMinutes())
            case 'ss':
              return tf(t.getSeconds())
          }
        })
      }
    }
  }
</script>
