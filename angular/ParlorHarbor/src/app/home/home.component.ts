import { Component, OnInit } from '@angular/core';
import { User } from '../types/user.type';
import { LoginService } from '../login.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap/modal/modal';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  private user: User;

  constructor(private login: LoginService, private modal: NgbModal) { }

  ngOnInit() {
    this.user = this.login.loginSubject.getValue();
  }

  logout() {
    this.login.logout();
  }



}
