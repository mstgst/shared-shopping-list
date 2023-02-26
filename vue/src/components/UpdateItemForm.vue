<template>
  <form v-on:submit.prevent="submit">
    <div class="field">
      <h2>Item</h2>
      <label for="name">Name:</label>
      <textarea v-model="newTitle" />
    </div>
    <div class="field">
      <label for="quantity">Quantity:</label>
      <textarea v-model.number="newQuantity"></textarea>
    </div>
    <div class="actions">
      <button type="submit" @click="$router.push('/updateItemForm')" role="link">Update</button>
    </div>
  </form>
</template>

<script>
// import ItemService from '../services/ItemService'
export default {
    name: 'update-item-form',

    
    
}
</script>

<style>

</style>