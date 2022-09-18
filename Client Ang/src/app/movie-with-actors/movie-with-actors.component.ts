import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MoviesService } from '../movies.service';
import { Movie } from '../Models/Movie';
import { movieslist } from '../Models/movieslist';
import { Actor } from '../Models/Actor';

@Component({
  selector: 'app-movie-with-actors',
  templateUrl: './movie-with-actors.component.html',
  styleUrls: ['./movie-with-actors.component.css']
})
export class MovieWithActorsComponent implements OnInit {
  id:String = "";
  public movie!: Movie;
  public actors:Actor[] = [];
  constructor(public service:MoviesService,public route:ActivatedRoute, public http :HttpClient) {}

  ngOnInit(): void {
    this.route.params.subscribe(params =>{
      this.id = params['id'];
      this.service.getActors(this.id).subscribe(response=>{
        this.actors = response;
      });
      this.service.getMovie(this.id).subscribe(response=>{
        this.movie = response;
      });
    })

  }

}
