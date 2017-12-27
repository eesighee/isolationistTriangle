export class User{
    
    id: number;
    username: string;
    email: string;
    password: string;
    fname: string;
    lname: string;

    constructor(values = {}) {
        Object.assign(this, values);
    }
}