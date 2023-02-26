<template>
<html>
  <header>
  <v-toolbar app>
        <v-toolbar-title id="title">
          \ {{ appTitle }} \ {{this.$store.state.user.username}}
        </v-toolbar-title>
  <v-spacer></v-spacer>
      <v-toolbar-items>
        <v-btn
          v-for="item in menuItems"
          :key="item.title"
          :to="item.path">
          \ {{ item.title }}
        </v-btn> 
      </v-toolbar-items>
</v-toolbar>
</header>
<body>
  <group-list/>
</body>
      
  </html>

</template>


<script>
import GroupList from '../components/GroupList.vue'
export default {
    name: 'groups',
components: {GroupList},
data(){
    return {
      appTitle: 'Fridgrr',
      menuItems: [
          { title: 'group', path: '/groups' },
          { title: 'logout', path: '/' },
     ],
    }
  }

}
</script>

<style>
#title{
  font-family:    'Courier New', Courier, monospace;
  font-size:      50px;
  font-weight:    bold;
  color:          blanchedalmond;
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
body{
  background-color: rgba(240, 128, 128) !important;
  min-height: 100vh;
  text-align: center;
}
.v-application--wrap {
    background-color: rgb(240, 128, 128)!important;
    height: 100%;
    text-align: center;
}
</style>