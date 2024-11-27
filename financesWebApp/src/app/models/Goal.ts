export class Goal {
    name: string;
    amountToSave: string;
    date: string;
    amountSaved: string;

    constructor(name: string, amountToSave: string, date: string, amountSaved: string) {
        this.name = name;
        this.amountToSave = amountToSave;
        this.date = date;
        this.amountSaved = amountSaved;
    }
}
