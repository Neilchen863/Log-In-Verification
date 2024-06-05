// This file is responsible for the routing of the project

import VueRouter from "vue-router"

// Import components
import Login from '../views/login/Login'
import Register from '../views/register/Register'
import Home from '../views/home/Home'
import { Message } from "element-ui";

// Create and export a router
const router = new VueRouter({
    mode: 'history',    // Routing mode, this mode will not display a hash (#) in the address
    routes: [
        {
            path: '/',          // Path
            redirect: '/login'  // Redirect
        },
        {
            path: '/login',     // Path
            component: Login    // Component to navigate to
        },
        {
            path: '/register',     // Path
            component: Register    // Component to navigate to
        },
        {
            path: '/home',     // Path
            component: Home    // Component to navigate to
        }
    ]
})

// Navigation guard, pre-processing
router.beforeEach((to, from, next) => {
    let isAuthenticated = !!sessionStorage.getItem('userInfo')
    // If the route is trying to navigate to any page other than login and register, check if the user is logged in.
    // If not logged in, force redirect to the login page
    if (to.path !== '/login' && to.path !== '/register' && !isAuthenticated) {
        next({ path: '/login' })
        Message({
            message: 'Please sign in first!',
            type: "warning",
        });
    } else next()
})

export default router;
