import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieWithActorsComponent } from './movie-with-actors.component';

describe('MovieWithActorsComponent', () => {
  let component: MovieWithActorsComponent;
  let fixture: ComponentFixture<MovieWithActorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MovieWithActorsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MovieWithActorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
