import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Shop } from './types/shop.type';
import { environment } from '../environments/environment';
import { Barber } from './types/user.type';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class ShopService {

  public shop = new BehaviorSubject<Shop>(null);
  public employees = new BehaviorSubject<Array<Barber>>(null);

  constructor(private http: HttpClient) { }

  getShopById(id: number) {
    this.http.get<Shop>(environment.API_URL + "/shop/" + id).subscribe(s => {
      if (s){
        this.shop.next(s);
      }
    });     
  }

  getEmployeesByShopId(id: number) {
    this.http.get<Barber[]>(environment.API_URL + "/shop/" + id + "/employees").subscribe( barbers => {
      if(barbers){
        this.employees.next(barbers);
      }
    });
  }
    

}
