<template>
  <html>

    <header>
          <v-toolbar app>
      <v-toolbar-title id="title">
          \ {{ appTitle }}  \ {{this.$store.state.user.username}} \ {{this.$store.state.group.groupName}} \ {{listName}}
      </v-toolbar-title>
    
      <v-spacer></v-spacer>
      <v-toolbar-items>
        <v-btn
          v-for="item in menuItems"
          :key="item.title"
          :to="item.path">
          {{ item.title }}
        </v-btn> 
      </v-toolbar-items>
</v-toolbar> 
    </header>
    <body>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
       <div id ="container" data-app >
         <create-item-form/>
         <div @click="claimList()" v-show="$store.state.claimStatus == 'showClaim'" class="wrap">
           <div class="card">
            <img src="@/assets/lord.png" alt="not working">
                <div class="info">
                <h4>Claim List</h4>
                </div>
         </div>
         </div>
           <div @click="unclaimList()" v-show="$store.state.claimStatus == 'showUnclaim'" class="wrap">
           <div class="card">
            <img src="@/assets/lord.png" alt="not working">
                <div class="info">
                <h4>Unclaim</h4>
                </div>
         </div>
         </div>
        </div>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      {{showClaim}}
      
       <div id="container">
          <item-card
        v-for="item in items"
        v-bind:key="item.dateModified"
        v-bind:itemID="item.itemId"
        :class="{complete : listComplete==true}"
      />
     </div>
    </body>
     </html>
</template>

<script>
import ItemService from "../services/ItemService";
import ListService from '../services/ListService';
//import ListService from "../services/ListService";
import CreateItemForm from "./CreateItemForm.vue";
import ItemCard from "./ItemCard.vue";
export default {
  components: { ItemCard, CreateItemForm },
  name: "list-details",
  data() {
    return {
      showClaim: '',
      appTitle: 'Fridgrr',
      menuItems: [
          { title: 'group', path: '/groups' },
          { title: 'members', path: '/members'},
            { title: 'logout', path: '/' },
             ]
    };
  },
  methods: {
  
    getItems() {
      console.log('getting items')
      ItemService.getItems(
        this.$route.params.groupID,
        this.$route.params.listID
      ).then((response) => {
        this.$store.commit("SET_ITEMS", response.data);
      });
    },
    claimList() {
      ListService.claimList(this.list.groupId, this.list.listId).then(this.$router.go())
    },
    unclaimList() {
      ListService.unclaimList(this.list.groupId, this.list.listId).then(this.$router.go())
    },
    setClaimStatus () { 
      console.log('get claim', this.$store.state.user.id, this.list.claimedId)
      if (this.$store.state.user.id == this.list.claimedId && this.claimedId != 0) {
          this.$store.commit("SET_CLAIM_STATUS", 'showUnclaim')
        }

      if (this.list.claimedId == 0) {
        this.$store.commit("SET_CLAIM_STATUS", 'showClaim')
      }
      
    },
    
  
  },
  mounted() {
    console.log('mounted')
    this.getItems()
    console.warn('first')
    this.listName = this.list.listName;
    console.log('second')
    console.log('get claim')
      if (this.$store.state.user.id == this.list.claimedId && this.claimedId != 0) {
          this.$store.commit("SET_CLAIM_STATUS", 'showUnclaim')
        }

      if (this.list.claimedId == 0) {
        this.$store.commit("SET_CLAIM_STATUS", 'showClaim')
      }
  },
  updated() {
    console.log('updated')
      this.setClaimStatus();
  },

  computed: {
    list() {
      return this.$store.state.list.find(
        (l) =>
          l.listId == this.$route.params.listID
      );
    },
    items() {
      console.log('items in state', this.$store.state.items)
      return this.$store.state.items;
    },
  },
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
  text-shadow: 1.5px 1.5px 0px rgba(240, 128, 128, 0.349);
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

.theme--light.v-btn.v-btn--has-bg {
    background-color: #0EAD69;
}

#container {
  display: grid;
  grid-template-columns: repeat(4,1fr) 60px;
  grid-gap: 3%;
  box-sizing: border-box;
  gap: 50px;
  width: 100%;
  height: 50px;
}
.wrap {
  width: 30vw !important;
  height: 25vh !important;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(240, 128, 128, 0.03) !important;
}
.complete {
  text-decoration-line: overline;
}
#toggleClaim {
  
  
}

</style>