import { Component } from '@angular/core';
import { Goal } from '../models/Goal';

@Component({
  selector: 'app-add-goal',
  standalone: false,

  templateUrl: './add-goal.component.html',
  styleUrl: './add-goal.component.css'
})
export class AddGoalComponent {
  submitted: boolean = false;

  goal: Goal = {
    name: '',
    amountToSave: '',
    date: '',
    amountSaved: '',
  };

  newGoal(): void {
    const data = {
      name: this.goal.name,
      amountToSave: this.goal.amountToSave,
      date: this.goal.date,
      amountSaved: this.goal.amountSaved
    };

    console.log(data);
  }
}
