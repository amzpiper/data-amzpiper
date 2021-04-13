import { createApp } from 'vue'
import ElementPlus from 'element-plus';
import 'element-plus/lib/theme-chalk/index.css';
import App from './App.vue';
import locale from 'element-plus/lib/locale/lang/zh-cn'

const app = createApp(App)
app.use(ElementPlus, { size: 'small', zIndex: 3000 });
createApp(App).use(ElementPlus, { locale })
app.mount('#app')