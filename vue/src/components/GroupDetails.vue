<template>
  <html>
    <header>
      <v-toolbar app>
        <v-toolbar-title id="title">
          \ {{ appTitle }} \ {{ this.$store.state.user.username }} \
          {{ group.groupName }}
        </v-toolbar-title>

        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn
            color="blanchedalmond"
            v-for="item in menuItems"
            :key="item.title"
            :to="item.path">
            {{ item.title }}
          </v-btn>
        </v-toolbar-items>
      </v-toolbar>
    </header>

    <body>
        <div data-app class="wrap">
          <div class="card">
            <img src="@/assets/lord.png" alt="not working">
            <div class ="info">
            <h5 > Group Code: {{group.groupCode}} </h5>
             </div>
             </div>
          <create-list-form/>
              <div v-show="!isOwner" @click="removeUser()" class="card">
                <img src="@/assets/lord.png" alt="not working">
                  <div class="info">
                  <h4>Leave Group</h4>
              </div>
          </div>
        </div>
      <list-container v-bind:groupId="$route.params.groupID" />
    </body>
  </html>
</template>

<script>
import MemberService from "../services/MemberService";
import GroupService from "../services/GroupService";
import ListContainer from "./ListContainer.vue";
import CreateListForm from"./CreateListForm.vue"
export default {
  components: { ListContainer, CreateListForm },

  name: "group-details",
  props: {
    groupID: {
      type: Number,
      default: 0,
    },
  },
  data() {
    return {
      isOwner: false,
    appTitle: 'Fridgrr',
        menuItems: [
          { title: 'groups', path: '/groups' },
          { title: 'members', path: '/members'},
          { title: 'logout', path: '/' },
     ],
    groupErrors: false,
    groupErrorMsg: "There was a problem that prevented this action from completing."
   };
  },
  methods: {
    retrieveGroup() {
      GroupService.getGroup(this.$route.params.groupID).then((response) => {
        this.$store.commit("SET_CURRENT_GROUP", response.data);
      });
    },

    removeUser() {
      GroupService.removeUser(this.$route.params.groupID)
        .then(() => this.$router.push("/groups"))
        .catch((error) => {
          const response = error.response;
          this.groupErrors = true;
          if (response.status === 400) {
            this.groupErrorMsg = error.response.data.message;
          }
        });
    },
    retrieveMembers() {
      MemberService.getMembers(this.$route.params.groupID).then((response) => {
        this.$store.commit("SET_CURRENT_MEMBERS", response.data);
      });
    },

    groupDate() {
      GroupService.getGroupCreatedDate(this.group.groupID);
    },
    getMembers() {
      console.log("test");
    },
  },

  created() {
    this.retrieveGroup();
    this.retrieveMembers();
  },
  mounted () {
     if (this.$store.state.user.id == this.$store.state.group.ownerId) {
      this.isOwner = true;
      console.log('here')
    }
  },
  computed: {
    group() {
      return this.$store.state.group;
    },
    members() {
      return this.$store.state.members;
    },


  },
};
</script>

<style scoped>
#title {
  font-family: "Courier New", Courier, monospace;
  font-size: 50px;
  font-weight: bold;
  color: blanchedalmond;
   background-color: rgba(240, 128, 128, 0.06);
}
.v-btn__content {
  font-family: "Courier New", Courier, monospace;
  font-size: 15px;
  font-weight: bolder;
}
.v-toolbar__content {
  background-color: #0ead69;
}
.theme--light.v-btn.v-btn--has-bg {
  background-color: #0ead69;
}
/* .wrap {
  width: 30vw;
  height: 25vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(240, 128, 128, 0.01);
} */
div.wrap{
  max-width: 250px;
  margin-bottom: 10px;
  margin-inline: 12px;
}
body{
  background: rgba(240, 128, 128, 0.1);
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
  padding-left: 2%; 
}
.card{
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
.info h4{
  color: blanchedalmond;
  background-color: blueviolet;
  padding: 0 10px;
}
.info h5{
  color: blanchedalmond;
  background-color: rgb(253, 109, 26);
  padding: 0 10px;
}

</style>
