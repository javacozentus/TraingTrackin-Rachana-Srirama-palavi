import { Component, ElementRef, OnInit, Renderer2 } from '@angular/core';

import { DomSanitizer } from '@angular/platform-browser';

import { MatIconRegistry } from '@angular/material/icon';

import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { ApiServiceService } from 'src/app/api-service.service';

const check_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M438.6 105.4c12.5 12.5 12.5 32.8 0 45.3l-256 256c-12.5 12.5-32.8 12.5-45.3 0l-128-128c-12.5-12.5-12.5-32.8 0-45.3s32.8-12.5 45.3 0L160 338.7 393.4 105.4c12.5-12.5 32.8-12.5 45.3 0z"/></svg>`;

const wrong_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License)
 Copyright 2023 Fonticons, Inc. --><path d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z"/></svg>`;

const Del_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M135.2 17.7L128 32H32C14.3 32 0 46.3 0 64S14.3 96 32 96H416c17.7 0 32-14.3 32-32s-14.3-32-32-32H320l-7.2-14.3C307.4 6.8 296.3 0 284.2 0H163.8c-12.1 0-23.2 6.8-28.6 17.7zM416 128H32L53.2 467c1.6 25.3 22.6 45 47.9 45H346.9c25.3 0 46.3-19.7 47.9-45L416 128z"/></svg>`;

const Edit_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M410.3 231l11.3-11.3-33.9-33.9-62.1-62.1L291.7 89.8l-11.3 11.3-22.6 22.6L58.6 322.9c-10.4 10.4-18 23.3-22.2 37.4L1 480.7c-2.5 8.4-.2 17.5 6.1 23.7s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L387.7 253.7 410.3 231zM160 399.4l-9.1 22.7c-4 3.1-8.5 5.4-13.3 6.9L59.4 452l23-78.1c1.4-4.9 3.8-9.4 6.9-13.3l22.7-9.1v32c0 8.8 7.2 16 16 16h32zM362.7 18.7L348.3 33.2 325.7 55.8 314.3 67.1l33.9 33.9 62.1 62.1 33.9 33.9 11.3-11.3 22.6-22.6 14.5-14.5c25-25 25-65.5 0-90.5L453.3 18.7c-25-25-65.5-25-90.5 0zm-47.4 168l-144 144c-6.2 6.2-16.4 6.2-22.6 0s-6.2-16.4 0-22.6l144-144c6.2-6.2 16.4-6.2 22.6 0s6.2 16.4 0 22.6z"/></svg>`;

@Component({
  selector: 'app-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css'],
})
export class TeachersComponent {
  apiservice: any;
  selectedItems: string[] = [];

  selectedValuesString: any;
  // teacherApi: any;
  teacherApi: any = [];

  ngOnInit(): void {}

  // Dropdown options
  dropdownOptions: string[] = [];
  selectedDropdownValue: string = ''; // Holds the selected value from the dropdown

  isFormVisible: boolean = false;
  isForm2Visible: boolean = false;

  // Input field values
  field1Value: string = '';
  field2Value: string = '';

  // Array to store table data
  tableData: any[] = [];
  inputData: any = {
    teachername: '',
    teacheremail: '',
    coursename: '',
  };

  isdata_deleted: boolean = false;
  index: number = 0;
  people: any[] = JSON.parse(
    localStorage.getItem('add_teacher_details') || '[]'
  );
  data_length: string = JSON.parse(
    localStorage.getItem('add_teacher_details') || '[]'
  ).length;
  constructor(
    iconRegistry: MatIconRegistry,
    private rout: Router,
    private el: ElementRef,
    private renderer: Renderer2,
    private apiobj: ApiServiceService,
    private sanitizer: DomSanitizer
  ) {
    iconRegistry.addSvgIconLiteral(
      'Check-up',
      sanitizer.bypassSecurityTrustHtml(check_Icon)
    );
    iconRegistry.addSvgIconLiteral(
      'Wrong-up',
      sanitizer.bypassSecurityTrustHtml(wrong_Icon)
    );
    iconRegistry.addSvgIconLiteral(
      'Del-up',
      sanitizer.bypassSecurityTrustHtml(Del_Icon)
    );
    iconRegistry.addSvgIconLiteral(
      'Edit-up',
      sanitizer.bypassSecurityTrustHtml(Edit_Icon)
    );

    this.getallCourseName();
  }

  isDisabled: boolean = false;

  // Toggle form visibility
  toggleForm() {
 
    this.field1Value='';
    this.field2Value='';

    this.isFormVisible = true;
    this.var1 = false;
    this.var2 = false;
    this.isForm2Visible = false;
    this.getallCourseName();

    this.apiobj.getData().subscribe((res: any) => {
      console.log(res[0].coursename);
      // this.courseNameApi=res;
      for (let index = 0; index < res.length; index++) {
        this.dropdownOptions[index] = res[index].coursename;
      }

      for (let index = 0; index < this.dropdownOptions.length; index++) {
        this.items.push({
          value: this.dropdownOptions[index],
          selected: false,
        });
      }
    });
  

    console.log(this.dropdownOptions);
    console.log(this.items);

  }

  toggleForm1() {
    this.isFormVisible = false;
    this.var2 = true;
    this.isForm2Visible = true;
    // this.getallCourseName();
  }
  toggleForm2() {
    this.isFormVisible = true;
    this.var2 = true;
    this.isForm2Visible = true;
  }
  // Reset input fields
  resetFields() {
  
    this.field1Value = '';
    this.selectedDropdownValue = '';
    this.field2Value = '';
  }
  courseList: string[] = [];
  teacheridobject = {
    teacherid: '',
  };
  refreshMethod() {
    this.field1Value = '';
    // this.submitTableData();
    this.getallCourseName();
    this.toggleForm1();
    // this.apiobj.getData().subscribe((res: any) => {
    //   console.log(res[0].coursename);
    //   // this.courseNameApi=res;
    //   for (let index = 0; index < res.length; index++) {
    //     this.dropdownOptions[index] = res[index].coursename;
    //   }

    //   for (let index = 0; index < this.dropdownOptions.length; index++) {
    //     this.items.push({
    //       value: this.dropdownOptions[index],
    //       selected: false,
    //     });
    //   }
    // });
  }
  submitTableData() {
    const selectedItems = this.items.filter((item) => item.selected === true);
    const selectedValues = selectedItems.map((item) => item.value);
    const selectedValuesString = selectedValues.join(',');
    this.inputData.coursename = selectedValuesString;
    // this.isDisabled = true;

    this.inputData.teachername = this.field1Value;
    // this.inputData.teachername = this.selectedValuesString;
    this.inputData.teacheremail = this.field2Value;
    console.log(selectedValuesString)
  

    if (this.field1Value != '' && this.field2Value != '') {
      this.apiobj.addTeacher(this.inputData).subscribe((res) => {
        console.log('successfully added...');

        console.log(this.inputData)
      });
      Swal.fire({
        html: `
      <div>
        <h2>Teacher Added</h2>
        <hr style="margin: 10px 0;>
        <p">An email has been sent to ${this.inputData.teachername} with email id and password</p>
      </div>
    `,
        showCancelButton: false,
        confirmButtonColor: 'primary',
        confirmButtonText: 'Ok',
      });
    }
    // this.getallCourseName();
    console.log(this.courseList);
    this.apiobj.getAllTeacher().subscribe((res) => {
      this.teacherApi = res;
    });

    
    this.getallCourseName();
  
  }

  showList() {
    this.people = JSON.parse(
      localStorage.getItem('add_teacher_details') || '[]'
    );
  }

  deleteItem(row: any) {
    Swal.fire({
      html: `
        <div>
          <h2>Delete Teacher Detail</h2>
          <hr style="margin: 10px 0;>
          <p">Are you sure that you want to delete this Teacher Detail?</p>
        </div>
      `,
      showCancelButton: true,
      confirmButtonColor: 'primary',
      cancelButtonColor: 'basic',
      confirmButtonText: 'Yes',
      cancelButtonText: 'No',
    }).then((result) => {
      
    });

    const index = this.teacherApi.indexOf(row);
    const deletedId = this.teacherApi[index].teacherid;
    // console.log(deletedId)
    // console.log(this.courseApi[index])
    if (index !== -1) {
      this.teacherApi.splice(index, 1);
      // console.log('Deleted:', row);
      this.apiobj.deleteTeacherdata(deletedId).subscribe(
        (res) => {
          console.log('successfully deleted...');
        },
        (err) => {
          console.log(err);
        }
      );
    }
  }
  // obj = {

  //   TeacherName:'',
  //   CourseAssigned   :'',
  //   EmailID:'',

  //  }
  getallCourseName() {
    this.apiobj.getAllTeacher().subscribe((res) => {
      this.teacherApi = res;
    });

    for (let index = 0; index < this.teacherApi.length; index++) {
      const teacherid = this.teacherApi[index].teacherid;
      this.teacheridobject.teacherid = teacherid;

      this.apiobj
        .getAllCoursesByTeacherId(this.teacheridobject)
        .subscribe((res: any) => {
          this.courseList.push(res);
        });
    }
    console.log('this is my course list');
    console.log(this.courseList);
  }

  updatedTeacherobject = {
    teacherid: 0,
    teachername: '',
    coursename: '',
    teacheremail: '',
  };
  selectedItemsString = this.selectedItems.join(',');

  editItem(row: any) {
    this.getallCourseName();
    console.log(this.courseList);
    this.isForm2Visible = true;
    this.isFormVisible = true;

    const index = this.teacherApi.indexOf(row);
    this.isDisabled = !this.isDisabled;
    console.log(index);
    // console.log(this.entries[index].code)

    if (!this.isDisabled) {
      this.field1Value = row.teachername;
      this.field2Value = row.teacheremail;
    }
    if (this.isDisabled) {
      this.teacherApi[index].teachername = this.field1Value;
      this.teacherApi[index].teacheremail = this.field2Value;

      this.updatedTeacherobject.teachername =
        this.teacherApi[index].teachername;
      this.updatedTeacherobject.teacherid = this.teacherApi[index].teacherid;
      this.updatedTeacherobject.teacheremail =
        this.teacherApi[index].teacheremail;
      this.updatedTeacherobject.coursename = this.selectedItemsString + ',';
      console.log(this.selectedItemsString);
      console.log(this.selectedItems);

      this.apiobj
        .updateTeacherData(this.updatedTeacherobject)
        .subscribe((res) => {
          console.log(res);
        });

      this.isFormVisible = false;
    }
  }

  var1 = true;
  var2 = true;

  items = [
    { value: '', selected: false },
    // { value: '', selected: false },
    // { value: '', selected: false }
  ];

  handleCheckboxChange() {
    this.selectedItems = this.items
      .filter((item) => item.selected)
      .map((item) => item.value);
    this.selectedItemsString = this.selectedItems.join(',');
  }
}
