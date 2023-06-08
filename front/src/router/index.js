import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import LoginView from "@/views/LoginView.vue";
import ClientView from "@/views/ClientView.vue";
import OrderView from "@/views/OrderView.vue";
import StockView from "@/views/StockView.vue";
import store from "@/store";

const routes = [
    {
        path: '/home',
        name: 'home',
        component: HomeView,
        children: [
            {
                path: 'clients',
                name: 'clients',
                component: ClientView,
                meta:{
                    title: 'Клиенты'
                }
            },
            {
                path: 'orders',
                name: 'orders',
                component: OrderView,
                meta:{
                    title: 'Заказы'
                },
            },
            {
                path: 'stock',
                name: 'stock',
                component: StockView,
                meta:{
                    title: 'Склад'
                }
            },
            {
                path: '',
                redirect: {name: 'clients'}
            }
        ]
    },
    {
        path: '/login',
        name: 'login',
        component: LoginView
    },
    {
        path: '/:pathMatch(.*)',
        redirect: {name: 'clients'}
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

router.beforeEach((to) => {
    document.title = to.meta?.title ?? 'Гитарная мастерская'
})

router.beforeEach((to, from, next) => {
    if (to.name !== 'login' && !store.getters.isLogin) {
        next({ name: 'login' })
    }
    else {
        next()
    }
})

export default router
