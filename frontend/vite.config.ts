import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import {fileURLToPath, URL} from "url";
import UnheadVite from '@unhead/addons/vite'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue(), UnheadVite(),],
    resolve: {
        extensions: ['.ts', '.vue', '.json'],
        alias: [
            {find: '@', replacement: fileURLToPath(new URL('./src', import.meta.url))},
            {find: '@assets', replacement: fileURLToPath(new URL('./src/assets', import.meta.url))},
            {find: '@components', replacement: fileURLToPath(new URL('./src/components', import.meta.url))},
            {find: '@vues', replacement: fileURLToPath(new URL('./src/vue', import.meta.url))},
        ],
    }
})
