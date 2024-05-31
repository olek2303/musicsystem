<template>
  <div class="w-full items-center flex flex-col">
    <h2 class="pb-2">Account Activation</h2>
    <form @submit.prevent="activate" class="grid grid-cols-1">
      <label class="pb-1">
        Activation Code:
        <input v-model="activationCode" type="text" required>
      </label>
      <button type="submit">Activate</button>
    </form>
  </div>
</template>

<script>
import axios from '../axios'
import router from '../router'

export default {
  data() {
    return {
      activationCode: ''
    }
  },
  methods: {
    async activate() {
      try {
        await axios.get(`/api/v1/auth/activate-account?token=${this.activationCode}`)
        alert('Account activated successfully.')
        router.push('/login') // redirect to login page after successful activation
      } catch (error) {
        console.error('Error activating account:', error)
      }
    }
  }
}
</script>