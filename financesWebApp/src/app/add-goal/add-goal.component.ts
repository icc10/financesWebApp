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

  addGoal(): void {
    const data = {
      name: this.goal.name,
      amountToSave: this.goal.amountToSave,
      date: this.goal.date,
      amountSaved: this.goal.amountSaved
    };

    console.log(data);
    this.submitted = true;
  }

  newGoal(): void {
    this.goal.name = '';
    this.goal.amountToSave = '';
    this.goal.date = '';
    this.goal.amountSaved = '';

    console.log(this.goal);
    this.submitted = false;
  }
}
