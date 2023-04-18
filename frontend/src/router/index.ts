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
        path: "/projects/:project?",
        name: "Projets",
        component: () => import('@components/Projects.vue'),
    },
    {
        path: "/blog",
        name: "Blog",
        component: () => import('@components/Blog.vue'),
    },
    {
        path: "/templates",
        name: "Maquettes",
        component: () => import('@components/Templates.vue'),
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
