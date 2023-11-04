import { Component, OnInit } from '@angular/core';
// import { Component } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Route, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
ApiServiceService

import { Observable } from 'rxjs';
import { ApiServiceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent  {
  constructor(private rout:Router , private serviceobj:ApiServiceService){}

  username:string="";
  password:string="";
  logindata={
  username:'',
  password:'',
  }
onSubmit(){
    this.logindata.username=this.username;
    this.logindata.password=this.password;


    console.log(this.logindata.username)
    console.log(this.logindata.password)
    
   this.serviceobj.generateToken(this.logindata).subscribe((res:any)=>{
    console.log("success");
    console.log(res);
    
    this.serviceobj.loginUser(res.token);

    this.serviceobj.getCurrentUser().subscribe((res:any)=>{
            this.serviceobj.setUserDetails(res);
            console.log(res)

            if(this.serviceobj.getUserrole()=="ROLE_TEACHER"){
              this.rout.navigate(['/exam']);
              
            }
            else if(this.serviceobj.getUserrole()=="ROLE_ADMIN"){
               
              this.rout.navigate(['/admin']);

          
              }
            else{
              this.serviceobj.isLogout();
            }
    })
   },(err)=>{
    console.log("Invalid user name and password");
    console.log(err);
   })
  }

}
