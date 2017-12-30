import { Component, OnInit } from '@angular/core';
import { Shop } from '../types/shop.type';
import { Barber } from '../types/barber.type';
import { StylingService } from '../types/Styling-Service.type';
import { User } from '../types/user.type';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  shop: Shop;
  description: string;
  address: string;
  phone: string;
  employees: Array<Barber>;
  rating: number;
  hoursOfOp: String;
  stylingServices: Set<StylingService>;

  shopId: number;
  
  constructor(private shopService: ShopService) { }
  
  ngOnInit() {
    for (let e of this.employees) {
      this.rating += e.rating;
      for (let s of e.services){
        this.stylingServices.add(s);
      }
    }
    //this.rating /= this.employees.length;
  }

}
