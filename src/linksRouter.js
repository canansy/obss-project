import React from 'react'
import {Switch,Route,Redirect} from "react-router-dom";
import BookInsertApp from "./BookInsert"
import BookSearchApp from "./BookOperations"
import links from './links';

const linksRouter=() =>(
    <switch>
        <Route exact path="/" render = {() => <Redirect replace to ="links"/>}/>
        <Route path="/links" component = {links} />
        <Route path="/BookSearchApp" component={BookOperations} />
        <Route path="/BookInsertApp" component={BookInsert} />
    </switch>
)

export default linksRouter;

