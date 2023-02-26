<template>
      <v-dialog @click="dialog = true"
        v-model="dialog"
        width="600px"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            v-bind="attrs"
            v-on="on"
          >
          Edit
          </v-btn>
        </template>
  
        <v-card class="form-card">
              <v-form v-on:submit.prevent>
              <div>
                 <label for="quantity">Quantity</label>
                 <v-text-field
                 placeholder="quantity"
                  v-model="quantity"
                  type="number"
                  />
              </div>
              <div>
                <label for="name">Name</label>
                <v-text-field
                  v-model="name"
                  id ="name"/>
              </div>
              <v-btn @click="submit()" type="submit">Save</v-btn>
            </v-form>
        </v-card>
      </v-dialog>
</template>
<script>
import ItemService from '../services/ItemService'

export default {
  name: 'edit-item-form',
  props :['itemID'],
  data () {
    return {
      dialog: false,
      quantity: 1,
      name: '',
    }
    },
    methods : {
     submit() {
      this.item.quantity = this.quantity;
      this.item.itemName = this.name;
      ItemService.editItem(this.item)
    },
    log () {
    }
    },
   computed : {
      item () {
        return this.$store.state.items.find (i => 
          i.itemId = this.itemID
        )
      }
   }
  }
</script>
