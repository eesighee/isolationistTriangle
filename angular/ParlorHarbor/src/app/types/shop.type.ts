export class Shop{

    id: number;
    name: string;
    latitude: double;
    longitude: double;
    sales: double;
    phone: string;
    website: string;

    constructor(values = {}) {
        Object.assign(this, values);
    }

}