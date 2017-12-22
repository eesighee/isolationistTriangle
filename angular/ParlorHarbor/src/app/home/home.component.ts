import { Component, OnInit } from '@angular/core';
import { User } from '../types/user.type';
import { LoginService } from '../login.service';
import * as $ from "jquery";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username: string = "";

  constructor(private login: LoginService) { }

  ngOnInit() {
    this.login.loginSubject.subscribe(u => {
      console.log(u);
      this.username = u.username;
      $("#name").html(this.username);
    });
    
  }

}
