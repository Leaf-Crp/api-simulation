import Vuex from 'vuex'
import Vue from 'vue'
import getters from '@/store/getters'
import { UserInfo } from '@/store/UserInfo'
import { ErrorSuccess } from '@/store/ErrorSuccess'
import { StoreApp } from '@/store/StoreApp'

Vue.use(Vuex)

const store = new Vuex.Store({
    modules: {
        UserInfo,
        ErrorSuccess,
        StoreApp
    },
    getters
})

export default store