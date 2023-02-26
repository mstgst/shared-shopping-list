<template>
  <div>
    <!-- <div>{{group.groupName}}</div> -->
    <form action="">
      <div>{{ group.groupName }}</div>
      <button v-show="memberStatus" @click.prevent="removeMemberFromGroup">
        Leave Group
      </button>
    </form>
  </div>
</template>

<script>
import GroupService from "../services/GroupService";
export default {
  name: "leave-group-form",
  data() {
    return {
      memberStatus: {
        type: Boolean,
        default: false,
      },
    };
  },

  methods: {
    removeMemberFromGroup() {
      GroupService.removeUser(this.group.groupId).then(() => {
        this.$router.push("/");
      });
    },
  },
  computed: {
    group() {
      return this.$route.params.group;
    },
  },
  // created() {
  //     showIfMemberOfGroup(this.$route.params.group) {
  //         if(this.)
  //     }
};
</script>

<style></style>
