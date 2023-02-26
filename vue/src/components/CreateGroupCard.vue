<template>
      <v-dialog @click="dialog = true"
        v-model="dialog"
        width="600px"
      >
        <template v-slot:activator="{ on, attrs }"> 
            <div v-bind="attrs"
            v-on="on" class="wrap">
              <div class="card">
                <img src="@/assets/lord.png" alt="not working">
                <div class="info">
                <h4>Create Group</h4>
              </div>
              </div>
            </div>
        </template>
  
        <v-card class="form-card">
              <v-label>
              Create Group
            </v-label>
              <v-form v-on:submit.prevent>
              <v-text-field
              label="Name"
              placeholder="enter the group name"
              v-model="group.groupName"/>
              <v-textarea
              label="Description"
              placeholder="enter the description"
              v-model="group.groupDescription">
              </v-textarea>
              <v-row justify="center">
                 <v-btn @click="createGroup()" color="primary" elevation="2">Create</v-btn>
              </v-row>
            </v-form>
        </v-card>
      </v-dialog>
</template>

<script>
import GroupService from "../services/GroupService";

export default {
  name: "create-group-card",
  data() {
    return {
      dialog: false,
      group: {
        groupDescription: "",
        groupId: "",
        groupName: "",
        groupOwnerId: "",
        groupCode: "",
      },
      groupErrors: false,
      groupErrorMsg: "There was a problem creating this group."
    };
  },
  methods: {
    createGroup() {
      GroupService.createGroup(this.group).then((response) => {
        if (response.status == 201) {
          this.dialog = false
          this.$router.go({path: '/groups'})
        }
      });
    },
  },
};
</script>
<style scoped>
.form-card{
  padding: 5%;
}
.wrap {
  width: 25vh;
  height: 40vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(240, 128, 128, 0.05);}
    
.card {
  width: 260px;
  min-height: 200px;
  background: #0ead69;
  box-shadow:0px 2px 1px 2px blanchedalmond;
  border-radius: 4px;
  padding: 8px;
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
  font-size: 16pt;
  background-color: blueviolet;
  padding: 10px 10px;
}

@keyframes x {
  0% {transform: rotateY(0deg) skewX(0deg);}
  25% {transform: rotateY(-30deg) skewX(-4deg);}
  50% {transform: rotateY(0deg) skewX(0deg);}
  75% {transform: rotateY(30deg) skewX(4deg);}
  100% {transform: rotateY(0deg) skewX(0deg);}
}
</style>