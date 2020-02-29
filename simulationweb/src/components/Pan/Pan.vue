<template>
   <v-row>
      <v-col>
         <v-row class="mb-8" justify="center">
            <span class="display-2 secondary--text">Smart frying pan Simulation Software</span>
         </v-row>
         <v-row align="center" justify="center">
            <v-col cols="3">
               <v-row>
                  <img
                    height="400"
                    src="@/assets/pan.svg"/>
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
               <v-row>
                  <v-col>
                     <span class="secondary--text">Température : {{pan.temperature}}°C</span>
                  </v-col>
                  <v-col>
                     <v-btn color="dark_peach" class="white--text" @click="auto">Auto</v-btn>
                     <v-btn color="dark_peach" class="white--text ml-3" @click="save">Save</v-btn>
                  </v-col>
               </v-row>
            </v-col>
            <v-col class="ml-12"cols="3">
               <v-row justify="center">
                  <v-col cols="3">
                     <img
                       height="70"
                       src="@/assets/meat.svg"/>
                  </v-col>
                  <v-col cols="3">
                     <img
                       height="70"
                       src="@/assets/fish.svg"/>
                  </v-col>
                  <v-col cols="3">
                     <img
                       height="70"
                       src="@/assets/egg.svg"/>
                  </v-col>
               </v-row>
               <v-row justify="center">
                  <v-col cols="9">
                     <v-radio-group v-model="mode" row>
                        <v-radio class="ml-8" color="secondary" dark value="Viande"></v-radio>
                        <v-radio class="marginRadio" color="secondary" dark value="Poisson"></v-radio>
                        <v-radio class="marginRadio2" color="secondary" dark value="Oeuf"></v-radio>
                     </v-radio-group>
                  </v-col>
               </v-row>
            </v-col>
         </v-row>
      </v-col>
   </v-row>
</template>

<script>
import SockJS from 'sockjs-client';
import Stomp from 'webstomp-client';
import * as RequestManager from '@/lib/request/RequestManager';
import * as RequestUri from '@/lib/request/RequestUri';
export default {
   data: function () {
      return {
         mode: 'Viande',
         slider: 50,
         pseudo: '',
         password: '',
         title: 'Smart frying pan simulation !',
         pan: {},
         error: []
      }
   },
   mounted() {
      this.getPan()
      this.connect()
   },
   methods: {
      getPan() {
         RequestManager.getSingleData(RequestUri.ALL_PAN).then(result =>{
            if (result) {
               this.pan = result
            }
         })
      },
      auto() {

      },
      save() {
         let temperature = {
            temperature: this.slider
         }
         RequestManager.postFormForSingleResult(RequestUri.UPDATE_PAN, temperature).then(result => {
            if (result) {
               this.pan = result
               if (result.temperature > 65) {
                  this.send('La Poêle est chaude ! Vous pouvez cuire vos légumes !')
               }
            }
         })
      },
      send(message) {
         if (this.stompClient && this.stompClient.connected) {
            this.stompClient.send('/app-receive/from-client', message, {})
         }
      },
      connect() {
         this.socket = new SockJS('http://localhost:8090/api/websocket-endpoint')
         this.stompClient = Stomp.over(this.socket)
         this.stompClient.connect({}, () => {
            this.connected = true
            this.stompClient.subscribe('/global-message/tick', (result) => {
               // eslint-disable-next-line
               // console.log(result)
            })
         }, (error) => {
            this.error.push(error)
            this.connected = false
         })
      },
   }
};
</script>
<style>

.border{
   border: solid 2px #D86A50;
}
.marginRadio{
   margin-left: 3.8em;
}
.marginRadio2{
   margin-left: 4.5em;
}
</style>
