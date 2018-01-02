import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap/modal/modal-ref';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
  
export class LoginComponent implements OnInit {

  loginmessage = "";
  username = "";
  password = "";

  constructor(private loginService: LoginService, private router: Router, private amodal: NgbActiveModal) { }


  login() {
    this.loginService.login(this.username, this.password);
  }

  ngOnInit() {
    this.loginService.loginSubject.subscribe(u => {
      if (u == null && this.username && this.password) {
        this.loginmessage = "Login failed! Make sure information was entered correctly";
      } else {
        this.router.navigate(["home"]);
      }
    });
  }

  register() {
    this.router.navigate(["register"]);
  }


}
