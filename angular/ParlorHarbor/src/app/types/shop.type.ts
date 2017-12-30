export class Shop{

    id: number;
    name: string;
    latitude: number;
    longitude: number;
    sales: number;
    phone: string;
    website: string;

    constructor(values = {}) {
        Object.assign(this, values);
    }

}