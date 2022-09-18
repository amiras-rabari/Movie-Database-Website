import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public username = "";
  public password="";
  constructor(public service:LoginService) { }

  ngOnInit(): void {
    console.log(this.username);
  }
  RegisterUser(){
    this.service.addUser(this.username,this.password);
    alert("user added please use credentials to login")
  

  }

}
