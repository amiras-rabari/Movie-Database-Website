import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActorsService } from '../actors.service';
import { Actor } from '../Models/Actor';


@Component({
  selector: 'app-post-actor',
  templateUrl: './post-actor.component.html',
  styleUrls: ['./post-actor.component.css']
})
export class PostActorComponent implements OnInit {

  constructor(public service:ActorsService,public route:ActivatedRoute, public http :HttpClient) {}

  ngOnInit(): void {
  }

  AddActor(actor:Actor){
    this.service.addActor(actor).subscribe(response =>{
      console.log(response);
      alert("Actor haas been Added");
    });
  }

}
