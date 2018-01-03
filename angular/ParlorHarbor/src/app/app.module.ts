import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router';
import { Ng2UIModule, Ng2MapModule } from 'ng2-ui';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { SuiModule } from 'ng2-semantic-ui';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


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
import { UserComponent } from './user/user.component';
import { ScheduleService } from './schedule.service';
import { ShopRegisterComponent } from './shop-register/shop-register.component';

const routes: Routes = [
  { path: "", redirectTo: "login", pathMatch: "full" },
   { path: "home", component: HomeComponent, canActivate: [LoginService] },
  { path: "home", component: HomeComponent },
  { path: "register", component: RegisterComponent },
  { path: "login", component: LoginComponent },
  { path: "barber/:id", component: BarberComponent },
  { path: "map", component: MapComponent, canActivate: [LoginService] },
  { path: "map", component: MapComponent },
  //{ path: "**", redirectTo: "login" },

  { path: "search", component: LocationSearchComponent}, 
  { path: "shop/:id", component: ShopComponent},
  { path: "barber/:id/appointments", component: UserScheduleComponent},
  { path: "shopregister", component: ShopRegisterComponent}
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
    UserComponent,
    UserScheduleComponent,
    ShopRegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    Ng2UIModule,
    Ng2MapModule.forRoot({ apiUrl: 'https://maps.google.com/maps/api/js?key=' + environment.MAPS_API_KEY }),
    AngularFontAwesomeModule,
    NgbModule.forRoot(),
    SuiModule
  ],
  providers: [
    LoginService, SearchService, ShopService, BarberService, ScheduleService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
