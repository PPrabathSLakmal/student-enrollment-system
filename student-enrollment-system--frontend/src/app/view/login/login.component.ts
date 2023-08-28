import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {LoginService} from "../../service/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor(private http: HttpClient, private loginService:LoginService, private router:Router) {
  }

  login(username: HTMLInputElement, password: HTMLInputElement) {
    this.loginService.verifyLogin(username,password).subscribe({
      next:(res)=>{
        alert(`Welcome ${username.value}`);
        this.router.navigate(["home"]);
      },
      error:(err)=>{
        alert(err?.error.message);
      }
    });
  }
}
