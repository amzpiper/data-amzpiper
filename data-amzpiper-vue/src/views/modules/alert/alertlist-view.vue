<template>
  <el-dialog
    :title='""'
    class='dialogClass'
    :close-on-click-modal='false'
    :visible.sync='visible'>

    <div slot='title' class='el-dialog__header' v-loading="loading">
      告警详情
    </div>      

    <!-- 详情信息 -->
    <el-row :gutter='24' class='el-dialog__body'>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          告警名称: {{alarmsData.alarmName}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          开始时间: {{alarmsData.begintime}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          结束时间: {{alarmsData.endtime}}
        </div>
      </el-col>

      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          设备名: {{alarmsData.deviceName}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          设备名.点名: {{alarmsData.pointName}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          值: {{alarmsData.value}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          点描述: {{alarmsData.description}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          quality: {{alarmsData.quality}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          报警类型: {{alarmsData.alarmType}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          报警级别: {{alarmsData.alarmLevel}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          isAlarmRepeat: {{alarmsData.isAlarmRepeat}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          设备描述: {{alarmsData.deviceDescribe}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          动作描述: {{alarmsData.alarmActionDec}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          alarmTableTag: {{alarmsData.alarmTableTag}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          数据类型: {{alarmsData.dataType}}
        </div>
      </el-col>
      <el-col :span='12'>
        <div class='grid-content bg-purple'>
          告警状态: {{alarmsData.adtecStatus}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          本系统创建时间: {{alarmsData.adtecCreateDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          更新时间: {{alarmsData.adtecUpdateDate}}
        </div>
      </el-col>
    </el-row>
  </el-dialog>
</template>

<script>
  import Icon from '@/icons'
  export default {
    data () {
      return {
        // 显示该弹窗界面
        visible: false,
        // 告警详情
        alarmsData: {
          adtecCreateDate: '无',
          adtecUpdateDate: '无',
          adtecStatus: '无',
          alarmActionDec: '无',
          alarmLevel: '无',
          alarmName: '无',
          alarmTableTag: '无',
          alarmType: '无',
          begintime: '无',
          dataType: '无',
          description: '无',
          deviceDescribe: '无',
          deviceName: '无',
          endtime: '无',
          id: '无',
          isAlarmRepeat: '无',
          pointName: '无',
          quality: '无',
          value: '无'
        },
        // 加载动画,true显示，false隐藏
        loading: true
      }
    },
    created () {
      this.iconList = Icon.getNameList()
    },
    methods: {
      init (id) {
        // 显示弹窗
        this.visible = true
        this.$http({
          url: this.$http.adornUrl('/alarms/search'),
          method: 'get',
          params: this.$http.adornParams({id: id}, false)
        }).then(({data}) => {
          console.log('告警详情:', data)
          if (data && data.code === 0) {
            this.alarmsData = data.data
            // 加载完成，展示工单，关闭加载动画
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
      }
    }
  }
</script>

<style scoped>
  .dialogClass .el-dialog__header {
    padding: 0px 0px;
    font-size: 16px;
    font-weight: 700;
  }
  .dialogClass .el-dialog__body {
    padding: 0px 0px 0px 0px;
    margin-top: -20px;
    margin-bottom: -15px;
  }
 .review {
    /* 居中 */
    text-align: center;
  }
</style>
