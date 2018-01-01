import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Appointment } from './types/appoinment.type';
import { environment } from '../environments/environment';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class ScheduleService {

  public appointments = new BehaviorSubject<Appointment[]>(null);
  
  constructor(private http: HttpClient) { }

  getAppointmentsByBarberId(id: number){
    this.http.get<Appointment[]>(environment.API_URL + "/barber/" + id + "/appntmnts").subscribe(a => {
      if (a){
        this.appointments.next(a);
      }
    });
  }

}
