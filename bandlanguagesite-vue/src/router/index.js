import Vue from 'vue'
import VueRouter from "vue-router"
import Index from '../components/home/Index.vue'
import Scenes from "@/components/home/Scenes";
import SceneDetail from "@/components/home/SceneDetail";
import Discuss from "@/components/discuss/DiscussIndex";
import AllScripts from "@/components/home/AllScripts";
Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Index',
        component: Index
    },
    {
        path: '/scenes',
        name: 'Scenes',
        component: Scenes
    },
    {
        path: '/discuss',
        name: 'Discuss',
        component: Discuss
    },
    {
        path: '/sceneDetail/:id',
        name: 'SceneDetail',
        component: SceneDetail
    },
    {
        path: '/allScripts',
        name: 'AllScripts',
        component: AllScripts
    },

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})
export default router
