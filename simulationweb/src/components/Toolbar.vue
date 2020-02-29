<template>
   <v-app-bar>
      <v-toolbar-title>Simulationweb</v-toolbar-title>
      <v-spacer></v-spacer>
      <div>
         <v-tabs class="size">
            <v-tab @click="$router.push('japan')">Japan</v-tab>
            <v-tab @click="$router.push('bus')">Bus</v-tab>
            <v-tab @click="$router.push('restaurants')">Restaurants</v-tab>
            <v-tab @click="$router.push('profile')">Profile</v-tab>
         </v-tabs>
      </div>
       <v-btn v-if="route === 'home.bus'" dark class="ml-5"  color="secondary" @click="createBus">Create Bus</v-btn>
       <v-btn v-else-if="route === 'home.restaurants'" class="ml-5"  dark color="secondary" @click="createRestaurant">Create Restaurant</v-btn>
       <v-btn class="ml-5" dark color="dark_peach" @click="disconnect">Log out</v-btn>
   </v-app-bar>
</template>

<script>
export default {
  data: function() {
    return {

    };
  },
  computed:{
    route(){
       return this.$route.name;
    },
  },
  methods: {
    disconnect () {
        // localStorage.removeItem("user")
        this.$store.dispatch('UserInfo/fetchUserDatas', {});
        this.$router.push('/login');
    },
    createBus() {
       this.$store.dispatch('StoreApp/displayCreateBusModale', true);
    },
    createRestaurant() {
       this.$store.dispatch('StoreApp/displayCreateRestaurantModale', true);
    }
  }
};
</script>

<style>
.size{
    width: 20rem;
}
.border{
  border: solid red 2px;
}
.maxSize{
   max-width: 13rem;
}

.maxSizeTab{
   max-width: 15rem;
}
</style>
