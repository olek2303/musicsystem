<template>

  <nav class="w-full block">
    <div class="flex flex-wrap items-center justify-between mx-auto p-8">
      <router-link to="/" class="text-2xl font-bold">Music Reviews</router-link>
      <div class="justify-between flex">
        <router-link to="/home" class="mr-4 hover:text-white">Home</router-link>
        <router-link to="/reviews" class="mr-4">Reviews</router-link>
        <router-link to="/collection" class="mr-7">My Collection</router-link>
        <div>
          <router-link to="/login" class="mr-4">Log In</router-link>
          <router-link to="/register">Register</router-link>
        </div>
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
