import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './Component/Teacher/home/home.component';
import { ExamComponent } from './Component/Teacher/exam/exam.component';
import { AssigmentComponent } from './Component/Teacher/assigment/assigment.component';
import { Home1Component } from './Component/Admin/home1/home1.component';
import { BatchesComponent } from './Component/Admin/batches/batches.component';
import { Course1Component } from './Component/Admin/course1/course1.component';
import { WelcomeComponent } from './Component/welcome/welcome.component';
import { ApiServiceService } from './api-service.service';

const routes: Routes = [ 
  {path:'',component:WelcomeComponent},
  {path:'home',component:HomeComponent},
  {path:'exam',component:ExamComponent,canActivate: [ApiServiceService]},
  {path:'assigment',component:AssigmentComponent},
  {path:'admin',component:Home1Component,canActivate: [ApiServiceService]},
  {path:'batches',component:BatchesComponent},
  {path:'program',component:Course1Component},
  
 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
