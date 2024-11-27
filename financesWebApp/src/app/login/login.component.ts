import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  standalone: false,
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(private router: Router) {}

  loginForm = new FormGroup({

    username: new FormControl<string|null>(null, [Validators.required, Validators.minLength(0)]),
    password: new FormControl("", [Validators.required, Validators.minLength(0)]),
  })

  public onSubmit() {
    this.username = (document.getElementById("username") as HTMLInputElement).value;
    this.password = (document.getElementById("password") as HTMLInputElement).value;

    if ((this.username != null) && (this.password != null)) {
        //check that they are a user
        //otherwise probably just make them an account

        let successfulLogin = this.signIn(this.username, this.password); //if they are able to log in, reroute them

        if (successfulLogin) {
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

  public signIn(email: string, password: string){
    try {
        //will have to add signing in implementation
        return true;
    } catch (error) {
        return false;
    }
  }


}
