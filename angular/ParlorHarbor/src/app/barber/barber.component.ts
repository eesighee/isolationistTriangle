import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { SuiModalService, TemplateModalConfig, ModalTemplate } from 'ng2-semantic-ui';
import {DataTableModule} from "angular2-datatable";

import { LoginService } from '../login.service';

import { User, Barber } from '../types/user.type';
import { BarberService } from '../barber.service';
import { Shop } from '../types/shop.type';
import { barberReview } from '../types/barberReview.type';

export interface IContext {
  data: string;
}

@Component({
  selector: 'app-barber',
  templateUrl: './barber.component.html',
  styleUrls: ['./barber.component.css']
})
export class BarberComponent implements OnInit {

  @ViewChild('modalTemplate')
  public modalTemplate: ModalTemplate<IContext, string, string>
  private user: User;
  private barber: Barber;
  firstname: string = "";
  lastname: string = "";
  email: string = "";
  website: string = "";
  // shop: Store = null;

  reviews: barberReview[];

  // new review data
  rating: number;
  comment: string = "";

  constructor(private loginService: LoginService, private barberService: BarberService, private router: Router, private route: ActivatedRoute, public modalService: SuiModalService) { }

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

  addReview() {
    console.log(this.barber.id, this.rating, this.comment);
    this.barberService.addReview(this.barber.id, this.rating, this.comment);
    this.rating = 0;
    this.comment = "";
  }

  public open(dynamicContent: string = "") {
    const config = new TemplateModalConfig<IContext, string, string>(this.modalTemplate);

    config.closeResult = "closed!";
    config.context = { data: dynamicContent };

    this.modalService
      .open(config)
      .onApprove(result => { this.addReview(); })
      .onDeny(result => { /* closes the modal */ });
  }

}
