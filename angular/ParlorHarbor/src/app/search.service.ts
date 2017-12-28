import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Shop } from './types/shop.type';
import { Subject } from 'rxjs/Subject';
import { environment } from '../environments/environment';

@Injectable()
export class SearchService {

  //shopSubject: Array<Shop>;

  constructor(private http: HttpClient) { }
    /**
     * This sets shops to the all shops ordered by proximity of params 
     */
   searchByLocation( x: number, y: number) {
    console.log("searchByLocation called");  
    return this.http.post<Shop[]>(environment.API_URL + "/locate", [x, y]);
   
    // this.http.post<Shop[]>(environment.API_URL + "/locate", [x, y]).subscribe(
    //    shops => {
    //     this.shopSubject = shops;
    //   }
    // );
    // console.log(this.shopSubject.length);    
   }

  

}
