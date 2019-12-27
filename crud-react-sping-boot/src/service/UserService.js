import axios from 'axios'

const API_URL = 'http://localhost:8080/react'
const USER_API_URL = `${API_URL}/users/`

class UserService{
    getAllUsers(){
        return axios.get(`${USER_API_URL}`);
    }
}

export default new UserService()