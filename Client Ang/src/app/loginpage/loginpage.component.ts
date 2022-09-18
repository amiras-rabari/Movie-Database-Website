import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
public username = "";
public password="";
  constructor(public service:LoginService) { }

  ngOnInit(): void {
  }
  loginUser(){
   
    if(this.service.loginUser(this.username,this.password)){
      alert("logged in")
    }else{
      alert("please enter valid credentials or Register")
    }
  }

}
