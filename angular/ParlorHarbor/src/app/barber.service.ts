import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { Barber, User } from './types/user.type';
import { barberReview } from './types/barberReview.type';

@Injectable()
export class BarberService {

  public barber = new BehaviorSubject<Barber>(null);

  barb: Barber;
  public reviews: barberReview[];

  constructor(private http: HttpClient) { }

  getBarber(id: number){
      this.http.get<Barber>(environment.API_URL + "/barber/" + id).subscribe(b => {
        if (b){
          this.http.get<barberReview[]>(environment.API_URL + "/barberreview/" + b.id).subscribe(r => {
            console.log("arrow return" + r);
            this.reviews = r;
            this.barber.next(b);
          });
        }
      });
  }
}
