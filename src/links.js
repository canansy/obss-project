import React, { Component } from 'react';
import { Link} from 'react-router-dom';


class links extends Component{
    render(){
        return(
            <div className="Links">
                <Link to ={"/insertBook"}>Insert</Link><br/>
                <Link to ={"/searchBook"}>App</Link><br/>

            </div>
        )
    }
}

export default links;