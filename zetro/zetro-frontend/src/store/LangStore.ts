import {reactive} from "vue";

export const langStore = reactive({
    lang: "fr",
    get() {
        return this.lang;
    },
    set(value: string) {
        this.lang = value
    }
})