import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BarberartworkComponent } from './barberartwork.component';

describe('BarberartworkComponent', () => {
  let component: BarberartworkComponent;
  let fixture: ComponentFixture<BarberartworkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BarberartworkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BarberartworkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
