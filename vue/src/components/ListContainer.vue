<template>
    
    <div id="container">
       <list-card
      v-for="list in lists"
      v-bind:key="list.listId"
      v-bind:list="list" />
    </div>
</template>

<script>
import ListService from "../services/ListService";
import ListCard from "./ListCard.vue";
export default {
  components: { ListCard,  },

  name: "list-container",


  data() {
    return { 
      appTitle: 'Fridgrr',
      menuItems: [
          { title: 'group', path: '/groups' },
          { title: 'logout', path: '/' },
     ], 
     };
  },
  methods: {
    getLists() {
     ListService.getLists(this.$route.params.groupID)
      .then((response) => {
        this.$store.commit("SET_CURRENT_LISTS", response.data)
        console.log(this.$store.state.list)
     });
    },
  },
  created() {

    this.getLists();
    console.log(this.$route.params.groupID)
  },

  computed: {
    lists() {
       return this.$store.state.list;
    }
  },
};
</script>

<style scoped>
#container {
  display: grid;
  grid-template-columns: repeat(4,1fr) 60px;
  grid-gap: 3%;
  box-sizing: border-box;
  gap: 50px;
  width: 100%;
  height: 50px;
}
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
.wrap {
  width: 25vh;
  height: 25vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(240, 128, 128, 0.05);}
  
  #container {
  display: grid;
  align-items: center;
  grid-template-columns: repeat(5,1fr) 60px;
  grid-gap: 3%;
  box-sizing: border-box;
  white-space: nowrap;
  text-overflow: ellipsis;
  height: 150px;
  max-width: 400px;
  font-size: 200%;
  font-family: 'Courier New', Courier, monospace;
  font-weight: bolder;
  text-decoration-line: none;
  padding: 2%; 
}

</style>
