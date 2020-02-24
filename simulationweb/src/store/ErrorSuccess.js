export const ErrorSuccess = {
    state: {
        generiqueMessage: [],
        generiqueTitle: '',
        showModale: false
    },
    getters: {
        getGeneriqueTitle (state) {
            return state.generiqueTitle
        },
        getGeneriqueMessage (state) {
            return state.generiqueMessage
        },
        getShowModale (state) {
            return state.showModale
        }
    },
    mutations: {
        setGeneriqueTitle (state, payload) {
            state.generiqueTitle = payload
        },
        setGeneriqueMessage (state, payload) {
            state.generiqueMessage = payload
        },
        setShowModale (state, payload) {
            state.showModale = payload
        }
    },
    actions: {
        addGeneriqueTitle (context, data) {
            context.commit('setGeneriqueTitle', data)
        },
        addGeneriqueMessage (context, data) {
            context.commit('setGeneriqueMessage', data)
        },
        addShowModale (context, data) {
            context.commit('setShowModale', data)
        }
    }
}
