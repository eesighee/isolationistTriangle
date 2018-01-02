import { Artwork } from "./atrwork.type";
import { User } from "./user.type";

export class ArtworkComment{
    id: number;
    artwork: Artwork;
    comment: string;
    user: User;

    constructor(values = {}) {
        Object.apply(this, values);
    }
}