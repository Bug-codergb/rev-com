import { RouteRecordRaw } from "vue-router"
const directorDetail = () =>
  import("../components/content/detail/directorDetail/DirectorDetail.vue")
const actorDetail = () => import("../components/content/detail/actorDetail/ActorDetail.vue")
const routes: Array<RouteRecordRaw> = [
  {
    path: "director/directorDetail",
    name: "directorDetail",
    component: directorDetail
  },
  {
    path: "actor/actorDetail",
    name: "actorDetail",
    component: actorDetail
  }
]
export default routes
