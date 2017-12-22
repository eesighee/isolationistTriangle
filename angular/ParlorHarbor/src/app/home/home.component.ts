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

  private user = new User({username: "bob"});

  constructor(private login: LoginService) { }

  ngOnInit() {
    this.user = this.login.loginSubject.getValue();
    console.log(this.user);
  }

}
