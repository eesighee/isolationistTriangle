import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../types/user.type';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { SuiModalService, TemplateModalConfig, ModalTemplate } from 'ng2-semantic-ui';
import { UserService } from '../user.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap/modal/modal';
import { ShowuserappointmentsComponent } from '../showuserappointments/showuserappointments.component';

export interface IContext {
  data: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {

  private user: User;

  constructor(private login: LoginService, private router: Router, private modal: NgbModal, private userService: UserService) { }

  ngOnInit() {
    this.user = this.login.loginSubject.getValue();
  }

  logout() {
    this.login.logout();
  }

  appointments() {
    //console.log('check');
    this.userService.getAppointments(this.user.id).subscribe(apts => {
      console.log(apts);
      if (apts.length > 0) {
        var modal = this.modal.open(ShowuserappointmentsComponent);
        modal.componentInstance.appointments = apts;
      } else {
        alert("You have no appointments.");
      }
    });
    
    

  }



}