import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router';
import { Ng2UIModule, Ng2MapModule } from 'ng2-ui';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { LoginService } from './login.service';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import { MapComponent } from './map/map.component';
import { environment } from '../environments/environment';

import { LocationSearchComponent } from './location-search/location-search.component';
import { SearchService } from './search.service';
import { ShopComponent } from './shop/shop.component';
import { ShopService } from './shop.service';
import { BarberComponent } from './barber/barber.component';
import { BarberService } from './barber.service';
import { FileuploadComponent } from './fileupload/fileupload.component';
import { LandingComponent } from './landing/landing.component';
import { FindshopComponent } from './findshop/findshop.component';

const routes: Routes = [
  { path: "", redirectTo: "landing", pathMatch: "full" },
  { path: "home", component: HomeComponent, canActivate: [LoginService] },
  { path: "landing", component: LandingComponent },
  { path: "barber/:id", component: BarberComponent },
  { path: "map", component: MapComponent, canActivate: [LoginService] },
  { path: "search", component: LocationSearchComponent },
  { path: "shop", component: ShopComponent },
  { path: "findshop", component: FindshopComponent },
  { path: "**", redirectTo: "landing" }
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    BarberComponent,
    MapComponent,
    LocationSearchComponent,
    ShopComponent,
    FileuploadComponent,
    LandingComponent,
    FindshopComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    Ng2UIModule,
    Ng2MapModule.forRoot({ apiUrl: 'https://maps.google.com/maps/api/js?key=' + environment.MAPS_API_KEY }),
    NgbModule.forRoot()

  ],
  providers: [
    LoginService, SearchService, ShopService, BarberService
  ],
  bootstrap: [
    AppComponent
  ],
  entryComponents: [
    LoginComponent,
    RegisterComponent
  ]
})
export class AppModule { }
