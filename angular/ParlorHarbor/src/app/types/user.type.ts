import { Store } from "./store.type";

export class User{
    
    id: number;
    username: string;
    email: string;
    password: string;
    fname: string;
    lname: string;
    role: Role;

    constructor(values = {}) {
        Object.assign(this, values);
    }
}

export class Barber extends User{
    website: string;
    shop: Shop;

    constructor(values = {}) {
        super(values);
        Object.assign(this, values);
    }
}

export class Role{
    id: number;
    role: string;

    static user() {
        return new Role({ id: 1, role: "User" });
    }

    static barber() {
        return new Role({ id: 2, role: "Barber" });
    }

    static admin() {
        return new Role({ id: 3, role: "Admin" });
    }

    constructor(values = {}) {
        Object.assign(this, values);
    }
}