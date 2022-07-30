import {lazy,Suspense} from "react"
import {RouteObject} from "react-router/lib/router";
const MovieDetail=lazy(()=>import("../../../../components/content/detail/movie/movieDetail/index"));
const MovieComEdit=lazy(()=>import("../../../../components/content/movie/movieCommentEdit/index"));
const MovieReview=lazy(()=>import("../../../../components/content/detail/movie/filmReviewDetail/index"));

const AllReviewDetail=lazy(()=>import("../../../../components/content/detail/movie/allComment/reviewDetail/index"));
const AllShortComDetail=lazy(()=>import("../../../../components/content/detail/movie/allComment/shortComDetail/index"));
const TopMovie200=lazy(()=>import("../../../../components/content/movie/movieTop/index"));
const AllHotReview=lazy(()=>import("../../../../components/content/movie/allHotReview/index"));

//演员详情页
const ActorDetail=lazy(()=>import("../../../../components/content/detail/movie/actorDetail/index"));
const movieDetailRouter:RouteObject={
  path:"movieDetail",
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

const allReviewRouter:RouteObject={
  path:"AllReview",
  element:(
    <Suspense>
      <AllReviewDetail/>
    </Suspense>
  )
}
const allShortComRouter:RouteObject={
  path:"AllShortCom",
  element:(
    <Suspense>
      <AllShortComDetail/>
    </Suspense>
  )
}
const topMovieRouter:RouteObject={
  path:"TopMovie200",
  element:(
    <Suspense>
      <TopMovie200/>
    </Suspense>
  )
}
const allHotReviewRouter:RouteObject={
  path:"AllHotReview",
  element:(
    <Suspense>
      <AllHotReview/>
    </Suspense>
  )
}
const actorDetailRouter:RouteObject={
  path:"ActorDetail",
  element:(
    <Suspense>
      <ActorDetail/>
    </Suspense>
  )
}
export {
  movieDetailRouter,
  movieComEditRouter,
  movieReviewRouter,
  allReviewRouter,
  allShortComRouter,
  topMovieRouter,
  allHotReviewRouter,
  actorDetailRouter
}
