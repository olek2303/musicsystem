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
        <router-link to="/login" class="mr-4 transition ease-in-out duration-300 hover:text-white">Log In</router-link>
        <router-link to="/register" class="mr-4 sm:mr-0transition ease-in-out duration-300 hover:text-white">Register</router-link>
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
  name: 'Navbar'

}
</script>

<style scoped>
/* Add your CSS styles for the navbar here */
</style>