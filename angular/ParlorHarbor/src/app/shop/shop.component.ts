import { Component, OnInit } from '@angular/core';
import { Shop } from '../types/shop.type';
import { StylingService } from '../types/Styling-Service.type';
import { User, Barber } from '../types/user.type';
import { ShopService } from '../shop.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  shop: Shop = this.shopService.shop;
  employees: Array<Barber> = this.shopService.employees;  
  
  description: string;
  address: string;
  phone: string;
  rating: number;
  hoursOfOp: String;
  stylingServices: Set<StylingService>;

  shopId: number;
  
  constructor(private shopService: ShopService) { }
  
  ngOnInit() {
    this.shopId = this.shopId;
    this.employees = this.employees;
  }
  
  loadShop() {
    this.shopService.getEmployeesByShopId(this.shopId).subscribe( emps => {
      this.employees = emps;
      this.shop = this.employees[0].shop;      
    });
  }

}
