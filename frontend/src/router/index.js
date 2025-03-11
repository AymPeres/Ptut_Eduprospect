import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 1) ROUTES POUR LE LAYOUT PRINCIPAL (MainLayout)
    {
      path: "/",
      component: () => import("@/layouts/MainLayout.vue"),
      children: [
        {
          // Page d'accueil
          path: "",
          component: () => import("@/pages/formulaire/IndexPage.vue"),
        },
        {
          // Route "/formulaire"
          path: "formulaire",
          component: () => import("@/pages/formulaire/IndexPage.vue"),
        },
        {
          // Page de connexion admin sous MainLayout pour garder le titre et le fond
          path: "admin/login",
          name: "AdminLogin",
          component: () => import("@/pages/LoginPage.vue"),
        },
      ],
    },

    // 2) ROUTES POUR L'ADMINISTRATION (Dashboard)
    {
      path: "/admin",
      component: () => import("@/layouts/AdminLayout.vue"),
      children: [
        {
          // Tableau de bord admin (protégé)
          path: "",
          name: "AdminDashboard",
          component: () => import("@/pages/AdminDashboard.vue"),
          beforeEnter: (to, from, next) => {
            if (localStorage.getItem("isAuthenticated") === "true") {
              next();
            } else {
              // Redirige vers la page de login qui est sous MainLayout
              next({ name: "AdminLogin" });
            }
          },
        },
      ],
    },
  ],
});

export default router;
