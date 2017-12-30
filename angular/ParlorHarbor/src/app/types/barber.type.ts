import { User } from "./user.type";
import { StylingService } from "./Styling-Service.type";

export class Barber {

    user: User;
    rating: number;
    services: Array<StylingService>;

}