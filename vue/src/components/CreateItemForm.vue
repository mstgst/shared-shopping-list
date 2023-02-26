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
                <h4>Create Item</h4>
              </div>
              </div>
            </div>
        </template>
    <v-card class="form-card">
      <v-form v-on:submit.prevent>
        <div class="field">
          <label for="name">Name</label>
          <v-text-field placeholder="name" v-model="item.name" />
        </div>
        <div class="field">
          <label for="quantity">Quantity</label>
          <v-text-field placeholder="quantity" v-model.number="item.quantity"/>
        </div>
        <v-row justify="center">
                 <v-btn @click="submit()" color="rgb(255, 235, 205)" elevation="2">Create</v-btn>
              </v-row>
      </v-form>
    </v-card>
  </v-dialog>
</template>

<script>
import ItemService from "../services/ItemService";

export default {
  name: "create-item-form",
  data() {
    return {
      dialog: false,
      item: {
          quantity:'',
          name: ''
      },
    };
  },
  methods: {
    submit() {
      this.dialog = false;
      console.table(this.$store.state.list)
      ItemService.createItem(this.list.groupId, this.list.listId, this.item)
      .then(r => {
        console.warn(r)
        if (r == 201) {
          

        this.$store.commit("ADD_ITEM", r.data)
        this.$router.go()
       }})
    },
  },
   computed: {

    list() {
      return this.$store.state.list.find(l => 
        l.listId == this.$route.params.listID
    )
    }
    },
};
</script>
<style scoped>
.form-card{
padding: 5%;
}
.wrap {
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: lightcoral
}
.card {
  width: 260px;
  min-height: 200px;
  background: #2B2B2B;
  border-radius: 10px;
  padding: 6px;
   font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  animation-name: x;
  animation-duration: 3s;
  animation-iteration-count: infinite;
  animation-timing-function: ease;
  transition: all;
}
.card img {
  width: 100%;
}
.info h4{
  color: white;
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
