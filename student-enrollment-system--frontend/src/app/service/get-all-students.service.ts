import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Student} from "../dto/Student";

@Injectable({
  providedIn: 'root'
})
export class GetAllStudentsService {
  constructor() { }

  getStudents(http:HttpClient){
    const options = {
      withCredentials : true
    }
    return http.get<Student[]>("http://localhost:8080/api/v1/students",options);
  }
}
