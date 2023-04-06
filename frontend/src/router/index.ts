import {createWebHistory, createRouter} from "vue-router";


declare module 'vue-router' {
    interface RouteMeta {
        icon?: string
    }
}

export const routes = [
    {
        path: "/",
        name: "Accueil",
        component: () => import('@components/Home.vue'),
    },
    {
        path: "/:pathMatch(.*)*",
        component: () => import('@components/PageNotFound.vue'),
    },
];

export const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
