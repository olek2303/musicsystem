<script setup>

</script>

<!-- Home.vue -->
<template>
  <div>
    <h2>Mainly reviews of rock albums and many of its subgenres.</h2>
    <div class="mb-36">
      <h1>Latest Reviews</h1>
      <div v-for="album in albums" :key="album.id" class="flex flex-row justify-center">
        <img :src="album.photoUrl" class="mr-3" style="max-width: 100px;" />
        <h1 class="mr-3">{{ album.title }}</h1>
        <p>{{ album.artist }}</p>
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