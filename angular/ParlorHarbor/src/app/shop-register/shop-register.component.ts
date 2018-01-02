import { Component, OnInit } from '@angular/core';
import { ShopService } from '../shop.service';
import { Shop } from '../types/shop.type';

@Component({
  selector: 'app-shop-register',
  templateUrl: './shop-register.component.html',
  styleUrls: ['./shop-register.component.css']
})
export class ShopRegisterComponent implements OnInit {

  name = "";
  latitude = 0;
  longitude = 0;
  phone = "";
  website = "";
  address = "";
  description = "";
  hoursOfOperation = "";

  phoneMessage = "";
  addressMessage = "";

  constructor(private shopService: ShopService) { }

  ngOnInit() {
  }

  phoneBlur() {
    if (this.phone != "") {
      this.shopService.phoneAvailable(this.phone).subscribe(p => {
        if (p != null) {
          this.phoneMessage = "";
        }
        else{
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

  register(){
    var shop = new Shop({
      name: this.name,
      latitude: this.latitude,
      longitude: this.longitude,
      phone: this.phone,
      website: this.website,
      address: this.address,    
      description: this.description,
      hoursOfOperation: this.hoursOfOperation
    });
    if (!(this.addressMessage || this.phoneMessage)) this.shopService.addShop(shop);
  }

}
