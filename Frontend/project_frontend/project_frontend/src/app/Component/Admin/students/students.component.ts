import { Component, OnInit } from '@angular/core';
 
import { DomSanitizer } from '@angular/platform-browser';
 
import { MatIconRegistry } from '@angular/material/icon';
 
import Swal from 'sweetalert2';
import { ApiServiceService } from 'src/app/api-service.service';
import { MatTableDataSource } from '@angular/material/table';
 
const check_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M438.6 105.4c12.5 12.5 12.5 32.8 0 45.3l-256 256c-12.5 12.5-32.8 12.5-45.3 0l-128-128c-12.5-12.5-12.5-32.8 0-45.3s32.8-12.5 45.3 0L160 338.7 393.4 105.4c12.5-12.5 32.8-12.5 45.3 0z"/></svg>`
 
 
 
const wrong_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License)
 
 Copyright 2023 Fonticons, Inc. --><path d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z"/></svg>`
 
 
 
 const Del_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M135.2 17.7L128 32H32C14.3 32 0 46.3 0 64S14.3 96 32 96H416c17.7 0 32-14.3 32-32s-14.3-32-32-32H320l-7.2-14.3C307.4 6.8 296.3 0 284.2 0H163.8c-12.1 0-23.2 6.8-28.6 17.7zM416 128H32L53.2 467c1.6 25.3 22.6 45 47.9 45H346.9c25.3 0 46.3-19.7 47.9-45L416 128z"/></svg>`
 
 
 
 const Edit_Icon =`<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M410.3 231l11.3-11.3-33.9-33.9-62.1-62.1L291.7 89.8l-11.3 11.3-22.6 22.6L58.6 322.9c-10.4 10.4-18 23.3-22.2 37.4L1 480.7c-2.5 8.4-.2 17.5 6.1 23.7s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L387.7 253.7 410.3 231zM160 399.4l-9.1 22.7c-4 3.1-8.5 5.4-13.3 6.9L59.4 452l23-78.1c1.4-4.9 3.8-9.4 6.9-13.3l22.7-9.1v32c0 8.8 7.2 16 16 16h32zM362.7 18.7L348.3 33.2 325.7 55.8 314.3 67.1l33.9 33.9 62.1 62.1 33.9 33.9 11.3-11.3 22.6-22.6 14.5-14.5c25-25 25-65.5 0-90.5L453.3 18.7c-25-25-65.5-25-90.5 0zm-47.4 168l-144 144c-6.2 6.2-16.4 6.2-22.6 0s-6.2-16.4 0-22.6l144-144c6.2-6.2 16.4-6.2 22.6 0s6.2 16.4 0 22.6z"/></svg>`
 
@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent  {
  studenttable: boolean | undefined;
  studentApi: any;
  entries: any;
 
  ngOnInit(): void {
  }
 
 
  isFormVisible: boolean = false;
  isForm2Visible: boolean = false;
 
  // Input field values
  field1Value: string = '';
  field2Value: string = '';
  field3Value: string = '';
 
  // Array to store table data
   tableData: any[] = [];
   inputData: any = {
    studentCode: "",
    studentName: "",
    studentEmail: ""  
  };
 
  studentCode:string = '';
 studentName:string = '';
 studentEmail:string = '';
 
 
 obj = {
    studentCode: '',
    studentName: '',
    studentEmail: '',
 
 };
 
 
 
  displayedColumns: string[] = [
    'Actions',
    'studentCode',
    'studentName',
    'studentEmail',
   
  ];
 
  //dataSource = new MatTableDataSource(this.ELEMENT_DATAA);
 
 
 
 
  isdata_deleted: boolean = false;
  index: number = 0;
  people: any[] = JSON.parse(localStorage.getItem("add_student_details")||'[]');
  data_length: string = JSON.parse(localStorage.getItem("add_student_details")||'[]').length;
  constructor(iconRegistry: MatIconRegistry,
    sanitizer: DomSanitizer,private apiobj: ApiServiceService ) {
      iconRegistry.addSvgIconLiteral('Check-up', sanitizer.bypassSecurityTrustHtml(check_Icon));
      iconRegistry.addSvgIconLiteral('Wrong-up', sanitizer.bypassSecurityTrustHtml(wrong_Icon));
      iconRegistry.addSvgIconLiteral('Del-up', sanitizer.bypassSecurityTrustHtml(Del_Icon));
      iconRegistry.addSvgIconLiteral('Edit-up', sanitizer.bypassSecurityTrustHtml(Edit_Icon));
     }
 
  // Toggle form visibility
  toggleForm() {
    this.isFormVisible = true;
    this.var1=false;
    this.var2=false;
    this.isForm2Visible = false;
    this.isDisabled=false;
 
   
  }
 
 refreshMethod(){
  this.field2Value='';
  // this.submitTableData();
  this.apiobj.getstudentData().subscribe((res: any) => {
    this.studentApi=res;
    // console.log(this.apiobj)

    console.log(res)
      });

  this.toggleForm1();
  
 }
  toggleForm1() {
    this.isFormVisible = false;
    this.var2=true;
    this.isForm2Visible = true;
  }
 
  // Reset input fields
  resetFields() {
    this.field1Value = '';
    this.field2Value = '';
    this.field3Value = '';
  }
 
  submitTableData() {
 
    //if(this.isdata_deleted) {
    this.inputData.studentCode = this.field1Value;
    this.inputData.studentName = this.field2Value;
    this.inputData.studentEmail = this.field3Value;
    // this.apiobj.poststudentData(this.inputData).subscribe((res)=>{
    //     console.log("Successfully added...");
    // })

  
   

  

    if(this.field1Value!=''&& this.field2Value!='' && this.field3Value!=''){
      this.apiobj.poststudentData(this.inputData).subscribe((resp)=>{
       console.warn(resp);
       Swal.fire({
        html: `
          <div>
            <h2>Student Added</h2>
            <hr style="margin: 10px 0;>
            <p">An email has been sent to student with email id and password</p>
          </div>
        `,
        showCancelButton: false,
        confirmButtonColor: 'primary',
        confirmButtonText: 'Ok',
      });
      },(err)=>{
       console.log(err);
      });}

      this.apiobj.getstudentData().subscribe((res: any) => {
        this.studentApi=res;
          });

    // let details = JSON.parse(localStorage.getItem("add_student_details")||'[]');
    // details[this.index] = this.inputData;
    // console.log("hello", this.inputData, this.index, details, this.isdata_deleted);
    // localStorage.setItem("add_student_details", JSON.stringify(details))
    // this.showList();
    // this.resetFields();
    // this.isdata_deleted = false;
    // }
    // else {
    //   this.inputData.input1 = this.field1Value;
    //   this.inputData.input2 = this.field2Value;
    //   this.inputData.input3 = this.field3Value;
 
    //   this.tableData.push(this.inputData)
    //   let details = JSON.parse(localStorage.getItem("add_student_details")||'[]') ;
    //   details.push(this.inputData)
    //   localStorage.setItem("add_student_details", JSON.stringify(details))
    //   console.log("details", localStorage.getItem("add_student_details"))
    //   this.showList()
    //   this.resetFields();
 
   
 
    // this.isFormVisible=false;
    // this.isForm2Visible = true;
    // this.var2=true;
  //}
  this.isDisabled=true;
  }
 
  showList(){
    this.people=JSON.parse(localStorage.getItem("add_student_details")||'[]');
  }
 
  deleteItem(index: number) {
    const deletedId = this.studentApi[index].studentCode;

    console.log(index)
    console.log(deletedId);
    this.apiobj.deletestudentData(deletedId).subscribe((res)=>{
      console.log(res+" deleted successfully...")
    })
    Swal.fire({
      html: `
        <div>
          <h2>Delete Student Detail</h2>
          <hr style="margin: 10px 0;>
          <p">Are you sure that you want to delete this Student Detail?</p>
        </div>
      `,
      showCancelButton: true,
      confirmButtonColor: 'primary',
      cancelButtonColor: 'basic',
      confirmButtonText: 'Yes',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.isConfirmed) {
        this.studentApi.splice(index, 1);
        localStorage.setItem("add_student_details", JSON.stringify(this.people));
      }
    });
   
  }
 
//  editItem(index: number) {
 
//   this.isdata_deleted = true;

//   this.isFormVisible=true;
 
//   this.index = index;
//   const selectedPerson = this.people[index];
//   this.field1Value = selectedPerson.input1;
//   this.field2Value = selectedPerson.input2;
//   this.field3Value = selectedPerson.input3;
//   this.showList();
//  }
 
 isDisabled: boolean = false;
tablehide = false;
 
editRow(row: any) {
    // this.isdata_deleted = true;
  this.isFormVisible=true;

  const index = this.studentApi.indexOf(row);
  this.isDisabled = !this.isDisabled;
  console.log(index)
  // console.log(this.entries[index].code)
 
  if(!this.isDisabled){ 
    this.field1Value=row.studentCode
    this.field2Value=row.studentName
    this.field3Value = row.studentEmail
   
  }
  if(this.isDisabled){
   
  this.studentApi[index].studentCode = this.field1Value
  this.studentApi[index].studentName=this.field2Value
  this.studentApi[index].studentEmail=this.field3Value 
  this.apiobj.updatestudentData(this.studentApi[index],this.studentApi[index].studentCode).subscribe((res)=>{

  });
  this.isFormVisible=false;
  }

}
 
 
 var1=true;
 var2=true;
 
 
 
//  studentname: string = '';
//  course: string = '';
//  theorytime: string = '';
 
 
 
 
 
 
 
}