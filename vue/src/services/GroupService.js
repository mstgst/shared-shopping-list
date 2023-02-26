import axios from 'axios';


// const http = axios.create({
//     baseURL: "http://localhost:9000"
// })

export default {

    getGroups() {
        return axios.get('/groups') 
    },
    createGroup(group) {
        return axios.post('/groups',group )
      },
    getGroup(groupID) {
          return axios.get(`/groups/${groupID}`)
      },
      //TODO need something along the lines of
      //button @click="removeUser({{$store.state.user.userID}}, {{$store.state.group.groupID}})">
      //in GroupDetails
    removeUser(groupID) {
        return axios.delete(`/groups/${groupID}/members`)
    },
    addUser(groupID, groupCode) {
        return axios.post(`/groups/${groupID}/members?groupCode=${groupCode}`)
    },
    getMemberByUsername(groupID, username) {
        return axios.get(`/groups/${groupID}/members/${username}`)
    },
    getGroupCreatedDate(groupID) {
        return axios.get(`/groups/${groupID}/created`)
    }
}