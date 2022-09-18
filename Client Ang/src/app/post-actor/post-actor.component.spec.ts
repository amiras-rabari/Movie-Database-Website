import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostActorComponent } from './post-actor.component';

describe('PostActorComponent', () => {
  let component: PostActorComponent;
  let fixture: ComponentFixture<PostActorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostActorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PostActorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
