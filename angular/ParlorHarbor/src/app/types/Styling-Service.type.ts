import { Barber } from "./user.type";

export class StylingService{
    id: number;
    description: string;
    price: number; 
    barber: Barber;
    type: StylingServiceType;    
}

export class StylingServiceType{
    id: number;
    type: string;

    constructor(values = {}) {
        Object.assign(this, values);
    }
}