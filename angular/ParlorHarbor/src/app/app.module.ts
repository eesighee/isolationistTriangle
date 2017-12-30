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
import { LocationSearchComponent } from './location-search/location-search.component';
import { SearchService } from './search.service';
import { ShopComponent } from './shop/shop.component';
import { ShopService } from './shop.service';

const routes: Routes = [
  { path: "", redirectTo: "/login", pathMatch: "full"},
  { path: "home", component: HomeComponent },
  { path: "register", component: RegisterComponent },
  { path: "login", component: LoginComponent },
  { path: "search", component: LocationSearchComponent}, 
  { path: "shop", component: ShopComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    LocationSearchComponent,
    ShopComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    LoginService, SearchService, ShopService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
