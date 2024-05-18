<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'app',
  components: {
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0
}
html {
  font-size: 16px;
  font-family: '微软雅黑', Helvetica, Arial, sans-serif
}
#app {
  color: #2c3e50
}
</style>
