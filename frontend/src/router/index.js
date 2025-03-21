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
      path: "/admin",
      component: () => import("@/layouts/AdminLayout.vue"),
      children: [
        {
          path: "",
          name: "AdminIndex",
          component: () => import("@/pages/admin/IndexPage.vue"),
        },
        // === NOUVELLE ROUTE "statistiques" ===
        {
          path: "statistiques",
          name: "AdminStatPage",
          component: () => import("@/pages/admin/IndexStatPage.vue"),
          // Si ton composant se trouve ailleurs (ex: "@/components/admin/statistiques/IndexStatPage.vue"),
          // adapte simplement le chemin d'import ci-dessus.
        },
        {
          path: "Admin",
          name: "AdminPage",
          component: () => import("@/pages/admin/IndexPage.vue"),
          // Si ton composant se trouve ailleurs (ex: "@/components/admin/statistiques/IndexStatPage.vue"),
          // adapte simplement le chemin d'import ci-dessus.
        },
      ],
    },
  ],
});

export default router;
