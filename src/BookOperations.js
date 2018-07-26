import React from 'react'
import * as BooksAPI from './BooksAPI'


class SearchBook extends React.Component{
    constructor(props){
        super(props)
        this.state={my_book:{},found:0,clicked:0}
        this.handleChange=this.handleChange.bind(this)
        this.handleClick=this.handleClick.bind(this)
        
    }
    handleChange(event){   this.setState({[event.target.name]:event.target.value})  }
    handleClick(event){
        BooksAPI.get(this.state.inputName).then((book)=>{
            this.setState({my_book:book})
            this.setState({clicked:1})
            if(book.title==null)
                this.setState({found:0})
            else
                this.setState({found:1})
        });      
    }

    render(){
        return(
            <div>
                <label for="inputName"><p>Book Name:</p></label>
                <input name="inputName" type="text" value={this.state.inputName}
                    onChange={this.handleChange} />
            
            <button onClick={this.handleClick} >Search</button>
            {(this.state.clicked===1)?((this.state.found===1) ?(
                <p><br/>Book Title: {this.state.my_book.title}
               <br/>BookID:  {this.state.my_book.bookID}
               <br/>Author Name: {this.state.my_book.publishername}
               <br/>AuthorID:  {this.state.my_book.authorID}
               <br/>IsAvailable: {this.state.my_book.available}</p>
            
        ):<p>Not Found!</p>) : <p> Make a search for a book... </p>}
            </div>
        )}
    }

class BookSearchApp extends React.Component{
    constructor(props){
        super(props)
    }
    render(){
        return(
            <div>
                <SearchBook/>
             
            </div>
            
        )

    }
}
export default BookSearchApp;
