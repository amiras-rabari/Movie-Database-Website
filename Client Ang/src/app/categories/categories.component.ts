import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  public  cat  =["Home","Electronic","Fashion"];
  public returnedData ={};
  public returnedData2 ={};
  constructor(public route:ActivatedRoute, public http :HttpClient) {}

  ngOnInit(): void {
    this.http.get('http://localhost:8090/movies').subscribe(returnedData =>{
      this.returnedData = returnedData;
    });

    this.http.get('http://localhost:8090/actors').subscribe(returnedData =>{
      this.returnedData2 = returnedData;
    });
  }
  // here clickbutton will come which is view to source in side html page
  // dependency injectionof loginservice in cosntructor and get msg from validate method which it return and display using {{mesage }}
  // in html

}
