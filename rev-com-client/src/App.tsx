import React,{Suspense} from 'react';
import {Provider} from "react-redux";
import { BrowserRouter } from 'react-router-dom';

import store from "./store"
function App() {
  return (
    <div className="App">
     <Provider store={store}>
       <BrowserRouter>
         <Suspense fallback={
             <div className="app-router-loading">
                55
             </div>}>

         </Suspense>
       </BrowserRouter>
     </Provider>
    </div>
  );
}

export default App;
