<template>
  <div id="home">
    <el-container>
      <base-header></base-header>
      <router-view class="me-container"/>
      <base-footer></base-footer>
    </el-container>
  </div>
</template>

<script>
  import BaseFooter from "@/components/BaseFooter";
  import BaseHeader from "@/components/BaseHeader";

    export default {
      name: "Home",
      components: {
          'base-footer':BaseFooter,
          'base-header':BaseHeader
      },
      beforeRouteEnter (to, from, next){
        next(vm => {
          vm.activeIndex = to.path
        })
      },
      beforeRouteUpdate (to, from, next) {
        if(to.path == '/'){
          this.footerShow = true
        }else{
          this.footerShow = false
        }
        this.activeIndex = to.path
        next()
      }
    }


</script>

<style>
  .me-container{
    margin: 100px auto 140px;
  }
</style>
