import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Artwork } from '../types/atrwork.type';
import { environment } from '../../environments/environment';
import { Barber } from '../types/user.type';

@Component({
  selector: 'app-barberartwork',
  templateUrl: './barberartwork.component.html',
  styleUrls: ['./barberartwork.component.css']
})
export class BarberartworkComponent implements OnInit {

  @Input() barber: Barber;
  artwork: Artwork[];
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<Artwork[]>(environment.API_URL + "/artwork/" + this.barber.id).subscribe(art => {
      console.log(art);
      this.artwork = art;
    });
  }

  addArt(art: Artwork) {
    console.log(art);
    this.artwork.push(art);
  }

}
