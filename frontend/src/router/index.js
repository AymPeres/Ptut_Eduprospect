import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 1) ROUTE AVEC MainLayout
    {
      path: "/",
      component: () => import("@/layouts/MainLayout.vue"),
      children: [
        // Page d'accueil (ex: formulaire)
        {
          path: "",
          component: () => import("@/pages/formulaire/IndexPage.vue"),
        },
        // Exemple de route enfant supplémentaire
        // {
        //   path: "films",
        //   component: () => import("@/views/FilmsView.vue"),
        // },
      ],
    },

    // 2) ROUTE AVEC AdminLayout
    {
      path: "/admin",
      component: () => import("@/layouts/AdminLayout.vue"),
      children: [
        // Page d'accueil de l'admin
        {
          path: "",
          component: () => import("@/pages/admin/IndexPage.vue"),
        },
      ],
    },
  ],
});

export default router;
