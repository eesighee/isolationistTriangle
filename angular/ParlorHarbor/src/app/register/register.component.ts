import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { $ } from 'protractor';
import { User } from '../types/user.type';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username = "";
  email = "";
  fname = "";
  lname = "";
  password = "";
  confirmPassword = "";
<<<<<<< HEAD
=======
>>>>>>> login3
  usernameMessage = "";
  passwordMessage = "";
  emailMessage = "";

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.loginService.loginSubject.subscribe(u => {
      if (u != null) {
        this.router.navigate(["home"]);
      }
    });
  }

  usernameBlur() {
    if (!this.loginService.usernameAvailable(this.username)) {
      this.usernameMessage = "That username is already taken";
    } else {
      this.usernameMessage = "";
    }
  }

  emailBlur() {
    if (!this.loginService.emailAvailable(this.email)) {
      this.emailMessage = "That email is already taken";
    } else {
      this.emailMessage = "";
    }
  }

  passwordBlur() {
    
    if (!this.passwordValid()) {
      this.passwordMessage = "Your password must be at least 8 characters long and contain at leat 1 upper case, 1 lower case, and 1 number";
    } else if (this.password != this.confirmPassword && this.confirmPassword) {
      this.passwordMessage = "Your passwords do not match";
    } else this.passwordMessage = "";
  }

  passwordValid(): boolean {
    // var passwordRegex = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/
    // if (passwordRegex.test(this.password)) return true;
    // return false;
    return true;
  }

  register() {
    var u = new User();
    u.username = this.username;
    u.email = this.email;
    u.password = this.password;
    u.fname = this.fname;
    u.lname = this.lname;
    if (!(this.passwordMessage || this.usernameMessage || this.emailMessage)) this.loginService.addUser(u);
  }

}
