import { Component } from '@angular/core';
import { Goal } from '../models/Goal';
import { RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  standalone: false,

  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  debtAmount = 0;
  goals: Goal[];
  constructor(route: RouterModule) {
    // Initialize goals in the constructor
    const goal1 = new Goal("Goal1", "100", "February 1, 2024", "0");
    const goal2 = new Goal("Goal2", "200", "March 1, 2024", "50");
    this.goals = [goal1, goal2]; // Assign the array to the class property

  }
}
