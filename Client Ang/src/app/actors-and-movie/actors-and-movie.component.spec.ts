import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActorsAndMovieComponent } from './actors-and-movie.component';

describe('ActorsAndMovieComponent', () => {
  let component: ActorsAndMovieComponent;
  let fixture: ComponentFixture<ActorsAndMovieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActorsAndMovieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActorsAndMovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
