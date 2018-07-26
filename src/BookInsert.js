import React from 'react'
const api = "http://localhost:8082/SpringSecurity"

let token = localStorage.token
if (!token)
  token = localStorage.token = Math.random().toString(36).substr(-8)

class SearchBook extends React.Component{
    constructor(props){
        super(props)
        this.state = { 
            bookID:7,  
            title: 'uıkhjg', 
            authorID:5,
            available:true,my_book:{bookID:'', titlebook:'', IDauthor:'', availablebook:''}
          }
        this.handleChange=this.handleChange.bind(this)
    }
    handleChange(event){   this.setState({[event.target.name]:event.target.value})  }

    handleClick(event){
        fetch(api,
            {   
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Authorization': token,
                    "Access-Control-Allow-Origin":"*",
                    "Access-Control-Allow-Credentials":true
                },
                body: JSON.stringify(
                {
                  
                  bookID : this.state.bookID,
                  title : this.state.title,
                  authorID:this.state.authorID               
                })      
            }).then(data => data.my_book)
    }

    render(){
        return(
            <div>
                <p><b>Book Insertion </b></p>
                <label for="titlee">Book Title</label>
                <input name="titlee" type="text" value={this.state.title}
                    onChange={this.handleChange1} />
                <label for="bookIDD"><br/>BookID</label>
                <input name="bookIDD" type="text" value={this.state.bookID}
                    onChange={this.handleChange2} />
                <label for="authorIDD"><br/>AuthorID </label>
                <input name="authorIDD" type="text" value={this.state.authorID}
                    onChange={this.handleChange3} />

                <br/><button onClick={this.handleClick} >Insert Book</button>

            {(this.state.found===1) ? ((this.state.clicked===1)?(
                <p><br/>'Book Title: ' {this.state.my_book.title}
               <br/> 'BookID: ' {this.state.my_book.bookID}
               <br/> 'Author Name: ' {this.state.my_book.publishername}
               <br/> 'AuthorID: ' {this.state.my_book.authorID}
               <br/>'IsAvailable:' {this.state.my_book.available}</p>
            
        ):('Not Found!')) : ('')}
            </div>
        )}
    }

class BookInsertApp extends React.Component{
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
export default BookInsertApp;
