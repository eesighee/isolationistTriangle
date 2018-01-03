import { User, Barber } from "./user.type";
import { StylingService } from "./Styling-Service.type";

export class Appointment {

    id: number;
    customer: User; 
    barber: Barber; 
    time: string;
    stylingService: StylingService; 
    status: AppointmentStatus;

}

export class AppointmentStatus {
    id: number;
    status: string;
}