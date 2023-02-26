<template>
  <div>
    <div id="nav">
      <v-toolbar app>
        <v-toolbar-title id="title">
         \ {{ appTitle }} \ members
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn
            v-for="item in menuItems"
            :key="item.title"
            :to="item.path"
          >
            {{ item.title }}
          </v-btn>
        </v-toolbar-items>
      </v-toolbar>
    </div>
    <br> <br> <br>
    <div class='members' v-for="(member, index) in $store.state.members" :key="index">
       <div class="wrap">
        <div class="card">
             <img src="@/assets/lord.png" alt="not working">
          <div class="info">
            <h4>{{member.username}}</h4>
        </div>
        </div>
        </div>
        </div>
  </div>
</template>

<script>
import GroupDetails from "./GroupDetails.vue";
export default {
  component: { GroupDetails },
  name: "group-members",
  data() {
    return {
      appTitle: "Fridgrr",
      menuItems: [
        { title: "group", path: "/groups" },
        { title: "members", path: "/members" },
        { title: "logout", path: "/" },
        
      ],
    };
  },
};
</script>

<style>
#title {
  font-family: "Courier New", Courier, monospace;
  font-size: 50px;
  font-weight: bold;
  color: blanchedalmond;
  text-shadow: 1.5px 1.5px 0px lightcoral;
}
.v-btn__content {
  font-family: "Courier New", Courier, monospace;
  font-size: 15px;
  font-weight: bolder;
}
.v-toolbar__content {
  background-color: #0ead69;
}
.wrap {
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(240, 128, 128, 0.667)
}
.card {
  width: 260px;
  min-height: 200px;
  background: #2B2B2B;
  border-radius: 10px;
  padding: 6px;
  font-family:    'Courier New', Courier, monospace;
  font-size: 16pt;
  animation-name: x;
  animation-duration: 5s;
  animation-iteration-count: infinite;
  animation-timing-function: ease;
  transition: all;
}
.card img {
  width: 100%;
}
.info h4{
  color: blanchedalmond;
  padding: 0 10px;
}

@keyframes x {
  0% {transform: rotateY(0deg) skewX(0deg);}
  25% {transform: rotateY(-30deg) skewX(-4deg);}
  50% {transform: rotateY(0deg) skewX(0deg);}
  75% {transform: rotateY(30deg) skewX(4deg);}
  100% {transform: rotateY(0deg) skewX(0deg);}
}
</style>

