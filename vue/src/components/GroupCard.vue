<template>
<div class="wrap">
  
        <div class="card">
             <img src="@/assets/lord.png" alt="not working">
          <div class="info">
            <div v-show="memberStatus">
              <router-link class="text-decoration-none"
              v-bind:to="{
              name: 'group-details',
              params: { groupID: this.group.groupId },
              }"
              >
              <div id="group-name" role="button">
              {{ group.groupName }}
              </div>
              </router-link>
              </div>
              <div v-show="!memberStatus">
                 <div id="join-button" role="button">
                   <join-group-form v-bind:group="group"/>
                  <!-- join -->
              </div>
            </div>
          </div>
        </div>
</div>
  
</template>

<script>
import GroupService from "../services/GroupService";
import JoinGroupForm from './JoinGroupForm.vue';
export default {
  components: { JoinGroupForm },
  name: "group-card",
  props: ["group"],
  data() {
    return {
      memberStatus : false
    }
  },

  methods: {
    getMemberStatus() {
      GroupService.getMemberByUsername(this.group.groupId, this.$store.state.user.username)
      .then (response => {
          this.memberStatus = response.data;
        }
      )
    },
  },
  
  mounted() {
   this.getMemberStatus();
  }
}
</script>
<style scoped>
v-card > a {
  text-decoration: none !important;

}
router-link a{
    text-decoration: none !important;
}
.wrap {
  width: 25vh;
  height: 40vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(240, 128, 128, 0.05);
}
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
  animation-duration: 5000s;
  animation-iteration-count: infinite;
  animation-timing-function: ease;
  transition: all;
}
#group-name {
  color: blanchedalmond;
  background: #0ead69;
}
#join-button {
  color: blanchedalmond;
  background-color: rgb(240, 128, 128);
}
.card img {
  width: 100%;
}
.info h4{
  color: white;
  padding: 10px 10px;
}

@keyframes x {
  0% {transform: rotateY(0deg) skewX(0deg);}
  25% {transform: rotateY(-0deg) skewX(-90deg);}
  50% {transform: rotateY(0deg) skewX(0deg);}
  75% {transform: rotateY(30deg) skewX(4deg);}
  100% {transform: rotateY(0deg) skewX(0deg);}

}

</style>