<template id="modal-template">
   <transition name="modal">
      <div class="modal-mask">
         <div class="modal-wrapper">
            <div class="modal-container">
               <div class="modal-header">
                  <slot name="header">default header</slot>
               </div>
               <hr />
               <div class="modal-body">
                  <slot name="body">default body</slot>
               </div>
               <br />
               <div class="modal-footer">
                  <v-btn id="close" class="font-weight-bold" color="error" @click="closeModal()">{{btnLabel}}</v-btn>
               </div>
            </div>
         </div>
      </div>
   </transition>
</template>
<script>
import { MODAL_GENERIQUE } from '@/lib/message/Message';
export default {
   data () {
      return {
         btnLabel: MODAL_GENERIQUE.LABEL_GENERIQUE_BOUTON
      }
   },
   methods: {
      closeModal () {
         // a utiliser de préférence pour la génériqueModal dans App
         this.$store.dispatch('ErrorSucess/addShowModale', false)
         // on a parfois besoin d'émettre l'évenement false
         // pour fermer la modale dans certains cas particulier (ex: custom génériqueModal, pour suiviFichiersForm)
         this.$emit('errorEmit', false)
      }
   }
}
</script>
<style scoped>
.modal-mask {
   position: fixed;
   z-index: 9998;
   top: 0;
   left: 0;
   width: 100%;
   height: 100%;
   background-color: rgba(0, 0, 0, 0.5);
   display: table;
   transition: opacity 0.3s ease;
}

.modal-wrapper {
   display: table-cell;
   vertical-align: middle;
}

.modal-container {
   width: 600px;
   margin: 0px auto;
   padding: 20px 30px;
   background-color: #fff;
   color: black;
   border-radius: 2px;
   box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
   transition: all 0.3s ease;
   font-size: 1.2em;
}

.modal-header h3 {
   margin-top: 0;
   color: #42b983;
}

.modal-body {
   margin: 20px 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
   -webkit-transform: scale(1.1);
   transform: scale(1.1);
}

.modal-footer {
   text-align: right;
}
</style>
