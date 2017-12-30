import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Shop } from './types/shop.type';
import { environment } from '../environments/environment';

@Injectable()
export class ShopService {

  constructor(private http: HttpClient) { }

  getEmployeesBySoopId(id: number) {
    return this.http.post<Shop[]>(environment.API_URL + "/shop", [id]);
  }

}
