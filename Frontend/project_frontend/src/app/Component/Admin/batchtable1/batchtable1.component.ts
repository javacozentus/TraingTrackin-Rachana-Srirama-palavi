import { Component, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
 
import { MatTableDataSource } from '@angular/material/table';
 
import { Batchtable2Component } from '../batchtable2/batchtable2.component';
import Swal from 'sweetalert2';
import { ApiServiceService } from 'src/app/api-service.service';
import { ConnectionPositionPair } from '@angular/cdk/overlay';
 
export interface PeriodicElement {
  Actions: string;
 
  Code: string;
 
  ProgramName: string;
 
  Student: string;
}
 
@Component({
  selector: 'app-batchtable1',
  templateUrl: './batchtable1.component.html',
  styleUrls: ['./batchtable1.component.css'],
})
export class Batchtable1Component {
 
  entries: any;
  dropdownOptions:string[]= [];
 
  dropdownOptions1:string[]= [];
  constructor(private apiobj: ApiServiceService) {
    const storedEntries = localStorage.getItem('entries');
    if (storedEntries) {
      this.entries = JSON.parse(storedEntries);
    }
    
    this.getprogramstudentdata();
   
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
 
  @ViewChild('container5', { read: ViewContainerRef, static: true })
  container5!: ViewContainerRef;
 
  ELEMENT_DATA: PeriodicElement[] = [
    { Actions: '', Code: '', ProgramName: '', Student: '' },
  ];
 
  displayedColumns: string[] = ['Actions', 'Code', 'ProgramName', 'Student'];
 
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);
 
  CourseName: any;
 
  Teacher: any;
 
  ProgramName: any;
 
  Student: any;

isprogram=false;



 batchobject2= {
    studentName:'',
    programname:''
}



  getprogramstudentdata(){
    
    this.apiobj.getProgramData().subscribe((res: any) => {
      console.log(res)
      console.log(res[0].programname);
      // this.courseNameApi=res;
      for (let index = 0; index < res.length; index++) {
        this.dropdownOptions[index] = res[index].programname;
      }
      console.log(this.dropdownOptions)
      // for (let index = 0; index < this.dropdownOptions.length; index++) {
      //   this.items.push({value: this.dropdownOptions[index],selected: false });
      // }
      console.log(this.items)
    });
   
    this.apiobj.getstudentData().subscribe((res: any) => {
      console.log(res)
      console.log(res[0].studentName);
      // this.courseNameApi=res;
      for (let index = 0; index < res.length; index++) {
        this.dropdownOptions1[index] = res[index].studentName;
      }
      console.log(this.dropdownOptions1)
      for (let index = 0; index < this.dropdownOptions1.length; index++) {
        this.items.push({value: this.dropdownOptions1[index],selected: false });
      }
      console.log(this.items)
    });

  }

getprogramname():string{
  return this.selectedValue;
}
 
  getBatchProgram() {
   
   

    this.isedit =true;
    this.isdelete = true;
    this.ischeck = false;
    this.iscross = false;
    this.isdisabled = false;
    console.log("hii i am running ...")


  }
  selectedValue='';
 
  removeall() {
    this.code = '';
    this.ProgramName = '';
    this.Student = '';
  }
 
  isdisabled = true;
  isedit = false;
  isdelete = false;
  ischeck = true;
  iscross = true;
 
  // addBatchStudent() {
   
 
  //   this.apiobj.getstudentData().subscribe((res: any) => {
  //     console.log(res)
  //     console.log(res[0].studentName);
  //     // this.courseNameApi=res;
  //     for (let index = 0; index < res.length; index++) {
  //       this.dropdownOptions1[index] = res[index].studentName;
  //     }
  //     console.log(this.dropdownOptions1)
  //     for (let index = 0; index < this.dropdownOptions1.length; index++) {
  //       this.items.push({value: this.dropdownOptions1[index],selected: false });
  //     }
  //     console.log(this.items)
  //   });
 
  //   // this.isedit =false;
  //   // this.isdelete = false;
  //   // this.ischeck = true;
  //   // this.iscross = true;
  //   // this.isdisabled = false;
  // }
 
  secondclick() {
    // this.container5.clear()
 
    this.var1 = false;
 
    this.var2 = false;
 
    this.var3 = false;
 
    this.var4 = true;
 
    this.var5 = true;
 
    this.var6 = true;
 
    this.container5.createComponent(Batchtable2Component);
    console.log(this.items)
    this.isprogram=true;
  
    const selectedValuesString = this.selectedItems.join(',');

   this.batchobject2.programname=this.selectedValue;
   this.batchobject2.studentName=selectedValuesString;


   this.apiobj.postSecondformbatch(this.batchobject2).subscribe((res)=>{
    console.log(res);
   })


  }
 
 
  onDateChange(event: any): void {
    this.selectedDate = event.value;
  }
 
  edittable2: boolean = true;
 
  toggletable2() {
    this.edittable2 = !this.edittable2;
 
    if (this.edittable2 == false) {
      this.var4 = false;
 
      this.var5 = false;
 
      this.var6 = false;
 
      this.var1 = true;
 
      this.var2 = true;
 
      this.var3 = true;
    }
 
    if (this.edittable2 == true) {
      this.var1 = false;
 
      this.var2 = false;
 
      this.var3 = false;
 
      this.var4 = true;
 
      this.var5 = true;
 
      this.var6 = true;
    }
  }
 
 
 
  table2 = true;
 
  deletetable2() {
    this.table2 = false;
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
 
    this.container5.clear();
  }
 
 
 
  items = [{ value: '', selected: false }];
 
  selectedItems: string[] = [];
 
  handleCheckboxChange() {
    this.selectedItems = this.items
      .filter((item: { selected: any }) => item.selected)
      .map((item: { value: any }) => item.value);
  }
}
 