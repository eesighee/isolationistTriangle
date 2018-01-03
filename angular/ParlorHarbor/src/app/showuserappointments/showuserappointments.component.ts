import { Component, OnInit, Input } from '@angular/core';
import { UserService } from '../user.service';
import { LoginService } from '../login.service';
import { User } from '../types/user.type';
import { Appointment } from '../types/appointment.type';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap/modal/modal-ref';

@Component({
  selector: 'app-showuserappointments',
  templateUrl: './showuserappointments.component.html',
  styleUrls: ['./showuserappointments.component.css']
})
export class ShowuserappointmentsComponent implements OnInit {

  private user: User;

  @Input()
  appointments: Appointment[];

  constructor(private userService: UserService, private login: LoginService, private aMdoal: NgbActiveModal) { }

  ngOnInit() {
    this.user = this.login.loginSubject.getValue();
  }

}