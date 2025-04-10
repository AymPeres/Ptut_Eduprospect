import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: () => import('@/layouts/MainLayout.vue'),
      children: [
        {
          path: '',
          component: () => import('@/pages/formulaire/IndexPage.vue')
        },
        {
          path: 'formulaire',
          name: 'FormulaireRoot',
          component: () => import('@/pages/formulaire/Formulaire.vue'),
        },
        {
          path: ':salon',
          component: () => import('@/pages/formulaire/FormulaireGlobal.vue'),
          children: [
            {
              path: 'page1',
              name: 'FormulairePage1',
              component: () => import('@/pages/formulaire/FormulairePage1.vue'),
              props: true
            },
            {
              path: 'page2',
              name: 'FormulairePage2',
              component: () => import('@/pages/formulaire/FormulairePage2.vue'),
              props: true
            }
          ]
        },
        {
          path: 'admin/login',
          name: 'AdminLogin',
          component: () => import('@/pages/LoginPage.vue')
        },
      ]
    },
    {
      path: '/admin',
      component: () => import('@/layouts/AdminLayout.vue'),
      children: [
        {
          path: '',
          name: 'AdminIndex',
          component: () => import('@/pages/admin/IndexPage.vue')
        },
        {
          path: 'statistiques',
          name: 'AdminStatPage',
          component: () => import('@/pages/admin/IndexStatPage.vue')
        },
        {
          path: 'Admin',
          name: 'AdminPage',
          component: () => import('@/pages/admin/IndexPage.vue')
        }
      ]
    }
  ]
})

export default router
