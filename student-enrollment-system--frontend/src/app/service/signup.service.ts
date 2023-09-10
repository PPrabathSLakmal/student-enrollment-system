import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../dto/User";

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(public http:HttpClient) { }
  getSignupService(username: HTMLInputElement, password: HTMLInputElement,fullName:HTMLInputElement){
    const options = {
      withCredentials : true
    }
    return this.http.post("http://localhost:8080/api/v1/auth/signup",new User(username.value.trim(),password.value.trim(),fullName.value.trim()),options);
  }
}
