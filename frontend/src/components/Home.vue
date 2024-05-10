<script setup>

</script>

<!-- Home.vue -->
<template>
  <div>
    <h1 class="text-xl flex justify-center text-center ml-3 sm:ml-0">Mainly reviews of rock albums and many of its subgenres.</h1>
    <div class="mb-36">
      <h2 class="flex-1 mt-6 ml-3 sm:ml-20">Latest Reviews</h2>
      <div class="flex flex-col sm:flex-row justify-center items-center">
        <div v-for="album in albums" :key="album.albumId" class="relative justify-center m-6 max-w-52 sm:max-w-56 album" @click="goToReview(album.albumId)">
          <img :src="album.photoUrl" :alt="album.title + ' by ' + album.artist" class="mr-3 rounded-2xl max-w-52 sm:max-w-56" >
          <div class="absolute bottom-0 flex flex-col text-left text-white bg-black/15 backdrop-blur-sm rounded-b-2xl left-0 inset-x-0">
            <p class="ml-2 mt-0.5 drop-shadow">{{ album.artist }}</p>
            <h2 class="ml-2 mb-1 text-xl font-bold drop-shadow ">{{ album.title }}</h2>
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
  methods: {
    async goToReview(albumId) {
      try {
        if (!isNaN(albumId) && parseInt(albumId) > 0) {
          const response = await axios.get(`http://localhost:8080/api/v1/albums/${albumId}`);
          const reviewData = response.data;

          await this.$router.push({ name: 'review', params: { id: albumId }, query: { reviewData } });
        } else {
          console.error('Invalid albumId:', albumId);
          // Handle error (e.g., show error message)
        }
      } catch (error) {
        console.error('Error fetching review:', error);
        // Handle error (e.g., show error message)
      }
    }
  }
};
</script>

<style scoped>
.album {
  cursor: pointer; /* Change cursor to pointer */
}

/* Add hover effect */
.album:hover {
  transition: all 0.3s;
  opacity: 0.8; /* Change opacity when hovering */
}
</style>