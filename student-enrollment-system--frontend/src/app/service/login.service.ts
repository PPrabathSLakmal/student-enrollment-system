import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {User} from "../dto/User";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseUrl:string = "http://localhost:8080/api/v1/auth/";

  constructor(private http:HttpClient) { }
  verifyLogin(username: HTMLInputElement, password: HTMLInputElement){
    const user:User= new User(username.value.trim(), password.value.trim(),"");

    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', 'Basic ' + btoa(username.value + ":" + password.value));
    const options = {
      headers: headers,
      withCredentials: true
    };
    console.log(user)
    return this.http.post(`${this.baseUrl}login`, user, options);
  }

}
