import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Shop } from './types/shop.type';
import { environment } from '../environments/environment';
import { Barber } from './types/user.type';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ShopService {

  shop: Shop;
  employees: Array<Barber>;  

  constructor(private http: HttpClient) { }

  getEmployeesByShopId(id: number) {
    let observable: Observable<Barber[]> = this.http.post<Barber[]>(environment.API_URL + "/shop", [id]);
    observable.subscribe( barbers => {
      this.employees = barbers;
    });
    return observable;
  }

}
