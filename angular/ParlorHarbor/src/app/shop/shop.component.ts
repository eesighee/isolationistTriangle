import { Component, OnInit, Input } from '@angular/core';
import { Shop } from '../types/shop.type';
import { Barber } from '../types/user.type';
import { Router } from '@angular/router';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  @Input() shop = null;
  employees = [];

  hoursOfOp = "10:00 am to 7:30 pm";

  constructor(private router: Router, private searchService: SearchService) { }

  ngOnInit() {
    this.searchService.getBarbersByShop(this.shop).subscribe(barbs => this.employees = barbs);
  }

  loadBarber(id: number) {
    this.router.navigate(["barber", id]);
  }

}