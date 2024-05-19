<template>
  <div v-if="loading" class="flex items-center justify-center min-h-screen">
    <div class="text-2xl">Loading...</div>
  </div>
  <div v-else class="container mx-auto p-6">
    <div class="flex flex-col md:flex-row justify-start items-start space-y-6 md:space-y-0 md:space-x-6">
      <div class="md:w-1/3 w-auto">
        <h1 class="text-3xl font-bold mb-2">{{ album ? album.title : '' }}</h1>
        <p class="text-xl mb-4 italic">{{ album ? album.artist : '' }}</p>
        <img :src="album ? album.photoUrl : ''" :alt="album ? album.title : ''" class="w-full md:w-auto rounded-lg shadow-md">
      </div>
      <div class="md:w-2/3">
        <h2 class="text-2xl font-semibold mb-4">Review</h2>
        <p class="mb-6 leading-relaxed text-justify">{{ review ? review.content : '' }}</p>
      </div>
    </div>
    <h3 class="text-xl font-semibold mb-2">Comments</h3>
    <ul v-if="comments && comments.length" class="space-y-4">
      <li v-for="comment in comments" :key="comment.id" class="border-b pb-2">
        <strong class="text-gray-900">{{ comment.user }}</strong>: <span class="text-gray-700">{{ comment.text }}</span>
      </li>
    </ul>
    <div v-else class="text-gray-500">No comments</div>
  </div>

</template>



<script>
import axios from 'axios';

export default {
  data() {
    return {
      loading: true,
      album: {},
      review: {},
      comments: []
    };
  },
  async created() {
    try {
      const albumId = this.$route.params.id;
      const response = await axios.get(`http://localhost:8080/api/v1/albums/${albumId}`);


      const {album, review, comments} = response.data;
      this.album = album;
      this.review = review;
      this.comments = comments;
      this.loading = false;
    } catch (error) {
      console.error('Error fetching album and review data:', error);
    }
  }
};
</script>

<style scoped>
/* Add your styles here */
</style>
