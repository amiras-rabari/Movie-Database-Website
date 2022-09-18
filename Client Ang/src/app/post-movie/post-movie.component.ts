import { HttpClient } from '@angular/common/http';
import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MoviesService } from '../movies.service';
import { Movie } from '../Models/Movie';


@Component({
  selector: 'app-post-movie',
  templateUrl: './post-movie.component.html',
  styleUrls: ['./post-movie.component.css']
})
export class PostMovieComponent implements OnInit {

  constructor(public service:MoviesService,public route:ActivatedRoute, public http :HttpClient) {}

  ngOnInit(): void {
  }
  AddMovie(movie :Movie){
    this.service.createMovie(movie).subscribe(response =>{
      console.log(response);
      alert("Movie has been added");
    });
  }

}
