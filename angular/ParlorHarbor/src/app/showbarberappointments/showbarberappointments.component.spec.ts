import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowbarberappointmentsComponent } from './showbarberappointments.component';

describe('ShowbarberappointmentsComponent', () => {
  let component: ShowbarberappointmentsComponent;
  let fixture: ComponentFixture<ShowbarberappointmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowbarberappointmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowbarberappointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
