
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);



import CenterReviewManager from "./components/listers/CenterReviewCards"
import CenterReviewDetail from "./components/listers/CenterReviewDetail"

import SanctionSanctionManager from "./components/listers/SanctionSanctionCards"
import SanctionSanctionDetail from "./components/listers/SanctionSanctionDetail"

import HostAccountManager from "./components/listers/HostAccountCards"
import HostAccountDetail from "./components/listers/HostAccountDetail"
import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"

import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"
import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [

            {
                path: '/centers/reviews',
                name: 'CenterReviewManager',
                component: CenterReviewManager
            },
            {
                path: '/centers/reviews/:id',
                name: 'CenterReviewDetail',
                component: CenterReviewDetail
            },

            {
                path: '/sanctions/sanctions',
                name: 'SanctionSanctionManager',
                component: SanctionSanctionManager
            },
            {
                path: '/sanctions/sanctions/:id',
                name: 'SanctionSanctionDetail',
                component: SanctionSanctionDetail
            },

            {
                path: '/hosts/accounts',
                name: 'HostAccountManager',
                component: HostAccountManager
            },
            {
                path: '/hosts/accounts/:id',
                name: 'HostAccountDetail',
                component: HostAccountDetail
            },
            {
                path: '//',
                name: 'Manager',
                component: Manager
            },
            {
                path: '///:id',
                name: 'Detail',
                component: Detail
            },

            {
                path: '//',
                name: 'Manager',
                component: Manager
            },
            {
                path: '///:id',
                name: 'Detail',
                component: Detail
            },
            {
                path: '//',
                name: 'Manager',
                component: Manager
            },
            {
                path: '///:id',
                name: 'Detail',
                component: Detail
            },




    ]
})
