import { Component, OnInit } from '@angular/core';
import { Shop } from '../types/shop.type';
import { StylingService } from '../types/Styling-Service.type';
import { User, Barber } from '../types/user.type';
import { ShopService } from '../shop.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  private shop: Shop;
  private employees: Array<Barber>;  
  
  description: string;
  address: string;
  phone: string;
  rating: number;
  hoursOfOp: String;
  stylingServices: Set<StylingService>;

  constructor(private shopService: ShopService, private router: Router, private route: ActivatedRoute) { }
  
  ngOnInit() {
    this.shopService.getShopById(+this.route.snapshot.paramMap.get('id'));
    this.shopService.shop.subscribe( s => {
      this.shop = s;
      if (s != null){
        this.shopService.getEmployeesByShopId(s.id);
        this.shopService.employees.subscribe( e => {
          this.employees = e;
        });
      }
    });
  }

  loadBarber(id: number){
    this.router.navigate(["barber/" + id]);
  }

}
