import Vue from 'vue'
import Router from 'vue-router'
import Layout from '@/views/index'
import Test from '@/components/Utils/Test'
import Pan from '@/components/Pan/Pan'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/test',
            name: 'test',
            component: Test
        },
        {
            path: '/',
            name: 'home',
            component: Layout,
            redirect: '/pan',
            children: [
                {
                    path: '/pan',
                    name: 'home.pan',
                    component: Pan
                },
            ]

        }
    ]
})
