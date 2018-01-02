import { Barber } from "./user.type";
import { ServiceType } from "./servicetype.type";

export class StylingService{
    id: number;
    price: number;
    barber: Barber;
    description: String;
    type: ServiceType;
}