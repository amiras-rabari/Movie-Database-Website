import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Actor } from './Models/Actor';
import { Movie } from './Models/Movie';
import { movieslist } from './Models/movieslist';

@Injectable({
  providedIn: 'root'
})
export class ActorsService {
 
 


  constructor(public http :HttpClient) { }

  getAllActors():Observable<Actor[]>{
    return this.http.get<Actor[]>('http://localhost:8090/actors');
  }

  addActor(actor: Actor):Observable<Actor> {
    return this.http.post<Actor>('http://localhost:8090/actors',actor);
  }

  getActors(id: String):Observable<Actor> {
    return this.http.get<Actor>('http://localhost:8090/actors/'+id);
  }

  getMovies(id: String):Observable<movieslist[]> {
    return this.http.get<movieslist[]>('http://localhost:8090/actors/movie/'+id);
  }

}



