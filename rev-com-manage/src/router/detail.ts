import { RouteRecordRaw } from "vue-router";
const directorDetail = () =>
  import("../components/content/detail/directorDetail/DirectorDetail.vue");
const actorDetail = () => import("../components/content/detail/actorDetail/ActorDetail.vue");
const movieDetail = () => import("../components/content/detail/movieDetail/MovieDetail.vue");
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
  },
  {
    path: "movie/movieDetail",
    name: "movieDetail",
    component: movieDetail
  }
];
export default routes;
