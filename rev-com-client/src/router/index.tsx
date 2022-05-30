import {Navigate} from "react-router-dom"
import {lazy,Suspense} from "react";
import {RouteObject} from "react-router/lib/router";
import HomeRoutes from "./homeRoutes/index";
const Login=lazy(()=>import("../views/login/index"));
const Home=lazy(()=>import("../views/home/index"));
const routes:RouteObject[]=[
  {
    path:"/",
    element: (
      <Navigate to="/Login"/>
    )
  },
  {
    path:"/Login",
    element:(
      <Suspense>
        <Login/>
      </Suspense>
    )
  },
  {
    path:"/Home",
    element:(
      <Suspense>
        <Home/>
      </Suspense>
    ),
    children:HomeRoutes
  }
]
export {
  routes
} ;
