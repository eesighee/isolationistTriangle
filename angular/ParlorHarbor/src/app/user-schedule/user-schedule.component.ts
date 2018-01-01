import { Component, OnInit } from '@angular/core';
import { BarberService } from '../barber.service';
import { ActivatedRoute } from '@angular/router';
import { Appointment } from '../types/appoinment.type';
import { ScheduleService } from '../schedule.service';
import { Barber } from '../types/user.type';

@Component({
  selector: 'app-user-schedule',
  templateUrl: './user-schedule.component.html',
  styleUrls: ['./user-schedule.component.css']
})
export class UserScheduleComponent implements OnInit {

  private appointments: Appointment[];
  private barber: Barber;

  constructor(private appService: ScheduleService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.appService.getAppointmentsByBarberId(+this.route.snapshot.paramMap.get('id'));
    this.appService.appointments.subscribe(a => {
      this.appointments = a;
      if(a != null){
        this.barber = this.appointments[0].barber;
      }
    });
  }

}
