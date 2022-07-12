import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";

import "./assets/css/base.css";
import { formatTime } from "@/utils/formatTime";
const app = createApp(App);

app.directive("format", {
  created(el: HTMLElement, bind: any) {
    let params: string | number = el.innerText;
    if (!el.innerText.includes("-")) {
      params = parseInt(params);
    }
    el.innerHTML = formatTime(params, bind.value);
  }
});

app.use(store).use(router).use(ElementPlus);
app.mount("#app");
