import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  
username = "Amiras";
password ="12345678";

username1:Array<String>=[];
password1:Array<String>=[]

  constructor() { }
  // here my login validator method will go and logic for it
  addUser(username: string, password: string) {
    this.username1.push(username);
    this.password1.push(password);
    console.log(this.username1);
    console.log(this.password1);

  }
  // loginUser(username: String, password: String):boolean {
  //   if(this.username == username, this.password == password){
  //     return true;
  //   }else{
  //     return false;
  //   }
    
  // }

  loginUser(username: String, password: String):boolean {
    for(let i=0; i<this.username1.length; i++){
      if(this.username1[i] == username, this.password1[i] == password){
        return true;
        
      }
      
    }return false;
    
  }

 
}
