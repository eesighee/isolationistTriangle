import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { LoginService } from '../login.service';

import { User, Barber } from '../types/user.type';
import { BarberService } from '../barber.service';
import { Shop } from '../types/shop.type';
import { barberReview } from '../types/barberReview.type';

@Component({
  selector: 'app-barber',
  templateUrl: './barber.component.html',
  styleUrls: ['./barber.component.css']
})
export class BarberComponent implements OnInit {

  private user: User;
  private barber: Barber;
  firstname: string = "";
  lastname: string = "";
  email: string = "";
  website: string = "";
  reviews: barberReview[];
  // shop: Store = null;

  constructor(private loginService: LoginService, private barberService: BarberService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.user = this.loginService.loginSubject.getValue();
    this.barberService.getBarber(+this.route.snapshot.paramMap.get('id'));
    this.barberService.barber.subscribe(b => { 
      this.barber = b; 
      if (b != null) {
        this.firstname = this.barber.fname;
        this.lastname = this.barber.lname;
        this.email = this.barber.email;
        this.website = this.barber.website;
        this.reviews = this.barberService.reviews;
        console.log(this.barber);
        console.log(this.reviews);
        // this.shop = this.barber.shop;
      }
    });
  }

  addReview(){
    this.barberService.addReview()
  }
}
