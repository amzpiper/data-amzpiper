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
          问题描述: {{ordersData.quesDesc}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          问题类型: {{ordersData.questionType}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          来源系统: {{ordersData.sourceSystem}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          开始时间: {{ordersData.startDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          派单时间: {{ordersData.giveOutDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          接单时间: {{ordersData.acceptDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          完成时间: {{ordersData.finishDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          关闭时间: {{ordersData.closeDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          创建时间: {{ordersData.createDate}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          请求来源: {{ordersData.taskSource}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          联系人: {{ordersData.contactName}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          联系地址: {{ordersData.contactAddress}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          联系电话: {{ordersData.contactPhone}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          区域名称: {{ordersData.areaName}}
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          项目名称: {{ordersData.projectName}}
        </div>
      </el-col>
    </el-row>

    <!-- 关闭按钮 -->
    <!-- <el-row :gutter="20" class="review" slot="footer">
      <el-col :span="6" :offset="9">
        <el-button type='primary' @click="visible = false">关闭</el-button>
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
        // 工单数据
        ordersData: {
          questaskId: '无',
          quesDesc: '无',
          questionType: '无',
          sourceSystem: '无',
          startDate: '无',
          giveOutDate: '无',
          acceptDate: '无',
          finishDate: '无',
          closeDate: '无',
          createDate: '无',
          builderName: '无',
          closeSubmitDate: '无',
          closeApprovalDate: '无',
          closeStatus: '无',
          pauseSubmitDate: '无',
          pauseApprovalDate: '无',
          pauseStatus: '无',
          pauseDeadline: '无',
          applicant: '无',
          taskSource: '无',
          contactName: '无',
          contactAddress: '无',
          contactPhone: '无',
          areaName: '无',
          projectName: '无',
          roomPartName: '无'
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
          url: this.$http.adornUrl('/buildingques/search'),
          method: 'get',
          params: this.$http.adornParams({id: id}, false)
        }).then(({data}) => {
          console.log('data:', data)
          if (data && data.code === 0) {
            this.ordersData = data.data
            // 加载完成，展示工单，关闭加载动画
            this.loading = false
            this.visible = true
          } else {
            this.$message({
              message: data.msg,
              type: 'error',
              duration: 1000
            })
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
  /* 列表单项 */
  .grid-content{
    line-height: 30px;
  }
</style>
