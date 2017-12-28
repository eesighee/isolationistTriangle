import { Component, OnInit } from '@angular/core';
import { Shop } from '../types/shop.type';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-location-search',
  templateUrl: './location-search.component.html',
  styleUrls: ['./location-search.component.css']
})
export class LocationSearchComponent implements OnInit {

  shops: Array<Shop>;
  x: number;
  y: number;
  r: number = 25;

  constructor(private locService: SearchService) { }

  ngOnInit() {
    this.x = (Math.random() * 100);
    this.y = (Math.random() * 100);
    this.locService.searchByLocation(this.x, this.y, this.r).subscribe(  shops => {
          this.shops = shops;
        });
        // this.http.post<Shop[]>(environment.API_URL + "/locate", [x, y]).subscribe(
    //    shops => {
    //     this.shopSubject = shops;
    //   }
    // );
    //console.log(this.shops.length);
  }

}
