import { Component } from '@angular/core';
import { Goal } from '../models/Goal';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-add-goal',
  templateUrl: './add-goal.component.html',
  styleUrl: './add-goal.component.css',
  standalone: false,
})
export class AddGoalComponent {
  submitted: boolean = false;
  username: string;

  goal: Goal = {
    name: '',
    amountToSave: '',
    date: '',
    amountSaved: '',
  };

  constructor(private userService: UserService) {
    this.username = this.userService.getUsername(); // get the username
  }

  addGoal(): void {
    const data = {
      name: this.goal.name,
      amountToSave: this.goal.amountToSave,
      date: this.goal.date,
      amountSaved: this.goal.amountSaved
    };

    console.log(data);
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