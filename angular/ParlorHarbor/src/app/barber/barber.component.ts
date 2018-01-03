import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { SuiModalService, TemplateModalConfig, ModalTemplate } from 'ng2-semantic-ui';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

import { LoginService } from '../login.service';

import { User, Barber } from '../types/user.type';
import { BarberService } from '../barber.service';
import { Shop } from '../types/shop.type';
import { barberReview } from '../types/barberReview.type';
import { StylingService } from '../types/Styling-Service.type';
import { Appointment } from '../types/appoinment.type';

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
  shop: Shop;
  shopname: string = "";

  services: StylingService[] = [];
  appointments: Appointment[] = [];
  reviews: barberReview[] = [];


  availableTimeslots: Date[] = [];
  scheduleDate: number = 0;
  scheduleService: number = 0;

  selectedIndex: number = 0;

  myAppointmentDates: Date[] = [];

  model: NgbDateStruct;
  date: {year: number, month: number};

  // new review data
  rating: number = 0;
  comment: string = "";

  //new service
  description: string = "";
  price: number = 0;
  serviceType: number = 1;



  isLogged: boolean = false;
  isBarber: boolean = false;
  

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
        this.shop = this.barber.shop;
        this.shopname = this.barber.shop.name;
        this.reviews = this.barberService.reviews;
        this.services = this.barberService.services;
        this.appointments = this.barberService.appointments;
        for(let i = 0; i < this.appointments.length; i++){
          this.myAppointmentDates[i] = new Date(this.appointments[i].time);
        }
        if(this.user.id == this.barber.id){
          this.isLogged = true;
        }
        else {
          this.isLogged = false;
        }
        if(this.user.role.id == 2){
          this.isBarber = true;
        }
        else {
          this.isBarber = false;
        }
      }
    });
  }

  getTimeslots(){
    this.availableTimeslots = this.barberService.populateTimeArray(this.model);
  }

  addAppointment(){
    this.barberService.addAppointment(this.availableTimeslots[this.scheduleDate], this.barber, this.user, this.services[this.scheduleService]);
  }

  addReview() {
    this.barberService.addReview(this.barber.id, this.rating, this.comment);
    this.rating = 0;
    this.comment = "";
  }

  addService() {
    this.barberService.addService(this.barber.id, this.description, this.price, this.serviceType);
    this.description = "";
    this.price = 0;
    this.serviceType = 1;
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

  sendToShop(){
    this.router.navigate(["shop/" + this.barber.shop.id]);
  }

}
