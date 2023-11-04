import { HttpClient } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { generate } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }


  public generateTOKEN(loginData:any){
    return this.http.post('http://localhost:8080/token' ,loginData);

  }

public loginUser(token: string){
  localStorage.setItem('token',token);
  return true;
}

// //islogin"user is  logged in or not

// public isLoggedIn(){
//   let tokenstr =localStorage.getItem('token');
//   if(tokenstr ==undefined || tokenstr ==)
// }

  authenticate(username: string, password: string): boolean {
    
    const validUsername = 'admin';
    const validPassword = '1234';
    return username === validUsername && password === validPassword;
  }

  authenticateteacher(username: string, password: string): boolean {
    const validUsername = 'teacher';
    const validPassword = '1234';
    return username === validUsername && password === validPassword;
  }

  storeLoginData(username: string, password: string) {
    sessionStorage.setItem('username', username);
    sessionStorage.setItem('password', password);
    return true;
  }

  storeAddCourse(inputData: any) {
    const finalResult: any[] = [];
    finalResult.push(inputData)
    console.log("servevie", finalResult)

  }

  clearLoginData() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('password');
  }


}
