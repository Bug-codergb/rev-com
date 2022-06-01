import {lazy,Suspense} from "react"
import {RouteObject} from "react-router/lib/router";
const MovieDetail=lazy(()=>import("../../../../components/content/detail/movie/movieDetail/index"))
const MovieComEdit=lazy(()=>import("../../../../components/content/movieCommentEdit/index"))
const movieDetailRouter:RouteObject={
  path:"MovieDetail",
  element:(
    <Suspense>
      <MovieDetail/>
    </Suspense>
  )
}
const movieComEditRouter:RouteObject={
  path:"MovieComment",
  element:(
    <Suspense>
      <MovieComEdit/>
    </Suspense>
  )
}
export {
  movieDetailRouter,
  movieComEditRouter
}
