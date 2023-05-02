import {createApp} from 'vue'
import './style.scss'
import './font.scss'
import App from './App.vue'
import router from "@/router";
import {marked} from "marked";
import {metaDataHunter} from "@/object/MarkedExtension";

const app = createApp(App)

// Click outside custom event
app.directive('click-outside', {
    mounted(el, binding) {
        el.clickOutsideEvent = function (event: any) {
            if (!(el === event.target || el.contains(event.target))) {
                binding.value(event, el);
            }
        };
        window.requestAnimationFrame(() => {
            document.body.addEventListener('click', el.clickOutsideEvent)
        });
    },
    unmounted(el) {
        document.body.removeEventListener('click', el.clickOutsideEvent);
    }
});
marked.use({extensions:[metaDataHunter]})
app.use(router);
app.mount('#app')
