import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Shop } from './types/shop.type';
import { Barber } from './types/user.type';
import { Subject } from 'rxjs/Subject';
import { environment } from '../environments/environment';

@Injectable()
export class SearchService {

  //shopSubject: Array<Shop>;

  constructor(private http: HttpClient) { }
    /**
     * This sets shops to the all shops ordered by proximity of params 
     */
   searchByLocation( x: number, y: number, r: number) {
    return this.http.get<Shop[]>(environment.API_URL + "/locate/search/" + x + "/" + y + "/" + r);
  
  }
  
  getBarbersByShop(shop) {
    return this.http.get<Barber[]>(environment.API_URL + "/shop/" + shop.id + "/employees");
  }

  

}
