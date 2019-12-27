import React, {Component} from 'react';
import UserService from '../../service/UserService';

class ListUserComponent extends Component{

    constructor(props){
        super(props)
        this.state = {
            users: [],
            message: null
        }
        this.refreshUsers = this.refreshUsers.bind(this)
    }

    componentDidMount(){
        this.refreshUsers();
    }

    refreshUsers(){
        UserService.getAllUsers()
            .then(
                response => {
                    this.setState({users: response.data})
                }
            )
    }

    render(){
        return(
            <div className="container">
                <h3>All Users</h3>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th className="hidden">Id</th>
                                <th>User name</th>
                                <th>Full name</th>
                                <th>Cell phone</th>
                                <th>Email</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user => 
                                        <tr key={user.userId}>
                                            <td>{user.userName}</td>
                                            <td>{user.fullName}</td>
                                            <td>{user.cellphone}</td>
                                            <td>{user.email}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ListUserComponent