import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router'


import { AppComponent } from './app.component';
import { LoginService } from './login.service';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
<<<<<<< HEAD
import { BarberComponent } from './barber/barber.component';
=======
>>>>>>> login3

const routes: Routes = [
  { path: "", redirectTo: "/login", pathMatch: "full"},
  { path: "home", component: HomeComponent },
  { path: "register", component: RegisterComponent },
  { path: "login", component: LoginComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
<<<<<<< HEAD
    BarberComponent
=======
>>>>>>> login3
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    LoginService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
