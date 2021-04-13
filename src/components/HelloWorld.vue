<template>
  <div id="index_examples">
    <el-container class="main">
      <!--  top  -->
      <el-header class="header">
        <img src="https://s3.ax1x.com/2021/01/04/sPpfCq.png" alt="" />
        <span class="header-title">管理控制台</span>
        <!--  <div class="clear"></div>  -->
        <el-dropdown>
          <span class="el-dropdown-link">
            xianjin
            <i class="el-icon-caret-bottom"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>个人中心</el-dropdown-item>
            <el-dropdown-item>消息通知</el-dropdown-item>
            <el-dropdown-item>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
      <!--  bottom  -->
      <el-container class="bottom">
        <!--  todo:选中后没有选中后的背景效果  -->
        <!--  master-aside  -->
        <el-aside :width="tabWidth + 'px'" class="master-aside">
          <!--  收缩按钮  -->
          <div
            v-model="isCollapse"
            class="is-collapse"
            :width="tabWidth + 'px'"
          >
            <img
              @click="isClose"
              :class="
                isCollapse ? 'el-icon-d-arrow-up' : 'el-icon-d-arrow-left'
              "
              src="https://studioroma.e.huawei.com/roma/assets/images/hic_list.png"
            />
          </div>
          <el-menu
            default-active="1-1"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            :collapse="isCollapse"
            background-color="#383e48"
            text-color="#fff"
            active-text-color="#fff"
            active-background-color="#383e48"
          >
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-s-platform"></i>
                <span slot="title">数据集成</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="1-1">
                  <!--  <i class="el-icon-location"></i>  -->
                  快速数据集成FDI
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-upload"></i>
                <span slot="title">服务集成</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="2-1">API网关</el-menu-item>
                <el-menu-item index="2-2">Live Data</el-menu-item>
                <el-menu-item index="2-3">API Market</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-eleme"></i>
                <span slot="title">消息集成</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="3-1">消息队列服务 MQS</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-s-marketing"></i>
                <span slot="title">环境管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="4-1">服务配置</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
        <!--  right  -->
        <el-container>
          <!-- little-aside-index   -->
          <el-aside
            id="little-aside-index"
            :width="tabWidth + 'px'"
            class="little-aside little-aside-none"
          >
            <div
              v-model="isCollapse"
              class="little-aside-title"
              :width="tabWidth + 'px'"
            >
              ROMA
            </div>
            <el-menu
              default-active=""
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose"
              background-color="#ebeff2"
              text-color="#000"
              active-text-color="#000"
              :collapse="isCollapse"
            >
              <el-submenu index="1">
                <template slot="title">
                  <span slot="title">资产包管理</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="1-1">
                    导出导入管理
                  </el-menu-item>
                </el-menu-item-group>
              </el-submenu>
            </el-menu>
          </el-aside>
          <!--  little-aside-fdi  -->
          <el-aside
            id="little-aside-fdi"
            :width="tabWidth + 'px'"
            class="little-aside"
          >
            <div
              v-model="isCollapse"
              class="little-aside-title"
              :width="tabWidth + 'px'"
            >
              FDI
            </div>
            <el-menu
              default-active=""
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose"
              background-color="#ebeff2"
              text-color="#000"
              active-text-color="#000"
              :collapse="isCollapse"
            >
              <el-menu-item index="1">
                <span slot="title">概述</span>
              </el-menu-item>
              <el-menu-item index="2">
                <span slot="title">数据源管理</span>
              </el-menu-item>
              <el-submenu index="3">
                <!--  <i class="el-icon-document"></i>  -->
                <span slot="title">任务管理</span>
                <el-menu-item-group>
                  <el-menu-item index="3-1">总体报告</el-menu-item>
                  <el-menu-item index="3-2">任务运行报告</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="4">
                <span slot="title">任务报告</span>
                <el-menu-item-group>
                  <el-menu-item index="4-1">数据字典</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
            </el-menu>
          </el-aside>
          <!--  content  -->
          <el-container>
            <!--  content-index  -->
            <el-main class="el-main-hae">
              <!--  概述-context  -->

              <div class="context">
                <!--  breadcrumb  -->
                <div id="breadcrumb" class="breadcrumb">
                  <span>
                    <span class="ant-breadcrumb-link">概述</span>
                    <span class="ant-breadcrumb-separator"></span>
                  </span>
                </div>
                <!--  hae_context  -->
                <div class="hae_validator">
                  <el-row :gutter="20">
                    <el-col
                      :span="8"
                      class="hae-col"
                      style="padding-left: 8px; padding-right: 8px;"
                    >
                      <div class="hae-card hae-card-count">
                        <div class="title">数据源总数</div>
                        <a class="content">7</a>
                      </div>
                    </el-col>
                    <el-col
                      :span="8"
                      class="hae-col"
                      style="padding-left: 8px; padding-right: 8px;"
                    >
                      <div class="hae-card hae-card-task">
                        <div class="title">定时任务数</div>
                        <a class="content">7</a>
                      </div>
                    </el-col>
                    <el-col
                      :span="8"
                      class="hae-col"
                      style="padding-left: 8px; padding-right: 8px;"
                    >
                      <div class="hae-card hae-card-taskcount">
                        <div class="title">实时任务数</div>
                        <a class="content">0</a>
                      </div>
                    </el-col>
                  </el-row>
                  <div class="hae_img">
                    <img src="/widget/images/intro.png" />
                  </div>
                  <el-table :data="tableData" style="width: 100%;">
                    <el-table-column prop="date" label="日期" width="180">
                    </el-table-column>
                    <el-table-column prop="name" label="姓名" width="180">
                    </el-table-column>
                    <el-table-column prop="address" label="地址">
                    </el-table-column>
                  </el-table>
                </div>
              </div>
            </el-main>
            <!--  数据源管理  -->
          </el-container>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  data () {
    return {
      msg: "Welcome to Your Vue.js App",
      isCollapse: false,
      // isCollapse2: false,
      tabWidth: 200,
      intelval: null,
      tableData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1518 弄"
        },
        {
          date: "2016-05-04",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1517 弄"
        },
        {
          date: "2016-05-01",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1519 弄"
        },
        {
          date: "2016-05-03",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1516 弄"
        }
      ]
    }
  },
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    },
    // 缩小aside
    isClose () {
      clearInterval(this.intelval)
      console.log('isClose')
      if (!this.isCollapse) {
        // console.log("缩小:"+this.isCollapse)
        this.intelval = setInterval(() => {
          if (this.tabWidth <= 64) {
            clearInterval(this.intelval)
          } else {
            this.tabWidth -= 2
            console.log(this.tabWidth)
          }
        }, 1)
      } else {
        // console.log("缩小:"+this.isCollapse)
        this.intelval = setInterval(() => {
          if (this.tabWidth >= 200) {
            clearInterval(this.intelval)
          } else {
            this.tabWidth += 2
            console.log(this.tabWidth)
          }
        }, 1)
      }
      this.isCollapse = !this.isCollapse
    },
    // 消息提示
    openMessage (msg) {
      this.$message({
        message: msg,
        type: 'success'
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#index_examples {
  width: 100%;
  height: 100%;
  background: #f5f5f5 !important;
  /* background: linear-gradient(0deg, #363859, #232040);   */
}
.clear {
  clear: both;
}
.display-none {
  display: none;
}
.main {
  background: #f5f5f5 !important;
}
/* el-header */
.header {
  height: 60px;
  min-width: 800px;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background: #353a3d !important;
  color: #fff;
  z-index: 80;
}
.header img {
  display: block;
  width: 55px;
  height: 30px;
  float: left;
  margin-top: 15px;
}
.header .header-title {
  display: inline;
  height: 30px;
  line-height: 30px;
  margin-left: 30px;
  margin-top: 15px;
  float: left;
}
/* dropdown */
.el-dropdown {
  cursor: pointer;
  float: right;
}
.el-dropdown-link {
  line-height: 60px;
  color: #f5f5f5;
}
.bottom {
  position: relative;
  top: 60px;
}
/* aside */
.master-aside {
  position: relative;
  top: 0px;
  right: 0;
  bottom: 0;
  left: 0;
  /* todo */
  overflow: auto;
  background: #383e48 !important;
}
/* 收缩按钮 */
.is-collapse {
  text-align: center;
  padding: 4px 0px 4px 0px;
  background: #4e5563 !important;
}
.is-collapse i {
  padding: 0px 0px 0px 0px;
}
/* 菜单 */
.el-menu {
  border-right: solid 0px #e6e6e6;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
  overflow: hidden;
}
.el-menu-item-group__title {
  padding: 0;
}
.el-submenu [class^="el-icon-"] {
  vertical-align: sub;
}
/* content */
.little-aside {
  position: relative;
  top: 0px;
  right: 0;
  bottom: 0;
  left: 0px;
  /* height: 100%; */
  overflow: auto;

  background: #ebeff2 !important;
}
.little-aside-none {
  display: none;
}
.little-aside .little-aside-title {
  text-align: left;
  padding: 10px 0px;
  padding-left: 22px;
  font-size: 13px;
  font-weight: bold;
  background: #d5dce0 !important;
}
.little-aside .el-menu-item,
.el-submenu__title {
  height: 45px;
  line-height: 45px;
}
.little-aside .el-submenu__title {
  font-size: 12px;
}
.little-aside .el-menu-item {
  font-size: 12px;
}

/* 概述内容 */
.el-main-hae {
  padding: 0;
  padding-left: 24px;
  padding-right: 24px;
  /* overflow-y: scroll; */
  /* height: 3000px; */
}
.context {
  overflow-y: auto;
}
/* 面包削 */
.breadcrumb {
  font-size: 12px;
  line-height: 48px !important;
}
.breadcrumb > span:first-child {
  border-left: 2px solid #0490d6;
  padding-left: 8px;
}
/* 具体内容 */
.hae_validator {
  padding-left: 24px;
  padding-right: 24px;
}
.hae-card {
  /* height: 120px; */
  background-color: rgba(90, 182, 204, 0.38);
  border-radius: 6px;
  color: #0490d6;
  padding: 24px;
}
.hae-card .title {
  font-size: 18px;
  font-weight: 600;
}
.hae-card .content {
  font-size: 35px;
  font-weight: 600;
  display: inline-block;
  padding-left: 20px;
}
.hae-card-count {
  color: #0490d6;
}
.hae-card-task {
  color: #e99f25;
}
.hae-card-taskcount {
  color: #e6607b;
}
.hae_img {
  padding-top: 50px;
  text-align: center;
}
/* 任务管理器 */
</style>
