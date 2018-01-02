export class ServiceType {
    id: number;
    type: string;

    constructor(values = {}) {
        Object.apply(this, values);
    }

    public static getType(id: number): ServiceType {
        var result = { "id": id, "type": "" };
        switch (id) {
            case 1:
                result["type"] = "Haircut";
                break;
            case 2:
                result["type"] = "Shave";
                break;
            case 3:
                result["type"] = "Shampoo";
                break;
            case 4:
                result["type"] = "Fade";
                break;
            case 5:
                result["type"] = "Edgeups";
                break;
            case 6:
                result["type"] = "Beard Trim";
                break;
            case 7:
                result["type"] = "Waxing";
                break;
            case 8:
                result["type"] = "Other";
                break;
        }
        return result;
    }


}

