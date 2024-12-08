import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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
    username: '',
    amountToSave: '',
    amountSaved: '',

  };

  constructor(private userService: UserService, private http: HttpClient) {
    this.username = this.userService.getUsername(); // get the username
  }

  addGoal(): void {
    const data = {
      username: this.username,
      goalName: this.goal.name,
      goalStartingAmount: this.goal.amountSaved,
      goalEndingAmount: this.goal.amountToSave
    };

    this.http.post('http://localhost:8080/goal/create', null, {
      params: data,
      responseType: 'text',
      withCredentials: true // ensure credentials are sent
    }).subscribe({
      next: (response: string) => {
        console.log('Backend response:', response);
        this.submitted = true;
      },
      error: (error) => {
        console.error('Connection error', error);
      }
    });
  }

  newGoal(): void {
    this.goal.name = '';
    this.goal.amountToSave = '';
    this.goal.amountSaved = '';

    console.log(this.goal);

    this.submitted = false;
  }
}