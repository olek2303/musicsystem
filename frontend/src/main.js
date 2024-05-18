// main.js
import { createApp } from 'vue'
import App from './App.vue'
import router from './router.js'
import "./assets/style.css";
import { eventBus } from "./eventBus";

const app = createApp(App).use(router);
app.config.globalProperties.$eventBus = eventBus;
app.mount('#app');