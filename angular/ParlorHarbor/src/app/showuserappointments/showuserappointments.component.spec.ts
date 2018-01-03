import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowuserappointmentsComponent } from './showuserappointments.component';

describe('ShowuserappointmentsComponent', () => {
  let component: ShowuserappointmentsComponent;
  let fixture: ComponentFixture<ShowuserappointmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowuserappointmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowuserappointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
