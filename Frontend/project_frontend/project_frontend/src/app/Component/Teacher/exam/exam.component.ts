import { Component, OnInit, ViewChild, ViewContainerRef } from '@angular/core';

import { ExamTableComponent } from '../exam-table/exam-table.component';
import { ApiServiceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-exam',

  templateUrl: './exam.component.html',

  styleUrls: ['./exam.component.css'],
})
export class ExamComponent {
  entries: any;

  dropdownOptionsarray: any[] = [];

  dates: Date[] = [];

  courseOptions: any[] = [];

  programOptions: any[] = [];

  dropdownOptions: { code: string; name: string }[] = [];
  selectedOption: string = '';
  programcode: any;

  constructor(private apiobj: ApiServiceService) {
    const storedEntries = localStorage.getItem('entries');
    if (storedEntries) {
      this.entries = JSON.parse(storedEntries);
    }

    this.getAllBatchCodeAndBatchName();

    console.log(this.dropdownOptions);
    console.log(this.dates);
    console.log(this.programOptions);
    console.log(this.dropdownOptionsarray);
    console.log(this.courseOptions);
    //console.log(this.getCoursecodebycoursename);
  }

  batchcode: string[] = [];

  batchname: string[] = [];

  batchStartDates: String[] = [];

  //getAllBatchCodeAndBatchName
  getAllBatchCodeAndBatchName() {
    this.apiobj.getAllBatchCodeAndBatchName().subscribe(
      (data) => {
        this.dropdownOptions = data.map((item) => {
          return { code: item, name: item };
        });
      },
      (error) => {
        console.error('Error fetching batch codes and names:', error);
      }
    );
  }

  handleDropdownChange(event: Event) {
    const selectedValue = (event.target as HTMLSelectElement).value;
    console.log('Selected Value:', selectedValue);
    this.selectedOption = selectedValue; // Update the selected option
  }

  form1 = true;
  form2 = false;
  form3 = false;
  form4 = false;
  form5 = false;

  clicked = '';
  selectedStartDate = '';
  selectedprogramcode = '';
  selectedBatchCode = '';
  selectedcoursecode = '';

  Click(value: string): void {
    this.programOptions.splice(0, this.programOptions.length);
    this.courseOptions.splice(0, this.courseOptions.length);
    this.clicked = value;
    this.selectedBatchCode = this.clicked.split('-')[0];
    console.log(this.selectedBatchCode);

    this.form2 = true;
    this.apiobj
      .getBatchStartDateBybatchcode(this.selectedBatchCode)
      .subscribe((data) => {
        this.batchStartDates.push(data);
        this.form3 = true;
        this.apiobj
          .getProgramInfoBybatchname(this.selectedBatchCode)
          .subscribe((data) => {
            this.programOptions.push(data);
            // console.log(data)
            console.log(this.programOptions);

            this.form4 = true;
          });

        this.selectedStartDate = data;
        console.log(this.selectedStartDate);
      });
    // console.log(this.batchStartDates)
  }

  Click1(value: string): void {
    this.clicked = value;

    this.form2 = true;

    this.form3 = true;
  }

  Click2(value: string): void {
    this.clicked = value;

    this.form2 = true;

    this.form3 = true;

    this.form4 = true;

    this.apiobj
      .getCoursecodebycoursename1(this.programOptions[0][0][0])
      .subscribe((data) => {
        this.courseOptions.push(data);
        console.log(this.programOptions[0][0][0]);
        console.log('Program Data:-', data);
        //console.log(this.courseOptions)
        //console.log(this.selectedProgramCode);
        console.log(data);
        this.programcode = this.programOptions[0][0][0];
        console.log('Program Data 1:-', this.programcode);
        localStorage.setItem('program_code', this.programcode);
      });
    return this.programcode;
  }

  getprogramcode(): string {
    return this.programcode;
  }

  Click3(value: string): void {
    this.clicked = value;

    this.form2 = true;

    this.form3 = true;

    this.form4 = true;

    this.form5 = true;
  }

  @ViewChild('container4', { read: ViewContainerRef, static: true })
  container4!: ViewContainerRef;

  AddTopic() {
    this.container4.clear();

    this.container4.createComponent(ExamTableComponent);
  }
}
function Click3(value: any, string: any) {
  throw new Error('Function not implemented.');
}
