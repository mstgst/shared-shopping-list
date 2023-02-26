<template>
  <v-dialog
    @click="dialog = true"
        v-model="dialog"
        width="600px"
  >
  <template v-slot:activator="{ on, attrs }">
              <div v-bind="attrs"
                    v-on="on" class="card">
              <img src="@/assets/lord.png" alt="not working">
              <div class="info">
              <h4>Create List</h4>
              </div>
              </div>
        </template>
    
    <v-card class="form-card">
      <v-label>
        Create List
      </v-label>
      <form v-on:submit.prevent>
      <!-- <label for="title"></label> -->
      <v-text-field v-model="list.name" 
      placeholder="enter the name"
      />
      <label for="description"></label>
      <v-textarea v-model="list.description"
      placeholder="enter the description">
      </v-textarea>
      <v-btn @click="submit()" 
      color="rgb(255, 235, 205)" 
      elevation="15"
      >Create</v-btn>
    </form>
    </v-card>
  </v-dialog>
</template>

<script>
import ListService from "../services/ListService";

export default {
  name: "create-list-form",
  
  data() {
    return {
      dialog: false,
      list: {
          name:'',
          description: ''
      },
      listErrors: false,
      listErrorMsg: "There was a problem creating this list.",
    };
  },
  methods: {
    submit() {
      this.dialog = false;
      this.$router.go();
      if (this.list.name.length <= 0) {
        this.listErrors = true;
        this.listErrorMsg = "List name cannot be blank."
      } else {ListService.createList(this.$store.state.group.groupId, this.list)
     .then (response => {
              this.$store.commit("ADD_LIST", response.data);
      })
        //TODO: this can't be empty, else the user will never be able to navigate there
        //const data = response.dat
    }
    }
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
  background-color: blueviolet;
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
