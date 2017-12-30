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
import { BarberComponent } from './barber/barber.component';
import { MapComponent } from './map/map.component';
import { environment } from '../environments/environment';
<<<<<<< HEAD
import { MakeAppointmentComponent } from './make-appointment/make-appointment.component';
import { AppointmentService } from './appointment.service';
=======
import { BarberService } from './barber.service';
>>>>>>> barberProfile

const routes: Routes = [
  { path: "", redirectTo: "login", pathMatch: "full" },
  { path: "home", component: HomeComponent, canActivate: [LoginService] },
  { path: "register", component: RegisterComponent },
  { path: "login", component: LoginComponent },
  { path: "map", component: MapComponent, canActivate: [LoginService] },
  { path: "barber/:id", component: BarberComponent },
  { path: "**", redirectTo: "login" }
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
<<<<<<< HEAD
    MapComponent,
    MakeAppointmentComponent
=======
    BarberComponent,
    MapComponent
>>>>>>> barberProfile
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
<<<<<<< HEAD
    LoginService,
    AppointmentService
=======
    LoginService, BarberService
>>>>>>> barberProfile
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
