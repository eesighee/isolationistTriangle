import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { Barber, User } from './types/user.type';
import { barberReview } from './types/barberReview.type';
import { StylingService } from './types/Styling-Service.type';
import { Appointment } from './types/appointment.type';
import { DateComparer } from 'ng2-semantic-ui/dist';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap/datepicker/ngb-date-struct';

@Injectable()
export class BarberService {

  public barber = new BehaviorSubject<Barber>(null);

  barb: Barber;
  public reviews: barberReview[] = [];
  public services: StylingService[] = [];
  public appointments: Appointment[] = [];


  constructor(private http: HttpClient) { }

  getBarber(id: number) {
    this.http.get<Barber>(environment.API_URL + "/barber/" + id).subscribe(b => {
      if (b) {
        this.barb = b;
        this.http.get<barberReview[]>(environment.API_URL + "/barberreview/" + b.id).subscribe(r => {
          this.reviews = r;
          this.http.get<StylingService[]>(environment.API_URL + "/barber/" + b.id + "/services").subscribe(s => {
            this.services = s;
            this.http.get<Appointment[]>(environment.API_URL + "/barber/" + b.id + "/appntmnts").subscribe(a => {
              this.appointments = a;
              this.barber.next(b);
            });
          });
        });
      }
    });
  }

  addReview(barberId: number, rating: number, comment: string) {
    this.http.post<barberReview>(environment.API_URL + "/barberreview/add", [barberId, rating, comment]).subscribe(rev => {
      if (rev) {
        this.reviews.push(rev);
        this.barber.next(this.barb);
      }
    });
  }

  addService(barberId: number, description: string, price: number, type: number) {
    this.http.post<StylingService>(environment.API_URL + "/service/add", [barberId, description, price, type]).subscribe(serv => {
      if (serv) {
        this.services.push(serv);
        this.barber.next(this.barb);
      }
    });
  }

  addAppointment(date: Date, barber: Barber, user: User, service: StylingService) {

    let appToAdd = new Appointment();
    appToAdd.time = date.toISOString();
    appToAdd.customer = user;
    appToAdd.barber = barber;
    appToAdd.stylingService = service;

    this.http.post<Appointment>(environment.API_URL + "/appointment/add", appToAdd).subscribe(appoint => {
      if (appoint) {
        this.appointments.push(appoint);
        this.barber.next(this.barb);
      }
    });
  }

  populateTimeArray(checkDate: NgbDateStruct) {
    let availableTimeslots: Date[] = [];
    var hour = 8;
    // var opening = this.barb.shop.openingTime;
    // var oDate = new Date(opening);
    // var closing = this.barb.shop.closingTime;
    // console.log(opening + "  " + closing);
    for (let i = 0; i < 24; i++) {
      if (i % 2 == 0) {
        let addDate = new Date(checkDate.year, checkDate.month - 1, checkDate.day, hour, 0, 0, 0);
        // if (oDate.getHours > addDate && new Date(closing) < addDate) {
          availableTimeslots.push(addDate);
        // }
      }
      else {
        let addDate = new Date(checkDate.year, checkDate.month - 1, checkDate.day, hour, 30, 0, 0);
        // if (oDate.getHours > addDate && new Date(closing) < addDate) {
          availableTimeslots.push(addDate);
        // }
        hour++;
      }
    }
    return this.checkAvailableTimes(availableTimeslots);
  }

  checkAvailableTimes(availableTimeslots: Date[]) {
    var length = availableTimeslots.length;

    for (let i = 0; i < length; i++) {
      for (let j = 0; j < this.appointments.length; j++) {
        if (availableTimeslots[i].toISOString() == this.appointments[j].time) {
          availableTimeslots.splice(i, 1);
          length--;
          j = 0;
          if (i >= length) {
            break;
          }
        }
      }
    }
    return availableTimeslots;
  }

}