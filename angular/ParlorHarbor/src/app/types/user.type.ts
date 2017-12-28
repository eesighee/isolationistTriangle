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

export interface Role{
    id: number;
    role: string;
}

export const roles = {
    user: { id: 1, role: "User" },
    barber: {id: 2, role: "Barber"}
}