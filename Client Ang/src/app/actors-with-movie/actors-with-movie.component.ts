import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActorsService } from '../actors.service';
import { Actor } from '../Models/Actor';
import { Movie } from '../Models/Movie';
import { movieslist } from '../Models/movieslist';

@Component({
  selector: 'app-actors-with-movie',
  templateUrl: './actors-with-movie.component.html',
  styleUrls: ['./actors-with-movie.component.css']
})
export class ActorsWithMovieComponent implements OnInit {
  id:String ="";
  public Allmovies: movieslist[] =[];
  public actor!:Actor;
  constructor(public service:ActorsService,public route:ActivatedRoute, public http :HttpClient) {}

  ngOnInit(): void {
    this.route.params.subscribe(params =>{
      this.id = params['id'];
      this.service.getActors(this.id).subscribe(response=>{
        this.actor = response;
      });
      this.service.getMovies(this.id).subscribe(response=>{
        this.Allmovies = response;
      });
    })
  }

}
