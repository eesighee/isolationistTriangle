import { Barber } from "./user.type";

export class Artwork{
    id: number;
    barber: Barber;
    picturePath: string;

    constructor(values = {}) {
        Object.apply(this, values);
    }
} 