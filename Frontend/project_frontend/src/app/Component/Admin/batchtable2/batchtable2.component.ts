import { Component, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
 
import { MatTableDataSource } from '@angular/material/table';
import { ApiServiceService } from 'src/app/api-service.service';
import Swal from 'sweetalert2';
import { Batchtable1Component } from '../batchtable1/batchtable1.component';
 
export interface PeriodicElement {
  Actions: string;
 
  Code: string;
 
  Coursename: string;
 
  Teacher: string;
}
 
@Component({
  selector: 'app-batchtable2',
  templateUrl: './batchtable2.component.html',
  styleUrls: ['./batchtable2.component.css'],
})
export class Batchtable2Component {
  iscourse=false;
  entries: any;
  dropdownOptions:string[]= [];
  dropdownOptions1:string[]= [];
  programname: string;
  constructor(private apiobj: ApiServiceService,private firstbatchtable:Batchtable1Component) {
    const storedEntries = localStorage.getItem('entries');
    if (storedEntries) {
      this.entries = JSON.parse(storedEntries);
    }
    // this.getBatchTeacher();
   
   console.log(firstbatchtable.getprogramname())
   this.programname = firstbatchtable.getprogramname();
   this.getBatchCourse();
  }
 
  code = '';
 
  batchname = '';
 
  selectedDate = '';
 
  var1 = true;
 
  var2 = true;
 
  var3 = true;
 
  var4 = false;
 
  var5 = false;
 
  var6 = false;
 
  @ViewChild('container6', { read: ViewContainerRef, static: true })
  container6!: ViewContainerRef;
 
  ELEMENT_DATA: PeriodicElement[] = [
    { Actions: '', Code: '', Coursename: '', Teacher: '' },
  ];
 
  displayedColumns: string[] = ['Actions', 'Code', 'Coursename', 'Teacher'];
 
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);
 
  CourseName: any;
 
  Teacher: any;
 
  Coursename: any;
 
  ischeck=true;
  iscross=true;
  isedit=false;
  isdelete=false;
 
  getBatchCourse() {
   
    this.apiobj.getListofCoursesbyProgramname(this.programname).subscribe((res: any) => {

      

      // this.courseNameApi=res;
      for (let index = 0; index < res.length; index++) {
        console.log("course")
        console.log(res[index].coursename);
        this.dropdownOptions[index] = res[index].coursename;
      }
    
      // for (let index = 0; index < this.dropdownOptions.length; index++) {
      //   this.items.push({value: this.dropdownOptions[index],selected: false });
      // }
    
    });



    // this.apiobj.getteacherbycoursename(this.selectedValue).subscribe((res: any) => {
    //   console.log(res)
    //   console.log(res[0].teachername);
    //   // this.courseNameApi=res;
    //   for (let index = 0; index < res.length; index++) {
    //     this.dropdownOptions1[index] = res[index].teachername;
    //   }
    //   console.log(this.dropdownOptions1)
    //   for (let index = 0; index < this.dropdownOptions1.length; index++) {
    //     this.items.push({value: this.dropdownOptions1[index],selected: false });
    //   }
    //   console.log(this.items)
    // });
 
 
    console.log(this.items)
  








  }
 courseselected(){
    this.dropdownOptions1.splice(0,this.dropdownOptions1.length);
    this.items.splice(0,this.items.length)
  this.apiobj.getteacherbycoursename(this.selectedValue).subscribe((res: any) => {
    console.log(res)
    console.log(res[0].teachername);
    // this.courseNameApi=res;
    for (let index = 0; index < res.length; index++) {
      this.dropdownOptions1[index] = res[index].teachername;
    }
    console.log(this.dropdownOptions1)
    for (let index = 0; index < this.dropdownOptions1.length; index++) {
      this.items.push({value: this.dropdownOptions1[index],selected: false });
    }
    console.log(this.items)
  });
  
 }
















  selectedValue='';
  removeall(){
    this.code='';
    this.Coursename='';
    this.Teacher='';
  }
 
  // getBatchTeacher() {
 
   
  // }

  thirdobj = {
    "teachername":'',
    "coursename":''
  }

 
  seclick() {
    this.container6.clear();
 
    this.var1 = false;
 
    this.var2 = false;
 
    this.var3 = false;
 
    this.var4 = true;
 
    this.var5 = true;
 
    this.var6 = true;
   
 
    // this.container6.createComponent(Batchtable2Component)
    console.log(this.items)
    this.ischeck=false;
    this.iscross=false;
    this.isedit=true;
    this.isdelete=true;
    this.iscourse=true;
   
    const selectedValuesString = this.selectedItems.join(',');
    this.thirdobj.coursename=this.selectedValue;
    this.thirdobj.teachername=selectedValuesString;

    console.log(this.thirdobj)

    this.apiobj.postbatchform3(this.thirdobj).subscribe((res)=>{
      console.log("inserted successfully...")
    })

    

    

  }
 
  onDateChange(event: any): void {
    this.selectedDate = event.value;
  }
 
  edittoggletable1 = true;
 
  edittable3() {
    this.edittoggletable1 = !this.edittoggletable1;
 
    if (this.edittoggletable1 == false) {
      this.var4 = false;
 
      this.var5 = false;
 
      this.var6 = false;
 
      this.var1 = true;
 
      this.var2 = true;
 
      this.var3 = true;
    }
 
    if (this.edittoggletable1 == true) {
      this.var1 = false;
 
      this.var2 = false;
 
      this.var3 = false;
 
      this.var4 = true;
 
      this.var5 = true;
 
      this.var6 = true;
    }
  }
 
  table3 = true;
 
  deletetable3() {
    this.table3 = false;
    Swal.fire({
      html: `
        <div>
          <h2>Delete Batch</h2>
          <hr style="margin: 10px 0;">
          <p>Are you sure that you want to delete this Batch?</p>
        </div>
      `,
      showCancelButton: true,
      confirmButtonColor: 'primary',
      cancelButtonColor: 'basic',
      confirmButtonText: 'Yes',
      cancelButtonText: 'No',
    });
  }
  items = [
    { value: '', selected: false },
  ];
 
  selectedItems: string[] = [];
 
  handleCheckboxChange() {
    this.selectedItems = this.items
      .filter((item: { selected: any; }) => item.selected)
      .map((item: { value: any; }) => item.value);
  }
 
}