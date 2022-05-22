import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router"
import detailRoutes from "./detail"
const login = () => import("../views/login/Login.vue")
const home = () => import("../views/home/Home.vue")
const movie = () => import("../views/movie/Movie.vue")
const director = () => import("../views/movie/childCpn/director/Director.vue")
const actor = () => import("../views/movie/childCpn/actor/Actor.vue")
const screenwriter = () => import("../views/movie/childCpn/screenwriter/Screenwriter.vue")
const group = () => import("../views/movie/childCpn/group/Group.vue")

const writer = () => import("../views/book/childCpn/writer/Writer.vue")
const publish = () => import("../views/book/childCpn/publish/Publish.vue")
const books = () => import("../views/book/childCpn/book/Book.vue")
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
        path: "/Home",
        redirect: () => {
          return "/Home/Movie/video"
        }
      },
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
      },
      {
        path: "Movie/screenwriter",
        name: "screenwriter",
        component: screenwriter
      },
      {
        path: "Movie/group",
        name: "group",
        component: group
      },
      {
        path: "Book/writer",
        name: "writer",
        component: writer
      },
      {
        path: "Book/publish",
        name: "publish",
        component: publish
      },
      {
        path: "Book/books",
        name: "books",
        component: books
      },
      ...detailRoutes
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
