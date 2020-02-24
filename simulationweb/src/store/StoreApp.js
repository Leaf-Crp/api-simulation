export const StoreApp = {
   namespaced: true,
   state: {
      showCreateBusModale: false,
      showCreateRestaurantModale: false
   },
   mutations: {
       setShowCreateBusModale(state, show) {
         state.showCreateBusModale = show
      },

      setShowCreateRestaurantModale(state, show) {
         state.showCreateRestaurantModale = show
      }
   },
   actions: {
      displayCreateBusModale (context, data) {
         context.commit('setShowCreateBusModale', data)
      },
      displayCreateRestaurantModale (context, data) {
         context.commit('setShowCreateRestaurantModale', data)
      }
   }
}
