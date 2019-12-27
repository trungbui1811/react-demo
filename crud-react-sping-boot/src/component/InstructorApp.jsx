import React, {Component} from 'react';
import ListUserComponent from './user/ListUserComponent';

class InstructorApp extends Component{
    render(){
        return (
            <>
                <h1>Instructor Application</h1>
                <ListUserComponent/>
            </>
        )
    }
}

export default InstructorApp