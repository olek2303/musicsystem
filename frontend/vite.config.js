import { fileURLToPath, URL } from 'node:url'

import {defineConfig, rollupVersion} from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  // build: {
  //   rollupVersion: {
  //     input: {
  //       main: resolve('index.html')
  //     }
  //   },
  // },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    host: true,
    port: 8080
  }
})
