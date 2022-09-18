import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movie } from '../Models/Movie';
import { MoviesService } from '../movies.service';

@Component({
  // this selector tells how component will be used as element , this is just like<div> or <span>
  // now you can use <app-menu> as html elemnt
  // so each componennt is seperate html element as well
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  public name:String =" "
  public categories =["home" ,"setting", "logout"]
 
  constructor(public service:MoviesService,public route:ActivatedRoute, public http :HttpClient) {}

  public movie!: Movie;

  ngOnInit(): void {
   
  }

  GetMovieByTitle(){
    this.service.GetMovieByTitle(this.name).subscribe(response=>{
      this.movie =response;
      console.log(this.movie);
      

    });
    
   
  }
 

}
