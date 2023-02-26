<template>
<html>
  <header>
    <v-toolbar app>
        <v-toolbar-title id="title">
         \ {{ appTitle }}
        </v-toolbar-title>
    </v-toolbar>
  </header>

<body>
  <div id="form-div">
    <form class="form-signin" @submit.prevent="login">
      <h2>\ Sign-in</h2>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration">
      </div>
      <label for="username" class="sr-only"></label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="username"
        v-model="user.username"
        required
      />
      <label for="password" class="sr-only"></label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="password"
        v-model="user.password"
        required />


      <v-btn 
        @click.prevent="login"
        type="submit"
        color="#0EAD69"
        elevation="9"
        small
      >Sign in
      </v-btn>
<br>
      <v-btn
        @click.prevent="register"
        elevation="9"
        color="#0EAD69"
        small>
        register
        </v-btn>
    </form>
    </div>
  </body>
  </html>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
        
      },
      appTitle: 'Fridgrr',
        menuItems: [
          { title: 'group', path: '/groups' },
          { title: 'logout', path: '/' },
     ],
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/groups");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
          if (response.status === 200) {
            this.$router.push('/groups');
          }
        });
    },
    register() {
      this.$router.push("/register");
    }
  },
  created() {
    //this.$store.commit("LOGOUT")
    
  }
};
</script>
<style scoped>
#title, .form-signin{
  font-family:    'Courier New', Courier, monospace;
  font-size:      50px;
  font-weight:    bold;
  color:          blanchedalmond;
  text-shadow: 2px 2px 0px lightcoral;
}
.v-btn__content{
  font-family:    'Courier New', Courier, monospace;
  font-size:      15px;
  font-weight:    bolder;
  color: blanchedalmond;
}
.v-toolbar__content{
  background-color: #0EAD69;
}
#form-div{
  padding-top: 7%;
}
.form-signin{
   display: inline-block;
    height: 480px;
    width: 480px;
    background-color: rgb(255, 235, 205);
    
    left: 50%;
    border-radius: 4px;
    backdrop-filter: blur(10px);
    color:          #0EAD69;
    border: 2px solid rgba(255,255,255,0.1);
    box-shadow: 0 0 40px rgb(8 7 16 / 60%);
    padding: 50px 30px;
}
body{
  background-color: rgba(240, 128, 128, 0.667);
  min-height: 100vh;
  text-align: center;
}
input {
  font-size: 15px;
  text-align: center;
    display: block;
    height: 50px;
    width: 100%;
    background-color: rgba(255,255,255,0.07);
    border-radius: 3px;
    padding: 20px 20px;
    margin-top: 16px;
    margin-bottom: 16px;
    font-weight: 300;
}
.alert-danger{
  font-size: 15pt;
}
.form-control{
  font-family:    'Courier New', Courier, monospace;
  font-size:      30px;
  font-weight: bolder;
  background-color: whitesmoke;
}
</style>

