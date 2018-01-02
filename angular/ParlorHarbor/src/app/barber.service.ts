import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { Barber, User } from './types/user.type';
import { barberReview } from './types/barberReview.type';
import { StylingService } from './types/Styling-Service.type';
import { Appointment } from './types/appoinment.type';
import { DateComparer } from 'ng2-semantic-ui/dist';

@Injectable()
export class BarberService {

  public barber = new BehaviorSubject<Barber>(null);

  barb: Barber;
  public reviews: barberReview[];
  public services: StylingService[];
  public appointments: Appointment[];
  public availableTimeslots: Date[] = [];



  constructor(private http: HttpClient) { }

  getBarber(id: number){
      this.http.get<Barber>(environment.API_URL + "/barber/" + id).subscribe(b => {
        if (b){
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

  addReview(barberId: number, rating: number, comment: string){
    this.http.post<barberReview>(environment.API_URL + "/barberreview/add", [barberId, rating, comment]).subscribe(rev => {
      console.log("outside rev if" + rev);
      if (rev){
        console.log("in rev if)")
        this.reviews.push(rev);
        this.barber.next(this.barb);
      }
    });
  }

  addService(barberId: number, description: string, price: number, type: number){
    console.log(barberId + " " + description +" " + price +" " + type)
    this.http.post<StylingService>(environment.API_URL + "/service/add", [barberId, description, price, type]).subscribe(serv => {
      console.log("outside serv if" + serv);
      if (serv){
        console.log("in serv if");
        this.services.push(serv);
        this.barber.next(this.barb);
      }
    });
  }

  addAppointment(date: Date, barberId: number, userId: number, serviceId: number){

  }

  populateTimeArray(checkDate: Date){
    var hour = 0; console.log(checkDate);
    for(let i = 0; i < 48; i++){
      if ( i % 2 == 0){
        let addDate = new Date(checkDate.getFullYear(), checkDate.getMonth(), checkDate.getDate(), hour, 0, 0, 0);
        console.log(addDate);
        this.availableTimeslots.push(addDate);
      }
      else {
        let addDate = new Date(checkDate.getFullYear(), checkDate.getMonth(), checkDate.getDate(), hour, 30, 0, 0);
        this.availableTimeslots.push(addDate);
        hour++;
      }
    }
    // this compares dates correctly for some reason console.log(d.getTime() == n.getTime());
    
    console.log(this.availableTimeslots);
    
    // Get this barbers' shop's opening/closing time to display 30 minute intervals in an array
    // Compare the 30 minute intervals against the times in the appointments array
    // Pass an array with the open time slots back to the component to display the open timeslots
  }

  checkAvailableTimes(){
    for(let i = 0; i < this.availableTimeslots.length; i++){
      for(let j = 0; j < this.appointments.length; i++){
        if(this.availableTimeslots[i].getTime() == this.appointments[j].time.getTime()){
          this.availableTimeslots.splice(i);
        }
      }
    }
  }

}
