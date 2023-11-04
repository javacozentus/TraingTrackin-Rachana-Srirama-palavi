import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './Component/Teacher/navbar/navbar.component';
import { HomeComponent } from './Component/Teacher/home/home.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCheckboxModule} from '@angular/material/checkbox';

import { MatToolbarModule } from '@angular/material/toolbar';

import {MatButtonModule} from '@angular/material/button';

import {MatFormFieldModule} from '@angular/material/form-field';

import {MatIconModule} from '@angular/material/icon';
import { FormsModule } from '@angular/forms';

import {MatMenuModule} from '@angular/material/menu';

import {MatGridListModule} from '@angular/material/grid-list';

import {MatSelectModule} from '@angular/material/select';
import {MatTabsModule} from '@angular/material/tabs';

import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import {MatNativeDateModule} from '@angular/material/core';
import { MatTableModule } from '@angular/material/table';

import { BatchProgramComponent } from './Component/Teacher/batch-program/batch-program.component';
import { AttendanceComponent } from './Component/Teacher/attendance/attendance.component';
import { AssigmentComponent } from './Component/Teacher/assigment/assigment.component';
import { AssignTableComponent } from './Component/Teacher/assign-table/assign-table.component';
import { ExamComponent } from './Component/Teacher/exam/exam.component';
import { ExamTableComponent } from './Component/Teacher/exam-table/exam-table.component';
import { Home1Component } from './Component/Admin/home1/home1.component';

import { TeachersComponent } from './Component/Admin/teachers/teachers.component';
import { StudentsComponent } from './Component/Admin/students/students.component';
import { BatchesComponent } from './Component/Admin/batches/batches.component';
import { BatchtableComponent } from './Component/Admin/batchtable/batchtable.component';
import { Batchtable1Component } from './Component/Admin/batchtable1/batchtable1.component';
import { Batchtable2Component } from './Component/Admin/batchtable2/batchtable2.component';

import {MatPaginatorModule} from '@angular/material/paginator';
import { ProgramsComponent } from './Component/Admin/programs/programs.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthService } from './auth.service';
import { Course1Component } from './Component/Admin/course1/course1.component';
import { WelcomeComponent } from './Component/welcome/welcome.component';



HttpClientModule
AuthService


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    
  
    BatchProgramComponent,
    AttendanceComponent,
    AssigmentComponent,
    AssignTableComponent,
    ExamComponent,
    ExamTableComponent,
    Home1Component,
    TeachersComponent,
    StudentsComponent,
    BatchesComponent,
    BatchtableComponent,
    Batchtable1Component,
    Batchtable2Component,
    ProgramsComponent,
    Course1Component,
    WelcomeComponent,

   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatIconModule,
    MatMenuModule,
    MatGridListModule,MatSelectModule,
    MatTabsModule,
    MatDatepickerModule,
    MatInputModule,
    MatNativeDateModule,
    MatTableModule,
    MatToolbarModule,
    FormsModule,
    MatPaginatorModule,
    MatButtonModule,
    HttpClientModule,
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
