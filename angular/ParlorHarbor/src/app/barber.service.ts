import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { Barber } from './types/barber.type';
import { environment } from '../environments/environment';

@Injectable()
export class BarberService {

  public barber = new BehaviorSubject<Barber>(null);
  string apiUrl = "http://localhost:8091/";

  constructor(private http: HttpClient) { }

  getBarber(id: number){
    this.http.get<Barber>(environment.apiUrl + "/barber" + {id}, [id]).subscribe(acc => {
      if (acc){ 
        console.log("account returned in arrow");
        this.updateSubject.next(acc);
      }
      else {
        console.log("null response in arrow");
      }
    });
  }
}
