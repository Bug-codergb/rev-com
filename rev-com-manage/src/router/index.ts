import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router"
const login = () => import("../views/login/Login.vue")
const home = () => import("../views/home/Home.vue")
const movie = () => import("../views/movie/Movie.vue")
const director = () => import("../views/movie/childCpn/director/Director.vue")
const actor = () => import("../views/movie/childCpn/actor/Actor.vue")
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
    component: home,
    children: [
      {
        path: "Movie/video",
        name: "movie",
        component: movie
      },
      {
        path: "Movie/director",
        name: "director",
        component: director
      },
      {
        path: "Movie/actor",
        name: "actor",
        component: actor
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
