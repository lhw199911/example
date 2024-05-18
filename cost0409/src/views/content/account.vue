<template>
  <div>
    <div class="topLabel">
        <el-button class="addUser" type="warning" @click="delUser">删除</el-button>
        <el-button class="addUser" type="primary" @click="addUser">添加</el-button>
        <el-input
        class="search"
        placeholder="请输入搜索内容"
        v-model="pageQuery.likeVal"
        style="width: 200px; margin-bottom: 10px;"
        >
        <el-button slot="append" icon="el-icon-search" @click="getListUsers"></el-button>
    </el-input>
    </div>
    <el-table :data="tableData.records">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="icon" label="头像"></el-table-column>
      <el-table-column prop="phone" label="电话"></el-table-column>
      <el-table-column prop="email" label="邮箱"></el-table-column>
      <el-table-column prop="active" label="是否存活">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.active" type="info">
            有效
          </el-tag>
          <el-tag v-if="!scope.row.active" type="warning">
            无效
          </el-tag>
        </template>

      </el-table-column>
    </el-table>

    <el-pagination
      :current-page.sync="pageQuery.pageFrom"
      :page-sizes="pageQuery.pageSizes"
      :page-size.sync="pageQuery.pageNum"
      :page-count="tableData.pages"
      layout="total, sizes, prev, pager, next, jumper"
      :total="tableData.total"
      @size-change="getListUsersSizeChange"
      @current-change="getListUsers"
    />

    <el-dialog :title="dialog.title" :visible.sync="dialog.isShow" width="30%">
      <component :is="dialog.component" v-on:formData="getFromData"/>
    </el-dialog>
  </div>
</template>

<script>
import { list_Users, add_User } from "@/pluginsAxios/request";

export default {
  name: "users",
  data() {
    return {
      tableData: [],
      pageQuery: {
        pageFrom: 0,
        pageNum: 10,
        likeVal: "",
        pageSizes: [5, 10, 20, 50],
      },
      dialog: {
        title: "",
        isShow: false,
        component: () => import("@/components/account/edit"),
      },
    };
  },
  created() {
    this.getListUsers();
  },
  methods: {
    getListUsersSizeChange() {
      this.pageQuery.pageFrom = 0;
      this.getListUsers();
    },

    // 分页查询
    getListUsers() {
      this.$emit("loading", true);
      list_Users(
        this.pageQuery.pageFrom,
        this.pageQuery.pageNum,
        this.pageQuery.likeVal
      )
        .then((res) => {
          if (res.data.code == 200) {
            this.tableData = res.data.data;
          } else {
            this.$message.error(res.data.message);
          }
        })
        .catch((err) => {
          this.$message.error(err.message);
        })
        .finally(() => this.$emit("loading", false));
    },

    // 添加用户
    addUser() {
      this.dialog.title = "添加用户";
      this.dialog.isShow = true;
    },

    getFromData(formData){
        const param = new FormData();
        for(let key in formData) {
            param.append(key, formData[key]);
        }
        add_User(param).then(res=>{
            this.getListUsers();
            this.$message.success(res.data.message);
        }).catch((err) => {
            this.$message.error(res.data.message);
        }).finally(()=>{
            this.dialog.isShow = false;
        }
        )
    },

    // 删除用户
    delUser(){
    }

  },
};
</script>

<style lang="less" scoped>
.el-pagination {
  text-align: right;
}
.addUser {
  float: right;
}
.topLabel{
  float: right;
}
.topLabel>.el-button{
    margin-left: 20px;
}
</style>