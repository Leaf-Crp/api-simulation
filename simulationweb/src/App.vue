<template>
    <v-app>
        <RouterView/>
        <v-dialog v-model="showModale">
            <GeneriqueModal>
                <h3 slot="header">{{generiqueTitle}}</h3>
                <p slot="body">{{generiqueMessage}}</p>
            </GeneriqueModal>
        </v-dialog>
    </v-app>
</template>

<script>
import GeneriqueModal from '@/components/Modals/GeneriqueModal'
export default {
   components: {
      GeneriqueModal
   },
  name: 'App',
  data () {
    return {

    };
  },
  computed: {
     showModale ()     { return this.$store.getters.showModal },
     generiqueTitle () { return this.$store.getters.generiqueTitle },
     generiqueMessage () { return this.$store.getters.generiqueMessage }
  }
};
</script>
<style>
@import 'https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons';
@import 'https://fonts.googleapis.com/css?family=Roboto|Montserrat:600|Open+Sans|Raleway:500';
</style>
