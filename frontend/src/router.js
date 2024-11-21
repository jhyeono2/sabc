
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import BranchAcceptManager from "./components/listers/BranchAcceptCards"
import BranchAcceptDetail from "./components/listers/BranchAcceptDetail"

import CenterReviewManager from "./components/listers/CenterReviewCards"
import CenterReviewDetail from "./components/listers/CenterReviewDetail"

import SanctionSanctionManager from "./components/listers/SanctionSanctionCards"
import SanctionSanctionDetail from "./components/listers/SanctionSanctionDetail"

import HostAccountManager from "./components/listers/HostAccountCards"
import HostAccountDetail from "./components/listers/HostAccountDetail"




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





    ]
})
