<template>
   <v-row align="center" justify="center">
      <v-col cols="3">
         <v-row>
            <img
              height="400"
              src="@/assets/cook.svg"/>
         </v-row>
         <v-row class="mt-5" justify="center">
            <span class="secondary--text">{{title}}</span>
         </v-row>
         <v-row class="mt-10" justify="center">
            <v-slider
              color="secondary"
              v-model="slider"
              thumb-label="always"/>
            <span class="secondary--text">°C</span>
         </v-row>
         <v-row justify="end">
            <v-btn color="dark_peach" class="white--text" @click="loginUser">Auto</v-btn>
            <v-btn color="dark_peach" class="white--text ml-3" @click="loginUser">Save</v-btn>
         </v-row>
      </v-col>
   </v-row>
</template>

<script>
   export default {
      data: function () {
         return {
            slider: 50,
            pseudo: '',
            password: '',
            title: 'Smart Frying Pan Simulation !'
         }
      },
      methods: {}
   };
</script>
<style>


</style>
