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
  <form class="form-register" @submit.prevent="register">
      <h2 class="h3 mb-3 font-weight-normal">\ Create Account</h2>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only"></label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="username"
        v-model="user.username"
        required
        autofocus />
      <label for="password" class="sr-only"></label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="password"
        v-model="user.password"
        required />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="confirm Password"
        v-model="user.confirmPassword"
        required />

        <v-btn 
        @click.prevent="register"
        type="submit"
        color="#0EAD69"
        elevation="9"
        small
      >register
      </v-btn>

      <br>

      <v-btn 
        @click.prevent="login"
        type="submit"
        elevation="9"
        small
      >Have an account?
      </v-btn>
    </form>
    </div>
</body>     
  </html>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      appTitle: 'Fridgrr',
      registrationErrors: false,
      registrationErrorMsg: "There was a problem registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.username.length <= 0) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Username field cannot be blank.";
      } 
       if (this.user.username.length > 36) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Username cannot be more than 36 characters.";
      } 
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password and confirmation must be identical.";
      } 
       if (this.user.password.length <= 0) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password field cannot be blank.";
      } else {

        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/",
                query: { registration: "success" },
              });
            }
          
          });
      }
    },
    login() {
      this.$router.push("/");
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>
<style scoped>
#title, .form-register{
  font-family:    'Courier New', Courier, monospace;
  font-size:      36px;
  font-weight:    bold;
  color:          blanchedalmond;
  text-shadow: 2px 2px 0px lightcoral;
}
#form-div{
  padding-top: 7%;
}
.form-register{
   display: inline-block;
    height: 480px;
    width: 600px;
    background-color: rgb(255, 235, 205);
    
    left: 50%;
    border-radius: 4px;
    backdrop-filter: blur(10px);
    color:          #0EAD69;
    border: 2px solid rgba(255,255,255,0.1);
    box-shadow: 0 0 40px rgb(8 7 16 / 60%);
    padding: 50px 30px;
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
body{
  background-color: rgba(240, 128, 128, 0.667);
  min-height: 100vh;
  text-align: center;
}
input {
  font-size: 10px;
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
  font-family:'Courier New', Courier, monospace;
  font-size:      30px;
  font-weight: bolder;
  background-color: whitesmoke;
}
</style>
