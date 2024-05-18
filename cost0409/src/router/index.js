import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'MyIndex',
    component: () => import('@/views/index.vue'),
    children: [
      {
        path: '/content/account',
        name: 'MyList',
        component: () => import('@/views/content/account.vue')
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
