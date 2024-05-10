<template>
  <div>
    <div v-if="loading">Loading...</div>
    <div v-else>
      <h1>{{ album ? album.title : '' }}</h1>
      <img :src="album ? album.photoUrl : ''" :alt="album ? album.title : ''" style="max-width: 300px;">
      <p>{{ album ? album.artist : '' }}</p>
      <h2>Review</h2>
      <p>{{ review ? review.content : '' }}</p>
      <h3>Comments</h3>
      <ul v-if="comments && comments.length">
        <li v-for="comment in comments" :key="comment.id">
          <strong>{{ comment.user }}</strong>: {{ comment.text }}
        </li>
      </ul>
      <div v-else>No comments</div>
    </div>
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
