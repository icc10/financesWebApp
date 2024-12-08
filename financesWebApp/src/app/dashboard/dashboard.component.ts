import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Goal } from '../models/Goal';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
  standalone: false,
})
export class DashboardComponent implements OnInit {
  goals: Goal[] = [];
  username: string;

  constructor(private userService: UserService, private http: HttpClient) {
    this.username = this.userService.getUsername(); // get the username
  }

  ngOnInit(): void {
    this.listGoals();
  }

  listGoals(): void {
    this.http.get<any[]>('http://localhost:8080/goal/list', {
      params: { username: this.username },
      withCredentials: true
    }).subscribe({
      next: (response: any[]) => {
        this.goals = response.map(goal => ({
          name: goal.goalName,
          amountToSave: goal.goalEndingAmount,
          amountSaved: goal.goalStartingAmount,
          username: goal.user
        }));
        console.log('Goals retrieved:', this.goals);
      },
      error: (error) => {
        console.error('Connection error', error);
      }
    });
  }

}