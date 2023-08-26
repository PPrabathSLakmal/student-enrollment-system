import { Component } from '@angular/core';
import {SignupService} from "../../service/signup.service";
import {routes} from "../../app.module";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  constructor(private signupService: SignupService,private router: Router) {
  }

  signup(username: HTMLInputElement, password: HTMLInputElement, fullName: HTMLInputElement) {
    this.signupService.getSignupService(username,password,fullName).subscribe({
      next:(res)=>{
        this.router.navigate([""]);
      }
    })
  }


}
