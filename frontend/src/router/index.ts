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
        path: "/blog/:blog?",
        name: "Blog",
        component: () => import('@components/Blog.vue'),
    },
    {
        path: "/templates",
        name: "Maquettes",
        component: () => import('@components/Templates.vue'),
    },
    {
        path: "/cgu",
        name: "CGU",
        component: () => import('@components/CGU.vue'),
    },
    {
        path: "/preview",
        name: "Preview",
        component: () => import('@components/LiveMDPreview.vue'),
    },
    {
        path: "/cgv",
        name: "CGV",
        component: () => import('@components/CGU.vue'),
    },
    {
        path: "/:pathMatch(.*)*",
        component: () => import('@components/PageNotFound.vue'),
    },
];

export const router = createRouter({
    history: createWebHistory(),
    routes,
    scrollBehavior(to, from, savedPosition) {
        // always scroll to top
        return {top: 0}
    },
});

export default router;
