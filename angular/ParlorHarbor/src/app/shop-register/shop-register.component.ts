import { Component, OnInit } from '@angular/core';
import { ShopService } from '../shop.service';
import { Shop } from '../types/shop.type';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-shop-register',
  templateUrl: './shop-register.component.html',
  styleUrls: ['./shop-register.component.css']
})
export class ShopRegisterComponent implements OnInit {

  name = "";
  phone = "";
  website = "";
  address = "";
  description = "";
  openingTime = "";
  closingTime = "";
  hoursOfOperation = "";

  phoneMessage = "";
  addressMessage = "";

  constructor(private shopService: ShopService, private http: HttpClient) { }

  ngOnInit() {
  }

  phoneBlur() {
    if (this.phone != "") {
      this.shopService.phoneAvailable(this.phone).subscribe(p => {
        if (p != null) {
          this.phoneMessage = "";
        }
        else {
          this.phoneMessage = "That phone number is invalid";
        }
      });
    }
  }

  addressBlur() {
    if (this.address != "") {
      this.shopService.addressAvailable(this.address).subscribe(a => {
        if (a != null) {
          this.addressMessage = "";
        }
        else {
          this.addressMessage = "That address is invalid";
        }
      });
    }

  }

  register() {
    this.addressBlur();
    this.phoneBlur();

    if (this.name && this.address && this.description && this.phone) {
      this.http.get("https://maps.googleapis.com/maps/api/geocode/json?address=" + this.address + "&key=" + environment.MAPS_API_KEY)
        .subscribe(res => {
          var latlng = res["results"][0]["geometry"]["location"];
          var shop = new Shop({
            name: this.name,
            latitude: latlng["lat"],
            longitude: latlng["lng"],
            phone: this.phone,
            website: this.website,
            address: this.address,
            description: this.description,
            hoursOfOperation: this.hoursOfOperation
          });
          if (!(this.addressMessage || this.phoneMessage)) {
            this.shopService.addShop(shop).subscribe(shop => {
              alert("Shop added sucessfully");
              this.address = "";
              this.description = "";
              this.name = "";
              this.phone = "";
              this.website = "";
            });
          }
        });
    } else {
      alert("Please enter all required information");
    }





  }

}