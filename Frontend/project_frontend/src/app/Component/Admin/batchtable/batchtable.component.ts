import { Component, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
 
import { MatTableDataSource } from '@angular/material/table';
 
import { Batchtable1Component } from '../batchtable1/batchtable1.component';
import Swal from 'sweetalert2';
import { ApiServiceService } from 'src/app/api-service.service';
 
export interface PeriodicElement {
  Actions: string;
 
  Code: string;
 
  CourseName: string;
 
  BatchStart: string;
}
 
@Component({
  selector: 'app-batchtable',
  templateUrl: './batchtable.component.html',
  styleUrls: ['./batchtable.component.css'],
})
export class BatchtableComponent {
  batchtable: boolean | undefined;
  tablehide: boolean | undefined;
  isDisabled: boolean | undefined;
  batch: any;
 
  constructor(private apiobj: ApiServiceService) {
    const storedEntries = localStorage.getItem('entries');
    if (storedEntries) {
      this.entries = JSON.parse(storedEntries);
    }
  }
 
  batchcode: string = '';
  batchname: string = '';
  batchstartdate: string = '';
 
  obj = {
    batchcode: '',
    batchname: '',
    batchstartdate: '',
  };
 
  selectedDate = '';
 
  var1 = true;
 
  var2 = true;
 
  var3 = true;
 
  var4 = false;
 
  var5 = false;
 
  var6 = false;
 
  @ViewChild('container4', { read: ViewContainerRef, static: true })
  container4!: ViewContainerRef;
 
  ELEMENT_DATA: PeriodicElement[] = [
    { Actions: '', Code: '', CourseName: '', BatchStart: '' },
  ];
 
  displayedColumns: string[] = ['Actions', 'Code', 'CourseName', 'BatchStart'];
 
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);
  batchApi: any = [];
  entries: any[] = [];
 
 
  getbatchData() {
    this.apiobj.getbatchData().subscribe((res: any) => {
      this.batchApi = res;
    });
  }
 
  isedit = false;
  isdelete=false;
  ischeck=true;
  iscross=true;
  isdisabled=true;
 
  addBatchData() {
     
      this.obj.batchcode=this.batchcode;
      this.obj.batchname=this.batchname;
      this.obj.batchstartdate=this.selectedDate;
      this.apiobj.postbatchData(this.obj).subscribe(
        (resp) => {
          console.warn(resp);
          console.log("inserted...")
        },
        (err) => {
          console.log(err);
        }
      );
   this.isedit=true;
   this.isdelete=true;
   this.ischeck=false;
   this.iscross=false;
   this.isdisabled=false;
  }
 
 
  removeall(){
    this.batchcode='';
    this.batchname='';
    this.selectedDate='';
  }
   
 
  secondtable() {
    // this.container4.clear()
 
 
    this.var1 = false;
 
    this.var2 = false;
 
    this.var3 = false;
 
    this.var4 = true;
 
    this.var5 = true;
 
    this.var6 = true;
 
    this.container4.createComponent(Batchtable1Component);
  }
 
  onDateChange(event: any): void {
    this.selectedDate = event.value;
  }
 
  edittoggletable1 = true;
 
  edittable1(row: any) {
    this.edittoggletable1 = !this.edittoggletable1;
    this.batchtable = true;
    const index = this.batchApi.indexOf();
 
    this.isDisabled = !this.isDisabled;
 
    console.log(index);
 
    if (!this.isDisabled) {
      this.batchcode = row.batchcode;
      this.batchname = row.batchname;
      this.batchstartdate = row.batchstartdate;
    }
    // if (this.isDisabled) {
    //   this.batchApi[index].batchcode = this.batchcode;
    //   this.batchApi[index].batchname = this.batchname;
    //   this.batchApi[index].batchstartdate = this.batchstartdate;
    //   this.apiobj
    //     .updatebatchData(this.batchApi[index])
    //     .subscribe((res: any) => {});
    // }
 
  //    updatebatchData(row: any) {
  //   this.apiobj.updatebatchData(row).subscribe(
  //     (res: any) => {
  //       console.log("Batch with ID ${row.id} updated successfully.");
  //       this.getBatchData(); // Update the table after updating data
  //     },
  //     (err: any) => {
  //       console.error(err);
  //     }
  //   );
  // }
 
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
 
  table1 = true;
 
  deletetable1(row: any) {
    const id = row.batchid;
    // this.apiobj.deletebatchData(id).subscribe(
    //   (res: any) => {
    //     console.log("Batch with ID ${id} deleted successfully.");
    //     this.getbatchData(); // Update the table after deleting data
    //   },
    //   (err: any) => {
    //     console.error(err);
    //   }
    // );
    this.table1 = false;
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
 
    this.container4.clear();
  }
}
function updatebatchData(row: any, any: any) {
  throw new Error('Function not implemented.');
}
 
 