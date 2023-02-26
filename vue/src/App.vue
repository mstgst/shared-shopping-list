<template>
  <html>
    <v-content id="main" class="d-flex align-center justify-center">
      <router-view></router-view>
    </v-content>
  </html>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      appTitle: "Fridgrr",
      sidebar: false,
      menuItems: [
        { title: "Group", path: "/groups" },
        { title: "Logout", path: "/" },
      ],
    };
  },
};
</script>

<style scoped>
.form-card {
  padding: 16px;
}
#main {
  margin-left: auto;
  margin-right: auto;
}
.content {
  text-align: center;
  max-height: 20px;
}
div {
  text-align: center;
}
.v-application a {
  color: white;
  text-decoration: none;
}
.theme--light.v-btn.v-btn--has-bg {
  background-color: #26b82d;
}
html{
  display: flexbox;

}

</style>
