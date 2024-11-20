
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import BranchAcceptManager from "./components/listers/BranchAcceptCards"
import BranchAcceptDetail from "./components/listers/BranchAcceptDetail"
import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"

import CenterReviewManager from "./components/listers/CenterReviewCards"
import CenterReviewDetail from "./components/listers/CenterReviewDetail"

import SanctionSanctionManager from "./components/listers/SanctionSanctionCards"
import SanctionSanctionDetail from "./components/listers/SanctionSanctionDetail"

import HostHostManager from "./components/listers/HostHostCards"
import HostHostDetail from "./components/listers/HostHostDetail"
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
                path: '/branches/accepts',
                name: 'BranchAcceptManager',
                component: BranchAcceptManager
            },
            {
                path: '/branches/accepts/:id',
                name: 'BranchAcceptDetail',
                component: BranchAcceptDetail
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
                path: '/hosts/hosts',
                name: 'HostHostManager',
                component: HostHostManager
            },
            {
                path: '/hosts/hosts/:id',
                name: 'HostHostDetail',
                component: HostHostDetail
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
