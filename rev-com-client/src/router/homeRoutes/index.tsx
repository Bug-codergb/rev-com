import {lazy,Suspense} from "react";
import {Navigate} from "react-router-dom"
import {RouteObject} from "react-router/lib/router";
import movieRoutes from "./movieRoutes/index"
const Movie=lazy(()=>import("../../views/movie/index"));
const Music=lazy(()=>import("../../views/music/index"));
const Group=lazy(()=>import("../../views/group/index"));
const Read=lazy(()=>import("../../views/read/index"));
const Topic=lazy(()=>import("../../views/topic/index"));
const routes:RouteObject[]=[
  {
    path:"/Home",
    element:(
      <Navigate to={"/Home/Movie"}/>
    )
  },
  {
    path:"Movie",
    element:(
      <Suspense>
        <Movie/>
      </Suspense>
    ),
    children:movieRoutes
  },
  {
    path:"Music",
    element:(
      <Suspense>
        <Music/>
      </Suspense>
    )
  },
  {
    path:"Read",
    element:(
      <Suspense>
        <Read/>
      </Suspense>
    )
  },
  {
    path:"Group",
    element:(
      <Suspense>
        <Group/>
      </Suspense>
    )
  },
  {
    path:"Topic",
    element:(
      <Suspense>
        <Topic/>
      </Suspense>
    )
  }
]
export default routes;
