import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router"
const login = () => import("../views/login/Login.vue")
const home = () => import("../views/home/Home.vue")
const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    redirect: "/Login"
  },
  {
    path: "/Login",
    name: "login",
    component: login
  },
  {
    path: "/Home",
    name: "home",
    component: home
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
