import { Barber } from "./user.type";

export class barberReview{
    id: number;
    barber: Barber;
    rating: number;
    comment: string;

    constructor(values = {}) {
        Object.assign(this, values);
    }
}