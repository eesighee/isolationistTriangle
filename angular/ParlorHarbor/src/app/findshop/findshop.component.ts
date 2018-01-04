import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { SearchService } from '../search.service';
import { Shop } from '../types/shop.type'
import { ServiceType } from '../types/servicetype.type'
import * as $ from 'jquery';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { subscribeOn } from 'rxjs/operator/subscribeOn';
import { ShopComponent } from '../shop/shop.component';

@Component({
  selector: 'app-findshop',
  templateUrl: './findshop.component.html',
  styleUrls: ['./findshop.component.css']
})
export class FindshopComponent implements OnInit {

  address: string;
  shops: Shop[] = [];
  map;
  radius: number = 10;

  currentShop = null;
  employees = [];


  constructor(private http: HttpClient, private searchService: SearchService, private modal: NgbModal) { }

  ngOnInit() {
  }

  search() {
    this.http.get("https://maps.googleapis.com/maps/api/geocode/json?address=" + this.address + "&key=" + environment.MAPS_API_KEY)
      .subscribe(res => {
        var location = res["results"][0]["geometry"]["location"];
        this.map.panTo(location);
        this.searchService.searchByLocation(location["lat"], location["lng"], this.radius)  
          .subscribe(shops => {
            if (shops.length == 0) alert("There are no shops that meet that criteria");
            this.shops = shops;
            console.log(this.shops);
          })
      });
  }

  selectShop(shop) {
    document.getElementById(shop.id).scrollIntoView();
  }

  onMapReady(map) {
    this.map = map;
  }



}
