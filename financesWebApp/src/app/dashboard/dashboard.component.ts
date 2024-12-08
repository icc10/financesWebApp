import { Component } from '@angular/core';
import { Goal } from '../models/Goal';
import { RouterModule, Routes } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-dashboard',
  standalone: false,
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  debtAmount = 0;
  goals: Goal[];
  username: string;

  constructor(route: RouterModule, private userService: UserService) {
    this.username = this.userService.getUsername(); // get the username
    console.log(this.username);
    const goal1 = new Goal("Goal1", "100", "February 1, 2024", "0");
    const goal2 = new Goal("Goal2", "200", "March 1, 2024", "50");
    this.goals = [goal1, goal2];
  }
}