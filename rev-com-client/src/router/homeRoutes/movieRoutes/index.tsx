import {lazy,Suspense} from "react";
import {RouteObject} from "react-router/lib/router";
import {Navigate} from "react-router-dom";

import {
  movieDetailRouter,
  movieComEditRouter,
  movieReviewRouter,
  allReviewRouter,
  allShortComRouter,
  topMovieRouter,
  allHotReviewRouter
} from "./detail/index"

const HotMovie=lazy(()=>import("../../../views/movie/childCpn/hotMovie/index"));
const Video=lazy(()=>import("../../../views/movie/childCpn/video/index"));
const Toplist=lazy(()=>import("../../../views/movie/childCpn/toplist/index"));
const Actor=lazy(()=>import("../../../views/movie/childCpn/actor/index"));
const Director=lazy(()=>import("../../../views/movie/childCpn/director/index"));

const routes:RouteObject[]=[
  {
    path:"/Home/Movie",
    element:(
      <Navigate to="/Home/Movie/HotMovie"/>
    )
  },
  {
    path:"HotMovie",
    element:(
      <Suspense>
        <HotMovie/>
      </Suspense>
    )
  },
  {
    path:"Video",
    element:(
      <Suspense>
        <Video/>
      </Suspense>
    )
  },
  {
    path:"Toplist",
    element:(
      <Suspense>
        <Toplist/>
      </Suspense>
    )
  },
  {
    path:"Actor",
    element:(
      <Suspense>
        <Actor/>
      </Suspense>
    )
  },
  {
    path:"Director",
    element:(
      <Suspense>
        <Director/>
      </Suspense>
    )
  },
  movieDetailRouter,
  movieComEditRouter,
  movieReviewRouter,
  allReviewRouter,
  allShortComRouter,
  topMovieRouter,
  allHotReviewRouter
]
export default routes;
