<script setup>

</script>

<!-- Home.vue -->
<template>
  <div>
    <h1 class="text-xl flex justify-center text-center ml-3 sm:ml-0">Mainly reviews of rock albums and many of its subgenres.</h1>
    <div class="mb-36">
      <h1 class="flex-1 mt-6 ml-3 sm:ml-20">Latest Reviews</h1>
      <div class="flex flex-col sm:flex-row justify-center items-center">
        <div v-for="album in albums" :key="album.id" class="relative justify-center m-6 max-w-52 sm:max-w-56">
          <img :src="album.photoUrl" class="mr-3 rounded-2xl max-w-52 sm:max-w-56" >
          <div class="absolute bottom-0 flex flex-col text-left text-white bg-black/15 backdrop-blur-sm rounded-b-2xl left-0 inset-x-0">
            <p class="ml-2 mt-0.5 drop-shadow">{{ album.artist }}</p>
            <h1 class="ml-2 mb-1 text-xl font-bold drop-shadow ">{{ album.title }}</h1>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      albums: [],
    }
  },
  async created() {
    try {
      const response = await axios.get('http://localhost:8080/api/v1/albums');
      this.albums = response.data;
    } catch (error) {
      console.error(error);
    }
  },
};
</script>

<style scoped>

</style>