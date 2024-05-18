<template>
  <div>
    <el-container class="my-wrap">
      <el-header>
        <h1>私人财物费用定制管理系统</h1>   
      </el-header>


      <el-container>

        <el-aside width="200px">
          <myMenuItem/>
        </el-aside>

        <el-main
          v-loading="isLoading"
          element-loading-text="拼命加载中"
          element-loading-spinner="el-icon-loading"
          element-loading-background="rgba(0, 0, 0, 0.8)"
        >
          <router-view v-on:loading = "loading"/>
        </el-main>
        
      </el-container>

      <el-footer height="30px">
        <h1>lhw199911@outlook.com|2024.04.09|个人实战</h1>
      </el-footer>

      </el-container>
  </div>
</template>

<script>
import myMenuItem from '@/components/menu'

export default {
  name: 'MyIndex',
  components: {
    myMenuItem
  },
  data () {
    return {
      isLoading: false
    }
  },
  methods: {
    loading: function (loading) {
        this.isLoading = loading
      }
  }
}
</script>

<style scoped lang="less">
@my-border: 1px solid #000;
.my-wrap{
  background: #ccc;
  height: 100vh;
  width: 100vw;
  .el-aside{
  border-right: @my-border;
  overflow-x: hidden;
  }
  .el-header{
    border-bottom: @my-border;
    h1{
      line-height: 60px;
      font-size:2rem;
      letter-spacing: 1rem;
      text-align: center
    }
  }
  .el-footer{
    border-top: @my-border;
    h1{
      font-family: "Courier New", Courier, monospace;
      line-height: 29px;
      font-size:1rem;
      letter-spacing: 0.3rem;
      text-align: center;
    }
  }
}
</style>