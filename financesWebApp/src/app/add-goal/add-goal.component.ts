import { Component } from '@angular/core';

@Component({
  selector: 'app-add-goal',
  standalone: false,

  templateUrl: './add-goal.component.html',
  styleUrl: './add-goal.component.css'
})
export class AddGoalComponent {
  submitted: boolean = false;
}
