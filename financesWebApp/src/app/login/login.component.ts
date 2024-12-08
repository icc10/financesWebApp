import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  standalone: false,
})
export class LoginComponent {
  username = '';
  password = '';
  constructor(private router: Router, private http: HttpClient, private userService: UserService) { }

  loginForm = new FormGroup({
    username: new FormControl<string | null>(null, [Validators.required, Validators.minLength(0)]),
    password: new FormControl("", [Validators.required, Validators.minLength(0)]),
  })

  public onSubmit() {
    this.username = (document.getElementById("username") as HTMLInputElement).value;
    this.password = (document.getElementById("password") as HTMLInputElement).value;

    if ((this.username != null) && (this.password != null)) {
      let successfulLogin = this.signIn(this.username, this.password);

      if (successfulLogin) {
        this.userService.setUsername(this.username); // store the username
        this.router.navigate(['/dashboard']);
      }
      else {
        console.log("Login Failed")
      }
    }
    else {
      console.log("Field is blank that should not be")
    }
  }

  public signIn(username: string, password: string) {
    try {
      this.http.post('http://localhost:8080/auth/login', null, {
        params: {
          username: username,
          password: password
        },
        responseType: 'text',
        withCredentials: true // Ensure credentials are sent
      }).subscribe({
        next: (response: string) => {
          console.log('Backend response:', response);
        },
        error: (error) => {
          console.error('Connection error', error);
        }
      });
      return true;
    } catch (error) {
      return false;
    }
  }
}