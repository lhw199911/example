<template>
    <div>
        <el-menu router>
            <el-menu-item index="/">总体概览</el-menu-item>
            <el-submenu index="content">
                <template slot="title">管理</template>
                <el-menu-item index="/content/account">用户管理</el-menu-item>
                <el-menu-item index="/content/outcome">花费管理</el-menu-item>
                <el-menu-item index="/content/income">收入管理</el-menu-item>
            </el-submenu>
            <el-submenu index="setting">
                <template slot="title">设置</template>
                <el-menu-item index="/setting/account">账户设置</el-menu-item>
            </el-submenu>
        </el-menu>
    
    </div>
</template>

<script>
export default{
    name:'myMenu'
}
</script>

<style scoped>
</style>