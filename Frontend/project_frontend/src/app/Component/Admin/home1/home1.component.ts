import { Component, OnInit, ViewChild, ViewContainerRef } from '@angular/core';

// import { InputComponent } from '../input/input.component';

import { BatchesComponent } from '../batches/batches.component';

import { Router } from '@angular/router';

import { StudentsComponent } from '../students/students.component';

import { TeachersComponent } from '../teachers/teachers.component';
import { ProgramsComponent } from '../programs/programs.component';
import { Course1Component } from '../course1/course1.component';
//import { CourseComponent } from '../course/course.component';

@Component({
  selector: 'app-home1',
  templateUrl: './home1.component.html',
  styleUrls: ['./home1.component.css'],
})
export class Home1Component {
  constructor(private rout: Router) {}

  title = 'course-page';

  @ViewChild('container1', { read: ViewContainerRef, static: true })
  container1!: ViewContainerRef;

  @ViewChild('container2', { read: ViewContainerRef, static: true })
  container2!: ViewContainerRef;

  @ViewChild('container5', { read: ViewContainerRef, static: true })
  container5!: ViewContainerRef;

  @ViewChild('container6', { read: ViewContainerRef, static: true })
  container6!: ViewContainerRef;

  @ViewChild('container7', { read: ViewContainerRef, static: true })
  container7!: ViewContainerRef;

  onAddTopic() {
    this.container1.clear();

    // this.container1.createComponent(InputComponent)
  }

  content = true;

  batch() {
    this.container2.clear();

    this.container5.clear();

    this.container6.clear();

    this.container7.clear();

    this.container2.createComponent(BatchesComponent);
  }

  oncourse() {
    this.container2.clear();

    this.container5.clear();

    this.container6.clear();

    this.container7.clear();

    this.container6.createComponent(Course1Component);

    console.log('hii i am running');
  }

  onTeacher() {
    this.container2.clear();

    this.container5.clear();

    this.container6.clear();

    this.container7.clear();

    this.container5.createComponent(TeachersComponent);
  }

  onStudent() {
    this.container2.clear();

    this.container5.clear();

    this.container6.clear();

    this.container7.clear();

    this.container5.createComponent(StudentsComponent);
  }

  onProgram() {
    this.container2.clear();

    this.container5.clear();

    this.container6.clear();

    this.container7.clear();

    this.container7.createComponent(ProgramsComponent);
  }
}
