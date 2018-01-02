import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { LoginService } from '../login.service';
import {User} from '../types/user.type';
import {Appointment} from '../types/appointments';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap/modal/modal-ref';

@Component({
  selector: 'app-showuserappointments',
  templateUrl: './showuserappointments.component.html',
  styleUrls: ['./showuserappointments.component.css']
})
export class ShowuserappointmentsComponent implements OnInit {

  private user: User;

  appointments: Appointment[];

  constructor(private userService: UserService, private login: LoginService, private aMdoal: NgbActiveModal) { }

  ngOnInit() {
    this.user = this.login.loginSubject.getValue();
    this.userService.getAppointments(this.user.id);
    this.userService.appoint.subscribe(a =>{
          this.appointments = a;

    });
  }

}
