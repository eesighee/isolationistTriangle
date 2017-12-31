import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router';
import { Ng2UIModule, Ng2MapModule } from 'ng2-ui';

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
import { UserScheduleComponent } from './user-schedule/user-schedule.component';

const routes: Routes = [
  { path: "", redirectTo: "login", pathMatch: "full" },
  // { path: "home", component: HomeComponent, canActivate: [LoginService] },
  { path: "home", component: HomeComponent },
  { path: "register", component: RegisterComponent },
  { path: "login", component: LoginComponent },
  { path: "barber/:id", component: BarberComponent },
  //{ path: "map", component: MapComponent, canActivate: [LoginService] },
  { path: "map", component: MapComponent },
  //{ path: "**", redirectTo: "login" },

  { path: "search", component: LocationSearchComponent}, 
  { path: "shop/:id", component: ShopComponent}
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
    UserScheduleComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    Ng2UIModule,
    Ng2MapModule.forRoot({ apiUrl: 'https://maps.google.com/maps/api/js?key=' + environment.MAPS_API_KEY })
  ],
  providers: [
    LoginService, SearchService, ShopService, BarberService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
