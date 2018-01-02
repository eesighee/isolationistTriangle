import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import {User} from './types/user.type';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { Appointment } from './types/appointments';


@Injectable()
export class UserService {

  private apiUrl = 'http://localhost:8888';

  constructor(private http: HttpClient) { }

  public user = new BehaviorSubject<User>(null);
  public appoint = new BehaviorSubject<Appointment[]>(null);

  getUser(id: number){
    this.http.get<User>(environment.API_URL + "/user/" + id).subscribe(u => {
      if (u){
          this.user.next(u);
      }
    });
  }

  getAppointments(id:number){
    this.http.get<Appointment[]>(this.apiUrl + "/user/" +id)
    .subscribe(
      res => {
        console.log(res);
        this.appoint.next(res);
        //user = res;
        //console.log(user);
      },
      err => {
        console.log("Error occured");
      }
    );
  }

}
