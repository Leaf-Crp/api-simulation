<template>
  <v-container
       class="primary"
       fill-height>
      <transition name="fade" mode="out-in">
         <Router-view/>
      </transition>
  </v-container>
</template>

<script>
export default {
    computed: {
        user() {
           // return JSON.parse(localStorage.getItem("user"))
            return Object.keys(this.$store.getters.userInfo).length > 0
        },
    },
}
</script>

<style scoped>
.fade-enter-active, .fade-leave-active {
   transition: opacity .3s ease;
}
.fade-enter, .fade-leave-to {
   opacity: 0;
}
</style>