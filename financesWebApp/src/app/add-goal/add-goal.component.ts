import { Component } from '@angular/core';
import { Goal } from '../models/Goal';
//import { GoalsService } from '../services/goals.service';

@Component({
  selector: 'app-add-goal',
  templateUrl: './add-goal.component.html',
  styleUrl: './add-goal.component.css',
  standalone: false,
})
export class AddGoalComponent {
  submitted: boolean = false;


  goal: Goal = {
    name: '',
    amountToSave: '',
    date: '',
    amountSaved: '',
  };

  constructor(/*private goalsService: GoalsService*/) {}


  addGoal(): void {
    const data = {
      name: this.goal.name,
      amountToSave: this.goal.amountToSave,
      date: this.goal.date,
      amountSaved: this.goal.amountSaved
    };

    console.log(data);
//     this.goalsService.create(data).
//     subscribe({
//       next: (res:any) => {
//         console.log('success', res);
//         this.submitted = true;
//       },
//       error: (e:any) => console.error('fail', e)
//     });

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
