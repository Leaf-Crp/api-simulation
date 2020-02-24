export const UserInfo = {
    namespaced: true,
    state: {
        userInfo: {}
    },
    mutations: {
        /** passe l'utilisateur au state
         * @param state : état du store
         * @param user : objet utilisateur
         */
        setUser (state, user) {
            state.userInfo = user
        }
    },
    actions: {
        /** récupère les données utilisateur du back
         * @param context : context du store
         * commit ces données vers le state
         */
        fetchUserDatas (context, data) {
            context.commit('setUser', data)
        }
    }
}
