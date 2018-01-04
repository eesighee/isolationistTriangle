import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from './types/user.type';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { Appointment } from './types/appointment.type';


@Injectable()
export class UserService {


  constructor(private http: HttpClient) { }

  public user = new BehaviorSubject<User>(null);
  public appoint = new BehaviorSubject<Appointment[]>([]);

  getUser(id: number) {
    this.http.get<User>(environment.API_URL + "/user/" + id  + "/appntmnts").subscribe(u => {
      if (u) {
        this.user.next(u);
      }
    });
  }

  getAppointments(id: number) {
    return this.http.get<Appointment[]>(environment.API_URL + "/user/" + id);
  }

  getBarbAppointments(id: number) {
    return this.http.get<Appointment[]>(environment.API_URL + "/barber/" + id + "/appntmnts");
  }

}