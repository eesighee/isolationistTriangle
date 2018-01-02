export class Shop{

    id: number;
    address;
    hoursOfOperation;
    name: string;
    latitude: number;
    longitude: number;
    phone: string;
    website: string;

    constructor(values = {}) {
        Object.assign(this, values);
    }

}