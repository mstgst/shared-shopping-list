<template>

  <div>
    <h1>Welcome, {{ $store.state.user.username }}.</h1>
      <group-list />
  </div>
</template>

<script>
// import GroupList from "../components/GroupList.vue";
// import Login from './Login.vue';
export default {
  components: {  },
  name: "home",
  data(){
    return {
      appTitle: 'Fridgrr',
      menuItems: [
          { title: 'group', path: '/groups' },
          { title: 'logout', path: '/login' },
     ],
    }
  }
};
</script>

<style>
#filter {
  display: flex;
}
#title{
  font-family:    'Courier New', Courier, monospace;
  font-size:      50px;
  font-weight:    bold;
  color:          whitesmoke;
  text-shadow: 1.5px 1.5px 0px lightcoral;
}
.v-btn__content{
  font-family:    'Courier New', Courier, monospace;
  font-size:      15px;
  font-weight:    bolder;
}
.v-toolbar__content{
  background-color: #0EAD69;
}
</style>
