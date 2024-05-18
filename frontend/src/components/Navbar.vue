<template>

  <nav class="w-full  place-items-center">
    <div class="flex flex-col sm:flex-row items-center justify-between mx-auto p-8">
      <router-link to="/home" class="duration-300 w-full sm:w-auto mb-3 sm:mb-0 text-2xl font-bold md:max-lg:ml-18 sm:max-md:ml-6">Music Reviews</router-link>
      <div class="justify-between mb-3 sm:mb-0 flex flex-col sm:flex-row items-center">
        <router-link to="/home" class="mr-4 transition ease-in-out duration-300 hover:text-white">Home</router-link>
        <router-link to="/reviews" class="mr-4 transition ease-in-out duration-300 hover:text-white">Reviews</router-link>
        <router-link to="/collection" class="mr-7 transition ease-in-out duration-300 hover:text-white">My Collection</router-link>
      </div>
      <div class="md:mr-18 sm:mr-6 flex flex-col sm:flex-row items-center">
        <template v-if="auth && auth.isLoggedIn">
          <span class="mr-4">{{ auth.userNickname }}</span>
          <a href="#" class="mr-4 sm:mr-0 transition ease-in-out duration-300 hover:text-white" @click.prevent="logout">Log Out</a>
        </template>
        <template v-else>
          <router-link to="/login" class="mr-4 transition ease-in-out duration-300 hover:text-white">Log In</router-link>
          <router-link to="/register" class="mr-4 sm:mr-0 transition ease-in-out duration-300 hover:text-white">Register</router-link>
        </template>
      </div>
    </div>
  </nav>

<!--  <nav>-->
<!--    <router-link to="/">Home</router-link>-->
<!--    <router-link to="">Reviews</router-link>-->
<!--    <router-link to="">My Collection</router-link>-->
<!--    <router-link to="">Log In</router-link>-->
<!--    <router-link to="/register">Register</router-link>-->
<!--    &lt;!&ndash; Add more links as needed &ndash;&gt;-->
<!--  </nav>-->
</template>

<script>
export default {
  name: 'Navbar',
  props: {
    auth: Object
  },
  methods: {
    logout() {
      // Perform any necessary cleanup before logging out
      // Then emit the logout event
      this.$eventBus.emit('logout');
      // Redirect to login page or home page as needed
      this.$router.push({ name: 'login' });
    }
  }
}
</script>

<style scoped>
/* Add your CSS styles for the navbar here */
</style>