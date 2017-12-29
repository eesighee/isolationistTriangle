import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LoginService } from '../login.service';

import { User } from '../types/user.type';
import { Barber } from '../types/barber.type';
import { BarberService } from '../barber.service';

@Component({
  selector: 'app-barber',
  templateUrl: './barber.component.html',
  styleUrls: ['./barber.component.css']
})
export class BarberComponent implements OnInit {

  private user: User;
  private barber: Barber;

  constructor(private loginService: LoginService, private barberService: BarberService, private router: Router) { }

  ngOnInit() {
    this.user = this.loginService.loginSubject.getValue();
    this.getBarber();
  }

  getBarber(){
    this.barberService.getBarber(id)
    .subscribe(barber => this.barber = barber);
  }


}
