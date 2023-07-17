import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'

import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faUserSecret, faPenToSquare, faTrash } from '@fortawesome/free-solid-svg-icons'
import { faFacebook, faInstagram, faLinkedin } from '@fortawesome/free-brands-svg-icons'
library.add(faUserSecret, faPenToSquare, faTrash, faInstagram, faLinkedin, faFacebook)

const pinia = createPinia()
const app = createApp(App)

app.use(pinia)
app.use(router)

app.component('font-awesome-icon', FontAwesomeIcon).mount('#app')
