import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { MatIconRegistry } from '@angular/material/icon';
import Swal from 'sweetalert2';
import { ApiServiceService } from 'src/app/api-service.service';
import { CDK_DESCRIBEDBY_HOST_ATTRIBUTE } from '@angular/cdk/a11y';
 
const check_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M438.6 105.4c12.5 12.5 12.5 32.8 0 45.3l-256 256c-12.5 12.5-32.8 12.5-45.3 0l-128-128c-12.5-12.5-12.5-32.8 0-45.3s32.8-12.5 45.3 0L160 338.7 393.4 105.4c12.5-12.5 32.8-12.5 45.3 0z"/></svg>`;
 
const wrong_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License)
 
 Copyright 2023 Fonticons, Inc. --><path d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z"/></svg>`;
 
const Del_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M135.2 17.7L128 32H32C14.3 32 0 46.3 0 64S14.3 96 32 96H416c17.7 0 32-14.3 32-32s-14.3-32-32-32H320l-7.2-14.3C307.4 6.8 296.3 0 284.2 0H163.8c-12.1 0-23.2 6.8-28.6 17.7zM416 128H32L53.2 467c1.6 25.3 22.6 45 47.9 45H346.9c25.3 0 46.3-19.7 47.9-45L416 128z"/></svg>`;
 
const Edit_Icon = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M410.3 231l11.3-11.3-33.9-33.9-62.1-62.1L291.7 89.8l-11.3 11.3-22.6 22.6L58.6 322.9c-10.4 10.4-18 23.3-22.2 37.4L1 480.7c-2.5 8.4-.2 17.5 6.1 23.7s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L387.7 253.7 410.3 231zM160 399.4l-9.1 22.7c-4 3.1-8.5 5.4-13.3 6.9L59.4 452l23-78.1c1.4-4.9 3.8-9.4 6.9-13.3l22.7-9.1v32c0 8.8 7.2 16 16 16h32zM362.7 18.7L348.3 33.2 325.7 55.8 314.3 67.1l33.9 33.9 62.1 62.1 33.9 33.9 11.3-11.3 22.6-22.6 14.5-14.5c25-25 25-65.5 0-90.5L453.3 18.7c-25-25-65.5-25-90.5 0zm-47.4 168l-144 144c-6.2 6.2-16.4 6.2-22.6 0s-6.2-16.4 0-22.6l144-144c6.2-6.2 16.4-6.2 22.6 0s6.2 16.4 0 22.6z"/></svg>`;
 
@Component({
  selector: 'app-programs',
  templateUrl: './programs.component.html',
  styleUrls: ['./programs.component.css'],
})
export class ProgramsComponent implements OnInit {
  isDisabled: any;
 
  row: any;
  selectedValuesString: any;
  coursename: any;
  updateProgramDataobject: any;
 
  ngOnInit(): void {}
 
  // Dropdown options
  dropdownOptions: string[] = [];
 
  selectedDropdownValue: string = ''; // Holds the selected value from the dropdown
 
  isFormVisible: boolean = false;
  isForm2Visible: boolean = false;
  isPopupVisible: boolean = false;
  isSecondPopupVisible: boolean = false;
  popupInput: string = '';
  // secondPopupInput: string = '';
 
  // Input field values
  field1Value: string = '';
  field2Value: string = '';
  field3Value: string = '';
  field4Value: string = '';
  somya: string = '';
 
  // Array to store table data
  tableData: any[] = [];
  inputData: any = {
    programcode: '',
    programname: '',
    theorytime: '',
    practicetime: '',
    programdesc: '',
    coursename: '',
  };
 
  isdata_deleted: boolean = false;
  index: number = 0;
  people: any[] = JSON.parse(
    localStorage.getItem('add_program_details') || '[]'
  );
  data_length: string = JSON.parse(
    localStorage.getItem('add_program_details') || '[]'
  ).length;
  constructor(
    iconRegistry: MatIconRegistry,
    sanitizer: DomSanitizer,
    private apiservice: ApiServiceService
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
  }
 
  // Toggle form visibility
  toggleForm() {
    this.isFormVisible = true;
    this.var1 = false;
    this.var2 = false;
    this.isForm2Visible = false;
 
    this.apiservice.getData().subscribe((res: any) => {
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
 
   
 
    this.field1Value = '';
    this.field2Value = '';
    this.field3Value = '';
    this.field4Value = '';
    this.somya = '';
  }
 
  toggleForm1() {
    this.isFormVisible = false;
    this.var2 = true;
    this.isForm2Visible = true;
  }
 
  // Open pop-up
  openPopup() {
    this.isPopupVisible = true;
  }
 
  // Submit data from first pop-up
  submitPopup() {
    // this.inputData.input1 = this.field1Value;
    // this.inputData.input2 = this.field2Value;
    // this.inputData.input3 = this.field3Value;
    // this.inputData.input4 = this.field4Value;
    // this.inputData.firstpopupInput = this.popupInput;
    this.somya = this.popupInput;
    // this.inputData.dropdwon = this.selectedDropdownValue;
    this.closePopup();
    console.log('result', this.inputData);
  }
 
  // Close pop-up
  closePopup() {
    this.isPopupVisible = false;
    this.popupInput = ''; // Reset the input field
  }
 
  // Reset input fields
  resetFields() {
    this.field1Value = '';
    this.field2Value = '';
    this.field3Value = '';
    this.field4Value = '';
    this.popupInput = '';
    this.somya = '';
    this.selectedDropdownValue = '';
  }
 
  programApi: any = [];
  courseNameApi: any = [];
 
  submitTableData() {
    // if(this.isdata_deleted) {
 
    const selectedItems = this.items.filter(
      (item: { selected: boolean }) => item.selected === true
    );
    const selectedValues = selectedItems.map(
      (item: { value: any }) => item.value
    );
    const selectedValuesString = selectedValues.join(',');
 
    this.inputData.programcode = this.field1Value;
    this.inputData.programname = this.field2Value;
    this.inputData.theorytime = this.field3Value;
    this.inputData.practicetime = this.field4Value;
    this.inputData.programdesc = this.somya;
    this.inputData.coursename = selectedValuesString;
    console.log(selectedValuesString)
    console.log(this.inputData)

    this.apiservice.postProgramData(this.inputData).subscribe((res)=>{
      console.log(res)
    })
 
   
    // get data
 
    this.apiservice.getProgramData().subscribe((res) => {
      this.programApi = res;
    });
    this.items.splice(0, this.items.length);
  }
 
  showList() {
    this.people = JSON.parse(
      localStorage.getItem('add_program_details') || '[]'
    );
  }
 
  deleteItem(index: number) {
    const deletedId = this.programApi[index].programid;
    console.log( this.programApi[index]);
    console.log(deletedId);
    this.apiservice.deleteprogramData(deletedId).subscribe((res) => {
      console.log(res + ' deleted successfully...');
    });
    Swal.fire({
      html: `
        <div>
          <h2>Delete Program</h2>
          <hr style="margin: 10px 0;>
          <p">Are you sure that you want to delete this program?</p>
        </div>
      `,
      showCancelButton: true,
      confirmButtonColor: 'primary',
      cancelButtonColor: 'basic',
      confirmButtonText: 'Yes',
      cancelButtonText: 'No',
    }).then((result) => {
      if (result.isConfirmed) {
        this.people.splice(index, 1);
        localStorage.setItem(
          'add_program_details',
          JSON.stringify(this.people)
        );
      }
    });
  }
 
  editItem(row: any) {
   
    this.isdata_deleted = true;
    this.row = row;
    const selectedPerson = this.programApi[row];
    console.log("selected person", selectedPerson);
    this.field1Value = selectedPerson.input1;
    this.field2Value = selectedPerson.input2;
    this.field3Value = selectedPerson.input3;
    this.field4Value = selectedPerson.input4;
    this.somya = selectedPerson.firstpopupInput;
    this.selectedDropdownValue = selectedPerson.dropdwon;
    this.showList();
 
    if (!this.isDisabled) {
      this.field1Value = row.programcode;
      this.field2Value = row.programname;
      this.field3Value = row.theorytime;
      this.field4Value = row.practicetime;
      this.somya = row.programdesc;
      this.selectedValuesString = row.coursename;
    }
    if (this.isDisabled) {
      this.programApi[this.index].programcode = this.field1Value;
      this.programApi[this.index].programname = this.field2Value;
      this.programApi[this.index].theorytime = this.field3Value;
      this.programApi[this.index].practicetime = this.field4Value;
      this.programApi[this.index].programdesc = this.somya;
      this.programApi[this.index].selectedValuesString = this.coursename;
 
      this.updateProgramDataobject.programcode =
        this.programApi[this.index].programcode;
      this.updateProgramDataobject.programname =
        this.programApi[this.index].programname;
      this.updateProgramDataobject.theorytime =
        this.programApi[this.index].theorytime;
      this.updateProgramDataobject.practicetime =
        this.programApi[this.index].practicetime;
      this.updateProgramDataobject.programdesc =
        this.programApi[this.index].programdesc;
      this.updateProgramDataobject.coursename = this.selectedValuesString + ',';
      console.log(this.selectedValuesString);
      console.log(this.selectedItems);
 
      this.apiservice
        .updateProgramData(this.updateProgramDataobject)
        .subscribe((res: any) => {
          console.log(res);
        });
    }
  }
 
  var1 = true;
  var2 = true;
 
  items = [{ value: '', selected: false }];
 
  selectedItems: string[] = [];
 
  handleCheckboxChange() {
    this.selectedItems = this.items
      .filter((item: { selected: any }) => item.selected)
      .map((item: { value: any }) => item.value);
  }
  
}  
  

