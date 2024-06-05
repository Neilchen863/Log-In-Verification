import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueRouter from 'vue-router'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'

// Disable Vue production tip
Vue.config.productionTip = false

// Use plugins
Vue.use(ElementUI) // Element UI plugin
Vue.use(VueRouter) // Router plugin
Vue.use(VueAxios, axios) // Use axios plugin

// Create a Vue instance object
new Vue({
  render: h => h(App),  // The render function will help parse the template, the parameter h is a function that can be used to parse the App component
  router
}).$mount('#app') // Mount the App.vue component to the div tag with id 'app' in index.html
