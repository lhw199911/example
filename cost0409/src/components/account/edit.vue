<template>
  <div>
    <el-form v-model="formData" label-width="40px">
      <el-form-item label="名称">
        <el-input v-model="formData.name" placeholder="请输入名称"></el-input>
      </el-form-item>
      <el-form-item label="电话">
        <el-input v-model="formData.phone" placeholder="请输入电话"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="formData.email" placeholder="请输入邮箱"></el-input>
      </el-form-item>
      <el-form-item label="头像">
        <el-upload
          :auto-upload="false"
          list-type="picture-card"
          action="#"
          :multiple="false"
          :limit="1"
          :on-change="changeImg"
          :on-remove="removeImg"
        >
          <i class="el-icon-plus"></i>
        </el-upload>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="formData.password" placeholder="请输入密码"></el-input>
      </el-form-item>
    </el-form>
    <div class="btn">
        <el-button type="warning" @click="submit">提交</el-button>
        <el-button type="primary" @click="toEmpty">重置</el-button>
    </div>
  </div>
</template>

<script>

export default {
  name: "edit",
  data() {
    return {
      formData: {
        name: "",
        phone: "",
        email: "",
        icon: null,
        password: "",
      },
    };
  },
  methods: {
    submit() {
      this.$emit("formData", this.formData);
    },
    toEmpty(){
      for(var key in this.formData){
          this.formData[key] = "";
      }
    },
    changeImg(file){
      this.formData.icon = file.raw
    },
    removeImg(){
      this.formData.icon = null
    }
  },
};
</script>

<style lang=less scoped>
.el-input {
  margin-bottom: 20px;
}
.btn{
    text-align: center;
}
</style>
