import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  //private apiUrl = 'http://localhost:8080'; // Replace with your API URL

  constructor(private http: HttpClient) { }
  
    
}
