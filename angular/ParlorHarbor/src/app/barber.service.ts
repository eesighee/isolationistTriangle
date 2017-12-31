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
          this.barb = b;
          this.http.get<barberReview[]>(environment.API_URL + "/barberreview/" + b.id).subscribe(r => {
            this.reviews = r;
            this.barber.next(b);
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
}
