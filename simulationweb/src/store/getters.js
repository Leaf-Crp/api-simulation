const getters = {
    userInfo: state => state.UserInfo.userInfo,
    showModal: state => state.ErrorSuccess.showModale,
    generiqueTitle: state => state.ErrorSuccess.generiqueTitle,
    generiqueMessage: state => state.ErrorSuccess.generiqueMessage,
    showCreateBusModale: state => state.StoreApp.showCreateBusModale,
    showCreateRestaurantModale: state => state.StoreApp.showCreateRestaurantModale
}
export default getters