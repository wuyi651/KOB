<template>
  <div>
    <div>Bot name :</div>
    <div>Bot Battle Power :</div>
  </div>
  <router-view/>
</template>


<script>
export default {
  name:"App",
  setup:() => {

  }
}
</script>


<style>
body {
  background-image: url("@/assets/background.png");
  background-size: cover;
}
</style>

