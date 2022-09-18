import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActorsWithMovieComponent } from './actors-with-movie.component';

describe('ActorsWithMovieComponent', () => {
  let component: ActorsWithMovieComponent;
  let fixture: ComponentFixture<ActorsWithMovieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActorsWithMovieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActorsWithMovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
