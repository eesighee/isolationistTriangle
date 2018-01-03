import { Barber } from "./user.type";
import {User} from "./user.type";
import { StylingService } from "./Styling-Service.type";
import {appointmentstatus} from "./appointmentstatus";

export class Appointment{
    id: number;
    customer: User;
    time: any;
    service: StylingService;
    status: appointmentstatus;

    constructor(values = {}) {
        Object.assign(this, values);
    }
}