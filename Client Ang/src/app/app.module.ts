import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { CategoriesComponent } from './categories/categories.component';
import { PascalPipe } from './pascal.pipe';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MoviesComponent } from './movies/movies.component';
import { ActorsComponent } from './actors/actors.component';
import { PostMovieComponent } from './post-movie/post-movie.component';
import { MovieWithActorsComponent } from './movie-with-actors/movie-with-actors.component';
import { PostActorComponent } from './post-actor/post-actor.component';
import { ActorsWithMovieComponent } from './actors-with-movie/actors-with-movie.component';
import { ActorsAndMovieComponent } from './actors-and-movie/actors-and-movie.component';
import { HomeComponent } from './home/home.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    CategoriesComponent,
    PascalPipe,
    MoviesComponent,
    ActorsComponent,
    PostMovieComponent,
    MovieWithActorsComponent,
    PostActorComponent,
    ActorsWithMovieComponent,
    ActorsAndMovieComponent,
    HomeComponent,
    LoginpageComponent,
    RegisterComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
