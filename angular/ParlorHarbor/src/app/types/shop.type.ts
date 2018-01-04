export class Shop{

    id: number;
    address;
    openingTime: string;
    closingTime: string;
    name: string;
    latitude: number;
    longitude: number;
    phone: string;
    website: string;

    constructor(values = {}) {
        Object.assign(this, values);
    }

}