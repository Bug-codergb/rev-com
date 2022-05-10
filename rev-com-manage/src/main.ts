import { createApp } from "vue"
import App from "./App.vue"
import router from "./router"
import store from "./store"
import ElementPlus from "element-plus"
import "element-plus/dist/index.css"

import "./assets/css/base.css"
import { formatTime } from "@/utils/formatTime"
const app = createApp(App)

app.directive("format", {
  created(el: HTMLElement, bind: any) {
    el.innerHTML = formatTime(el.innerText, bind.value)
  }
})

app.use(store).use(router).use(ElementPlus)
app.mount("#app")
