<template>
<body>
  <br>
  <br>
  <br>
  <v-app>
      <div id ="container">
        <create-group-card/>
        <group-card
          v-for="group in groups"
          v-bind:key="group.groupId"
          v-bind:group="group" />
      </div>
  </v-app>
</body>
  
</template>

<script>
import GroupService from "../services/GroupService";
import CreateGroupCard from './CreateGroupCard.vue';
import GroupCard from "./GroupCard.vue";

export default {
  components: { GroupCard, CreateGroupCard },
  name: "group-list",
  data() {
    return {
      groups: [],
    };
  },
  created() {
    GroupService.getGroups().then((response) => {
      this.groups = response.data;
    });
  },
};
</script>

<style>
body {
  background-color: rgba(240, 128, 128, 0.31) !important;
}
#container{
  display: grid;
  align-items: center;
  grid-template-columns: repeat(4,1fr) 1px;
  grid-gap: 3%;
  box-sizing: border-box;
  white-space: nowrap;
  text-overflow: ellipsis;
  height: 350px;
  max-width: 260px;
  font-size: 200%;
  font-family: 'Courier New', Courier, monospace;
  font-weight: bolder;
  padding: 2%; 
}
div.wrap{
  max-width: 250px;
  margin-bottom: 120px;
  margin-inline: 12px;
}
.v-application--wrap{ 
  background-color: rgba(240, 128, 128, 0.667);
  height: 100%; 
  text-align: center;
}
</style>
