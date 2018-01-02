import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { SearchService } from '../search.service';
import { Shop } from '../types/shop.type'
import * as $ from 'jquery';

@Component({
  selector: 'app-findshop',
  templateUrl: './findshop.component.html',
  styleUrls: ['./findshop.component.css']
})
export class FindshopComponent implements OnInit {

  address: string;
  shops: Shop[] = [];
  map;


  constructor(private http: HttpClient, private searchService: SearchService) { }

  ngOnInit() {
  }

  search() {
    console.log(this.address);
    this.http.get("https://maps.googleapis.com/maps/api/geocode/json?address=" + this.address + "&key=" + environment.MAPS_API_KEY)
      .subscribe(res => {
        var location = res["results"][0]["geometry"]["location"];
        console.log(location);
        this.map.panTo(location);
        this.searchService.searchByLocation(location["lat"], location["lng"], 1000000)
          .subscribe(shops => {
            this.shops = shops;
            console.log(shops);
          })
      });
  }

  selectShop(shop) {
    alert(shop.name);
  }

  onMapReady(map) {
    this.map = map;
  }

}
