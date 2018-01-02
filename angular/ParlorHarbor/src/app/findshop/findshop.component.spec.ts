import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindshopComponent } from './findshop.component';

describe('FindshopComponent', () => {
  let component: FindshopComponent;
  let fixture: ComponentFixture<FindshopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindshopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindshopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
