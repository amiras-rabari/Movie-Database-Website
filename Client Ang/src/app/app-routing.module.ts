import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActorsWithMovieComponent } from './actors-with-movie/actors-with-movie.component';
import { ActorsComponent } from './actors/actors.component';
import { HomeComponent } from './home/home.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { MenuComponent } from './menu/menu.component';
import { MovieWithActorsComponent } from './movie-with-actors/movie-with-actors.component';
import { MoviesComponent } from './movies/movies.component';
import { PostActorComponent } from './post-actor/post-actor.component';
import { PostMovieComponent } from './post-movie/post-movie.component';
import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
 {path :"movies" , component:MoviesComponent},
 {path :"actors" , component:ActorsComponent},
 {path : "PostMovie", component:PostMovieComponent},
 {path :"movies/:id" , component:MovieWithActorsComponent},
 {path:"Postactors" , component:PostActorComponent},
 {path :"actors/:id" , component:ActorsWithMovieComponent},
 {path :"" , component:HomeComponent},
 {path :"home" , component:HomeComponent},
 {path :"login" , component:LoginpageComponent},
 {path :"register" , component:RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
