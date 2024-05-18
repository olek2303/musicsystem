<template>
  <div id="app">
    <Navbar :auth="auth" />
    <router-view />
    <Footer />
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue'
import Footer from './components/Footer.vue'

export default {
  name: 'App',
  components: {
    Navbar,
    Footer
  },
  data() {
    return {
      // Initial authentication state
      auth: {
        isLoggedIn: false,
        userNickname: ''
      }
    }
  },
  unmounted() {
    this.$eventBus.off('login-success');
    this.$eventBus.off('logout');
  },
  // Inside the <script> tag of App.vue
  created() {
    this.checkAuth();
    this.$eventBus.on('login-success', (authData) => {
      this.auth = authData;
      localStorage.setItem('auth', JSON.stringify(authData)); // Ensure auth data is updated in localStorage on login
    });
    this.$eventBus.on('logout', () => {
      this.auth = { isLoggedIn: false, userNickname: '' };
      localStorage.removeItem('auth');
    });
  },
  methods: {
    // checkAuth() {
    //   // Placeholder for auth check logic, e.g., checking localStorage
    //   const isLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
    //   const userNickname = localStorage.getItem('userNickname');
    //   if (isLoggedIn && userNickname) {
    //     this.auth.isLoggedIn = true;
    //     this.auth.userNickname = userNickname;
    //   }
    // }
    checkAuth() {
      const auth = localStorage.getItem('auth');
      if (auth) {
        this.auth = JSON.parse(auth);
      } else {
        // Placeholder for auth check logic, e.g., checking with a backend service
        this.auth = { isLoggedIn: false, userNickname: '' };
      }
    }
  }
}
</script>

