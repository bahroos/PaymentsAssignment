import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateReceipeComponent } from './update-receipe.component';

describe('UpdateReceipeComponent', () => {
  let component: UpdateReceipeComponent;
  let fixture: ComponentFixture<UpdateReceipeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateReceipeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateReceipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
