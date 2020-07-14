<template>
    <el-header class="me-area">
      <el-row>

        <el-col :span="4" class="me-header-left">
          <router-link to="/" class="me-title"><!--点击logo回到首页-->
            <img src="../assets/img/logo.png"/>
          </router-link>
        </el-col>

        <el-col v-if="!simple" :span="16">
          <!--router为true,激活导航时以 index 作为 path 进行路由跳转-->
          <!--menu-trigger:子菜单打开的触发方式(只在 mode 为 horizontal 时有效)-->
          <el-menu :router="true" menu-trigger="click" active-text-color="#5FB878" mode="horizontal">
            <el-menu-item index="/">首页</el-menu-item>
            <el-menu-item index="/category/all">文章分类</el-menu-item>
            <el-menu-item index="/tag/all">标签</el-menu-item>
            <el-menu-item index="/archives">文章归档</el-menu-item>
            <el-menu-item index="/log">日志</el-menu-item>
            <el-menu-item index="/messageBoard">留言板</el-menu-item>

            <el-col :span="4">
              <el-menu-item index="/write"><i class="el-icon-edit"></i>写文章</el-menu-item>
            </el-col>

            </el-menu>
        </el-col>

        <template v-else>
          <slot></slot>
        </template>

        <el-col :span="4">
          <el-menu :router="true" menu-trigger="click" mode="horizontal" active-text-color="#5FB878">


            <template v-if="!user.login">
            <el-menu-item index="/login">
              <el-button type="text">登录</el-button>
            </el-menu-item>
            <el-menu-item index="/register">
              <el-button type="text">注册</el-button>
            </el-menu-item>
          </template>

          <template v-else>
            <el-submenu index>
              <template slot="title">
                <img class="me-header-picture" :src="user.avatar"/>
              </template>
              <el-menu-item index @click="logout"><i class="el-icon-back"></i>退出</el-menu-item>
            </el-submenu>
          </template>


          </el-menu>
        </el-col>
      </el-row>
    </el-header>
</template>

<script>
    export default {
      name: "BashHeader",
      props: {
        activeIndex: String,
        simple: {
          type: Boolean,
          default: false
        }
      },
      data(){
        return {}
      },
      //显示用户名和头像的参数
      computed: {
        user() {
          let login = this.$store.state.account.length != 0
          let avatar = this.$store.state.avatar
          console.log("login:"+login)
          return {
            login, avatar
          }
        }
      },
      methods: {
        logout() {
          let that = this
          this.$store.dispatch('logout').then(() => {
            this.$router.push({path: '/'})
          }).catch((error) => {
            if (error !== 'error') {
              that.$message({message: error, type: 'error', showClose: true});
            }
          })
        }
      }
    }

</script>

<style>
  .el-header {
    position: fixed;
    z-index: 1024;
    min-width: 100%;
    box-shadow: 0 2px 3px hsla(0, 0%, 7%, .1), 0 0 0 1px hsla(0, 0%, 7%, .1);
  }

  .me-header-left {
    margin-top: 10px;
  }

  .me-title {
    margin-top: 10px;
    font-size: 24px;
  }
  /*左上角图片大小设置*/
  .me-title img {
    max-height: 2.4rem;
    max-width: 100%;
  }
</style>
