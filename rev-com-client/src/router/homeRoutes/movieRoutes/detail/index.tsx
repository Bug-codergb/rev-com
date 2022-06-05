import {lazy,Suspense} from "react"
import {RouteObject} from "react-router/lib/router";
const MovieDetail=lazy(()=>import("../../../../components/content/detail/movie/MovieDetail/index"));
const MovieComEdit=lazy(()=>import("../../../../components/content/movieCommentEdit/index"));
const MovieReview=lazy(()=>import("../../../../components/content/detail/movie/FilmReviewDetail/index"));
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
const movieReviewRouter:RouteObject={
  path:"MovieReview",
  element:(
    <Suspense>
      <MovieReview/>
    </Suspense>
  )
}
export {
  movieDetailRouter,
  movieComEditRouter,
  movieReviewRouter
}
