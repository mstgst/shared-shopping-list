import Vue from "vue";
import Router from "vue-router";
import Login from "../views/Login.vue";
import Logout from "../components/Logout.vue";
import Register from "../views/Register.vue";
import store from "../store/index";
import GroupDetails from "../components/GroupDetails.vue";
import EditUser from "../views/EditUser.vue";
import ListDetails from "../components/ListDetails.vue";
import JoinGroupForm from "../components/JoinGroupForm.vue";
import LeaveGroupForm from "../components/LeaveGroupForm.vue";
import Groups from "../views/Groups.vue"
import GroupMembers from "../components/GroupMembers.vue"

Vue.use(Router);

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/groups",
      name: "groups",
      component: Groups,
      meta: {
        requiresAuth: true,
      },
    },
    {
      path: "/groups/:groupID",
      name: "group-details",
      component: GroupDetails,
      meta: {
        requiresAuth: true,
      },
    },
    {
      path: "/editUser",
      name: "editUser",
      component: EditUser,
      meta: {
        requiresAuth: true,
      },
    },
    {
      path: "/listDetails/:groupID/:listID",
      name: "list-details",
      component: ListDetails,
      meta: {
        requiresAuth: true,
      },
    },
    {
      path: "/joinGroupForm",
      name: "join-group-form",
      component: JoinGroupForm,
      meta: {
        requiresAuth: true,
      },
    },
    {
      path: "/leaveGroupForm",
      name: "leave-group-form",
      component: LeaveGroupForm,
      meta: {
        requiresAuth: true,
      },
    },
    {
      path:"/members",
      name:"group-members",
      component: GroupMembers,
      meta: {
        requiresAuth: true,
      }
    }
 
  ],
});

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some((x) => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === "") {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
