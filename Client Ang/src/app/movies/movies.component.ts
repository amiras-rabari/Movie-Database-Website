import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MoviesService } from '../movies.service';
import { movieslist } from '../Models/movieslist';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  Allmovies:movieslist[]=[];
  constructor(public service:MoviesService,public route:ActivatedRoute, public http :HttpClient) {}

  ngOnInit(): void {
    this.service.getAllMovies().subscribe(response =>{
      this.Allmovies = response;
    })
  }



}
