import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      component: () => import("@/layouts/MainLayout.vue"),
      children: [
        {
          path: "",
          component: () => import("@/pages/formulaire/IndexPage.vue"),
        },
        {
          path: "formulaire",
          component: () => import("@/pages/formulaire/IndexPage.vue"),
        },
        {
          path: "admin/login",
          name: "AdminLogin",
          component: () => import("@/pages/LoginPage.vue"),
        },
      ],
    },
    {
      path: "/adminlayout",
      component: () => import("@/layouts/AdminLayout.vue"),
    },
  ],
});

export default router;
