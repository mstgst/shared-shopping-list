import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:9000"
// })

export default {

    getLists(groupID) {
        return axios.get(`/groups/${groupID}/lists`)
    },
    createList(groupID, list) {
       return axios.post(`groups/${groupID}/lists?listDescription=${list.description}&listName=${list.name}`);
    },
    getList(groupID, listID) {
        return axios.get(`/groups/${groupID}/lists/${listID}`)
    },
    claimList(groupID, listID) {
        return axios.put(`groups/${groupID}/lists/${listID}/claim`)
    },
    unclaimList(groupID, listID) {
        return axios.put(`groups/${groupID}/lists/${listID}/unclaim`)
    },
    markListComplete(groupID, listID) {
        return axios.put(`groups/${groupID}/lists/${listID}/isComplete`)
    },
    markListIncomplete(groupID, listID) {
        return axios.put(`groups/${groupID}/lists/${listID}/isIncomplete`)
    }
}
