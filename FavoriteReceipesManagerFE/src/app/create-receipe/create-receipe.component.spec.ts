import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateReceipeComponent } from './create-receipe.component';

describe('CreateReceipeComponent', () => {
  let component: CreateReceipeComponent;
  let fixture: ComponentFixture<CreateReceipeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateReceipeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateReceipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
