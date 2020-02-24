import axios from 'axios'
import * as message from '@/lib/message/Message'
import { ErrorSuccess } from '@/store/ErrorSuccess'
import Vue from 'vue'

const deploy = process.env.NODE_ENV === 'deploy'

axios.defaults.baseURL = deploy? 'http://192.168.1.179:8090/': 'http://localhost:8090/';

const websocket = deploy? 'http://192.168.1.179:8090/api/websocket-endpoint': 'http://localhost:8090/api/websocket-endpoint';

Vue.prototype.$http = axios

let error = {}
/** récupére l'utilisateur
 * @param url : url endpoint
 * return un utilisateur
 */
const getSingleData =  (url) => {
    return axios.get(url).then(res => {
        const result = res.data.payload
        return result
    }).catch(() => {
        error = { error: message.AXIOS_ERROR_CALL_NO_DATA }
    })
}
/** récupére la liste des flux du back
 * @param url : url endpoint
 * @param parameterIn : url endpoint
 * return list de données
 */
const getDataList = (url) => {
    let dataList = []
    axios.get(url).then(res => {
       res.data.payload.forEach(element => {
           dataList.push(element)
       })
    }).catch(() => {
        error = { error: message.AXIOS_ERROR_CALL_NO_DATA }
    })
    return dataList
}

/** post le formulaire au back
 * @param url : url endpoint
 * @param form : objet form
 * return un seul objet
 */
const postFormForSingleResult =  (urlrequest, form) => {
    form = (typeof form === 'undefined') ? 'default' : form
    return axios.post(urlrequest, form).then(res => {
        const singleResult = res.data.payload
        return singleResult
    }).catch(() => {
        error = { error: message.AXIOS_ERROR_CALL_NO_DATA }
    })
}

/** affiche la modal erreur generique
 * @param msg : message d'erreur
 */
// eslint-disable-next-line
const activeModalError = () => {
    ErrorSuccess.state.generiqueTitle = message.MODAL_GENERIQUE.GENERIQUE_ERROR_TITLE
    ErrorSuccess.state.generiqueMessage = message.MODAL_GENERIQUE.GENERIQUE_ERROR_MESSAGE
    ErrorSuccess.state.showModale = true
}

/** affiche la modal success generique
 * @param
 */
// eslint-disable-next-line
const activeModalSuccess = () => {
    ErrorSuccess.state.generiqueTitle = message.MODAL_GENERIQUE.GENERIQUE_SUCESS_TITLE
    ErrorSuccess.state.generiqueMessage = message.MODAL_GENERIQUE.GENERIQUE_SUCESS_MESSAGE
    ErrorSuccess.state.showModale = true
}

export {
    getSingleData,
    getDataList,
    postFormForSingleResult,
    error,
    websocket
}