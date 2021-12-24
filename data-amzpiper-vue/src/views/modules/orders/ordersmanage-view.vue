<template>
  <el-dialog
    :close-on-click-modal="false"
    :visible.sync="visible"
    class="dialogClass">

    <div slot="title" class="el-dialog__header">
      工单详情
    </div>

    <!-- 详情信息 -->
    <el-row :gutter="24" class="el-dialog__body" v-loading="loading">
      <el-col :span="12">
        <div class="grid-content bg-purple">
          问题任务ID: {{ordersData.questaskId}}
        </div>
      </el-col>
      <el-col :span="24">
        <div class="grid-content bg-purple">
          任务提交时间: {{ordersData.submitDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          创建时间: {{ordersData.createDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          是否公共区域: {{ordersData.isPublic}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          开始时间: {{ordersData.startDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          任务类型: {{ordersData.biProblemCategory}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          更新时间: {{ordersData.updateDate}}
        </div>
      </el-col>
      <el-col :span="24">
        <div class="grid-content bg-purple" style="word-break: break-word;">
          问题描述: {{ordersData.quesDesc}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          任务状态: {{ordersData.qusetaskState}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          问题级别: {{ordersData.emergencyDegree}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          联系地址: {{ordersData.contactAddress}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          联系人: {{ordersData.contactName}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          联系电话: {{ordersData.contactPhone}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          问题类型: {{ordersData.questionType}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          请求来源: {{ordersData.taskSource}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          任务类型: {{ordersData.taskType}}
        </div>
      </el-col>

      <el-col :span="12">
        <div class="grid-content bg-purple">
          状态: {{ordersData.state}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          楼层: {{ordersData.houseFloor}}
        </div>
      </el-col>
            <el-col :span="12">
        <div class="grid-content bg-purple">
          项目Id: {{ordersData.projectId}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          项目名称: {{ordersData.projectName}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          区域主键: {{ordersData.areaId}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          区域名称: {{ordersData.areaName}}
        </div>
      </el-col>
      
      <el-col :span="12">
        <div class="grid-content bg-purple">
          功能分区名称: {{ordersData.roomType}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          部位名称: {{ordersData.roomPartName}}
        </div>
      </el-col>
            <el-col :span="12">
        <div class="grid-content bg-purple">
          楼栋名称: {{ordersData.houseBuilding}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          单元: {{ordersData.houseCell}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          房号: {{ordersData.houseRoom}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          维修人: {{ordersData.maintenanceMan}}
        </div>
      </el-col>
      
      <el-col :span="12">
        <div class="grid-content bg-purple">
          派单人ID: {{ordersData.sendUserid}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          维修人ID: {{ordersData.mtainUserid}}
        </div>
      </el-col>
            <el-col :span="12">
        <div class="grid-content bg-purple">
          起单来源: {{ordersData.orignSource}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          录单系统: {{ordersData.sourceType}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          是否房修单: {{ordersData.houseFixStatus}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          本系统创建时间: {{ordersData.adtecCreateDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          更新时间: {{ordersData.adtecUpdateDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          起单来源: {{ordersData.examineStatus}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          来源系统: {{ordersData.sourceSystem}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          目标系统: {{ordersData.targetSystem}}
        </div>
      </el-col>
    </el-row>

    <!-- 审批 -->
    <!-- <el-row :gutter="20" class="review" slot="footer">
      <el-col :span="6" :offset="9">
        <el-button type='primary' @click="approval()">审批</el-button>
        <el-button type="danger" @click="overrule()">驳回</el-button>
      </el-col>  
    </el-row> -->
  </el-dialog>
</template>

<script>
  import Icon from '@/icons'
  export default {
    data () {
      return {
        // 展示详情,true显示，false隐藏
        visible: false,
        ordersData: {
          questaskId: '无',
          submitDate: '无',
          createDate: '无',
          isPublic: '无',
          startDate: '无',
          biProblemCategory: '无',
          updateDate: '无',
          quesDesc: '无',
          qusetaskState: '无',
          emergencyDegree: '无',
          contactAddress: '无',
          contactName: '无',
          contactPhone: '无',
          questionType: '无',
          taskSource: '无',
          taskType: '无',
          state: '无',
          houseFloor: '无',
          projectId: '无',
          projectName: '无',
          areaId: '无',
          areaName: '无',
          roomType: '无',
          roomPartName: '无',
          houseBuilding: '无',
          houseCell: '无',
          houseRoom: '无',
          maintenanceMan: '无',
          sendUserid: '无',
          mtainUserid: '无',
          orignSource: '无',
          sourceType: '无',
          houseFixStatus: '无',
          adtecCreateDate: '无',
          adtecUpdateDate: '无',
          examineStatus: '无',
          sourceSystem: '无',
          targetSystem: '无'
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
        this.$http({
          url: this.$http.adornUrl('/orderexamine/search'),
          method: 'get',
          params: this.$http.adornParams({id: id}, false)
        }).then(({data}) => {
          console.log('审批工单详情:', data)
          if (data && data.code === 0) {
            this.ordersData = data.data
            // 加载完成，展示工单，关闭加载动画
            this.visible = true
            this.loading = false
          } else {
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
            // 加载完成，展示工单，关闭加载动画
            this.visible = true
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
