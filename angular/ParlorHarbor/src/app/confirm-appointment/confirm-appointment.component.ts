import { Component, OnInit, Input  } from '@angular/core';
import { BarberService } from '../barber.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap/modal/modal-ref';
import { Appointment } from '../types/appointment.type';



@Component({
  selector: 'app-confirm-appointment',
  templateUrl: './confirm-appointment.component.html',
  styleUrls: ['./confirm-appointment.component.css']
})
export class ConfirmAppointmentComponent implements OnInit {

  constructor(private barb: BarberService, private modal: NgbActiveModal) { }
  @Input()
  appointment: Appointment;

  ngOnInit() {
     // this.appointment = this.barb.subAppoint.getValue();
      console.log('appointment confirmation: ' + this.appointment);
  }

}
