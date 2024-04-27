import { createRouter, createWebHistory } from 'vue-router'
import Home from './components/Home.vue'
import Register from './components/RegistrationPanel.vue'

const routes = [
    { path: '/', component: Home },
    { path: '/register', component: Register }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router