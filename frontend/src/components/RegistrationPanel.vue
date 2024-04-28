<template>
  <div>
    <h2>Registration</h2>
    <form @submit.prevent="register">
      <label>
        Name:
        <input v-model="user.username" type="text" required>
      </label>
      <label>
        Email:
        <input v-model="user.email" type="email" required>
      </label>
      <label>
        Password:
        <input v-model="user.password" type="password" required>
      </label>
      <button type="submit">Register</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      user: {
        username: '',
        email: '',
        password: ''
      }
    }
  },
  methods: {
    async register() {
      console.log('register method called') // Add this line
      console.log('user data:', this.user) // Add this line
      try {
        const response = await axios.post('http://localhost:8080/api/v1/auth/register', this.user)
        console.log('response:', response) // Add this line
      } catch (error) {
        console.error('error:', error) // Add this line
      }
    }
  }
}
</script>