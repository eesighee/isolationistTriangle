import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { $ } from 'protractor';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  
  constructor() { }
  usernameMessage = "";
  passwordMessage = "";
  emailMessage = "";

  constructor(private login: LoginService) { }

  ngOnInit() {
    this.login.loginSubject.subscribe(u => {
      if (u == null) {
        //do whateveer as they are logged out
      } else {
        //the are logged in, get their info 
      }
    })
  }

}
