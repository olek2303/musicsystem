<template>
  <div class="sm:h-96 h-fit justify-center">
    <div class="w-full items-center flex flex-col">
      <h2 class="pb-2">Login</h2>
      <form @submit.prevent="login" class="grid grid-cols-1">
        <label class="pb-1">
          Email:
          <input v-model="user.email" type="email" required>
        </label>
        <label class="pb-1">
          Password:
          <input v-model="user.password" type="password" required>
        </label>
        <button type="submit">Log In</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import router from '../router'

export default {
  data() {
    return {
      user: {
        email: '',
        password: ''
      }
    }
  },
  methods: {
    async login() {
      console.log('login method called')
      console.log('user data:', this.user)
      try {
        const response = await axios.post('http://localhost:8080/api/v1/auth/authenticate', this.user)
        console.log('response:', response)
        window.alert('Login successful.')
        router.push('/')
      } catch (error) {
        console.error('error:', error)
      }
    }
  }
}
</script>

<style scoped>
/* Add your CSS styles for the login form here */
</style>