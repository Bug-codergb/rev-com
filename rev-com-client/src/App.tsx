import React,{Suspense} from 'react';
import {Provider} from "react-redux";
import 'antd/dist/antd.css';
import "./App.css"
import { BrowserRouter,useRoutes } from 'react-router-dom';
import {routes} from "./router";
import store from "./store"
import "./store/actionCreators"
function App() {
  function RouteElement(){
    const element=useRoutes(routes);
    return element;
  }
  return (
    <div className="App">
     <Provider store={store}>
       <BrowserRouter>
         <Suspense fallback={
             <div className="app-router-loading">
                55
             </div>}>
           <RouteElement/>
         </Suspense>
       </BrowserRouter>
     </Provider>
    </div>
  );
}

export default App;
