import {createApp,reactive} from 'vue'
import '@assets/style.scss'
import '@assets/font.scss'
import '@assets/color.scss'
import '@assets/animation.scss'
import App from './App.vue'
import router from "@/router";
import {marked} from "marked";
import {metaDataHunter} from "@/object/utils/MarkedExtension";
import {createHead} from "unhead";

const app = createApp(App)
createHead()

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
marked.use({extensions: [metaDataHunter]})
app.use(router);
app.mount('#app')
