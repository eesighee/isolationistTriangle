export class User{
    
    id: number;
    fname: string;
    lname: string;

    constructor(values = {}) {
        Object.assign(this, values);
    }
}