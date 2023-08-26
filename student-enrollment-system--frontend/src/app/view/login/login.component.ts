import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {LoginService} from "../../service/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor(private http: HttpClient, private loginService:LoginService) {
  }

  login(username: HTMLInputElement, password: HTMLInputElement) {
    this.loginService.verifyLogin(username,password).subscribe({
      next:(res)=>{
        alert(`Welcome ${username.value}`);
      },
      error:(err)=>{
        alert(err?.error.message);
      }
    });
  }
}
