export class Goal {
    username: string;
    name: string;
    amountToSave: string;
    amountSaved: string;

    constructor(username: string, name: string, amountToSave: string, amountSaved: string, date: string) { // Add date parameter
        this.username = username;
        this.name = name;
        this.amountToSave = amountToSave;
        this.amountSaved = amountSaved;
    }
}