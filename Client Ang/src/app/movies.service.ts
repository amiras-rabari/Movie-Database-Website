import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { movieslist } from './Models/movieslist';
import { Movie } from './Models/Movie';
import { Actor } from './Models/Actor';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  
 
  


  constructor(public http :HttpClient) { }

  getAllMovies():Observable<movieslist[]>{
    return this.http.get<movieslist[]>('http://localhost:8090/movies');


  }

  createMovie(movie: Movie):Observable<Movie> {
   return this.http.post<Movie>('http://localhost:8090/movies',movie);
  }

  getMovie(id: String):Observable<Movie> {
    return this.http.get<Movie>('http://localhost:8090/movies'+'/'+id);
  }
  getActors(id: String):Observable<Actor[]> {
    return this.http.get<Actor[]>('http://localhost:8090/movies/actor'+'/'+id);
  }

  GetMovieByTitle(title: String): Observable<Movie> {
    return this.http.get<Movie>('http://localhost:8090/movies/title'+'/'+title);
  }
}
