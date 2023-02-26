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
    <form class="form-register" @submit.prevent="register">
      <h2 class="h3 mb-3 font-weight-normal">
        Edit User... <br />
        but not really
      </h2>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only"></label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="change username"
        v-model="user.username"
        required
        autofocus />
      <label for="password" class="sr-only"></label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="new password"
        v-model="user.password"
        required />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="confirm password"
        v-model="user.confirmPassword"
        required />
      <br />
      <label for="password" class="sr-only"></label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="current password"
        v-model="user.password"
        required />
      <div class="footer">
        <button
          class="btn btn-lg btn-primary btn-block"
          type="submit"
          @submit.prevent="register">
          Submit
        </button>
      </div>
    </form>
  </div>
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
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/"});
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>


