import { createRouter, createWebHistory } from 'vue-router'
import Home from './components/Home.vue'
import Register from './components/RegistrationPanel.vue'
import ReviewPage from "@/components/ReviewPage.vue";
import Login from "@/components/Login.vue";
import Activate from "@/components/Activate.vue";

const routes = [
    { path: '/', component: Home },
    { path: '/home', component: Home },
    { path: '/register', component: Register },
    { path: '/login', component: Login },
    { path: '/activate-account', component: Activate },
    { path: '/review/:id', name: 'review', component: ReviewPage, props: true }
]

const router = createRouter({
    history: createWebHistory('/'),
    routes
})

export default router