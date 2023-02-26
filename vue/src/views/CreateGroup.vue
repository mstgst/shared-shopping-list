<template>
  <div>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <div>
        <router-link
          v-bind:to="{ name: 'editUser' }"
          v-if="$store.state.token != ''"
          >{{ $store.state.user.username }}</router-link> &nbsp; &nbsp;
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link>
      </div>
    </div>
    <h1>Fridgrr</h1>
    <create-group />
  </div>
</template>

<script>
import CreateGroup from "../components/CreateGroup.vue";
export default {
  components: { CreateGroup },
  name: "home",
};
</script>

<style></style>
