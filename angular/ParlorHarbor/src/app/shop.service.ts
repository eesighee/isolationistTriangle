import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Shop } from './types/shop.type';
import { environment } from '../environments/environment';
import { BehaviorSubject } from 'rxjs';
import { Barber } from './types/user.type';

@Injectable()
export class ShopService {

  public shop = new BehaviorSubject<Shop>(null);
  public employees = new BehaviorSubject<Array<Barber>>(null);

  constructor(private http: HttpClient) { }

  getAllShops() {
    return this.http.get<Shop[]>(environment.API_URL + "/shop/all")
  }

  getShopById(id: number) {
    return this.http.get<Shop>(environment.API_URL + "/shop/" + id)
  }

  getEmployeesByShopId(id: number) {
    return this.http.get<Barber[]>(environment.API_URL + "/shop/" + id + "/employees");
  }

  phoneAvailable(phone: string) {
    return this.http.get<boolean>(environment.API_URL + "/shop/validphone/" + phone);
  }

  addressAvailable(address: string) {
    var result = this.http.get<boolean>(environment.API_URL + "/shop/validaddress/" + address);
    console.log(result);
    return result;
  }

  addShop(shop: Shop) {
    this.http.post<Shop>(environment.API_URL + "/shop/register", shop).subscribe();
  }

}
