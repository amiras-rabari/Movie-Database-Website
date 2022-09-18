import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActorsService } from '../actors.service';
import { Actor } from '../Models/Actor';

@Component({
  selector: 'app-actors',
  templateUrl: './actors.component.html',
  styleUrls: ['./actors.component.css']
})
export class ActorsComponent implements OnInit {

  AllActors:Actor[] =[]
  constructor(public service:ActorsService,public route:ActivatedRoute, public http :HttpClient) {}
  ngOnInit(): void {
    this.service.getAllActors().subscribe(response=>{
      this.AllActors = response;
  })
  }
 

}
