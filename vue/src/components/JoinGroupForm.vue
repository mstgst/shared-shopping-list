<template>
  <v-dialog @click="dialog = true" v-model="dialog">
    <template v-slot:activator="{ on, attrs }">
      <div
        v-bind="attrs"
        v-on="on">
        {{group.groupName}}
      </div>
    </template>
    <v-card class="form-card">
      <v-label> Enter Group code </v-label>
        <form v-on:submit.prevent="addUser">
        <v-text-field v-model="inviteCode" placeholder="invite code" />
        <label for="description"></label>
        <v-btn @click="submit()" color="rgb(255, 235, 205)" elevation="15"
          >Submit</v-btn>
      </form>
    </v-card>
    
  </v-dialog>
</template>
<script>
import GroupService from "../services/GroupService";
export default {
  name: "join-group-form",
  props: ["group"],
  data() {
    return {
      listComplete: false,
      dialog: false,
      inviteCode: "",
      listErrors: false,
      listErrorMsg: "There was a problem joining this group.",
    };
  },
  methods: {
    submit() {
      if (this.group.groupCode != this.inviteCode) {
        this.joinErrors = true;
        this.joinErrorMsg = "Invalid invite code.";
      } else {
        GroupService.addUser(
          this.group.groupId,
          this.inviteCode,
          this.group.groupCode
        )
        .then(() => {
          this.$router.push(`/groups/${this.group.groupId}`);
        })
        .catch((error) => {
          const response = error.response;
          this.joinErrors = true;
          if (response.status === 400) {
            this.joinErrorMsg = error.response.data.message;
          }
        });
      }
    },
  },
};
</script>
<style scoped>
.form-card {
  padding: 5%;
}
</style>