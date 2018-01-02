import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap/modal/modal';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  constructor(private modal: NgbModal) { }

  ngOnInit() {
  }

  login() {
    this.modal.open(LoginComponent);
  }

  register() {
    this.modal.open(RegisterComponent);
  }

}
