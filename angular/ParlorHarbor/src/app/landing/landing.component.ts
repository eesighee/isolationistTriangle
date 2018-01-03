import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap/modal/modal';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  constructor(private modal: NgbModal, private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    if (this.loginService.loginSubject.getValue()) this.router.navigate(["home"]);
  }

  login() {
    this.modal.open(LoginComponent);
  }

  register() {
    this.modal.open(RegisterComponent);
  }

}
