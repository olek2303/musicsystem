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
      try {
        const response = await axios.post('/api/v1/register/save', this.user)
        console.log(response.data)
      } catch (error) {
        console.error(error)
      }
    }
  }
}
</script>