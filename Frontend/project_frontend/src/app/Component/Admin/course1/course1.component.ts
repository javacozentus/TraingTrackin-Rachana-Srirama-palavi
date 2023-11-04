import {
  Component,
  ViewChild,
  ViewContainerRef,
  ElementRef,
  Renderer2,
  OnInit,
} from '@angular/core';
import { Router } from '@angular/router';
import { JsonPipe } from '@angular/common';
// import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { ApiServiceService } from 'src/app/api-service.service';

export interface PeriodicElement {
  Actions: string;

  Code: string;

  CourseName: string;

  TheoryTime: string;

  PractiseTime: string;

  Description: string;

  Topics: string;
}
export interface PeriodicElement1 {
  Actions1: string;

  Code1: string;

  CourseName1: string;

  TheoryTime1: string;

  PractiseTime1: string;

  Description1: string;

  Topics1: string;

  Files1: String;
}

@Component({
  selector: 'app-course1',
  templateUrl: './course1.component.html',
  styleUrls: ['./course1.component.css'],
})
export class Course1Component {
  courseApi: any = [];

  // ------------------------------------------------------
  constructor(
    private rout: Router,
    private el: ElementRef,
    private renderer: Renderer2,
    private apiobj: ApiServiceService
  ) {
    const storedEntries = localStorage.getItem('entries');
    if (storedEntries) {
      this.entries = JSON.parse(storedEntries);
    }

    // this.apiobj.getData().subscribe(res=>{
    //   this.courseApi = res;
    //   // console.log(this.courseApi);
    // })
  }

  // SaveToApi(){
  //   const apiobject = {
  //     code:"",
  //     course_name:"",
  //     theory_time: "",
  //     practice_time: "",
  //     description: "",
  //     topics: ""
  //    }

  //    apiobject.code=this.code;
  //    apiobject.course_name=this.course;
  //    apiobject.theory_time=this.Theorytime;
  //    apiobject.practice_time=this.practisetime;
  //    apiobject.description=this.descriptions;
  //    apiobject.topics=this.topics
  //    console.log(apiobject)
  //    if(apiobject.code!="" && apiobject.course_name!="" && apiobject.theory_time!="" && apiobject.practice_time!="" && apiobject.description!="" && apiobject.topics!="" ){

  //   this.apiobj.postData(apiobject).subscribe(res=>{
  //     console.log(res +" data saved successfully ");
  //   })
  // }
  //   this.isDisabled=true;
  //   this.tablehide=true;

  //     console.log(this.entries)
  //     this.coursetable=false;
  // }

  // DeleteFromApi(row:any){
  //       const index = this.courseApi.indexOf(row);
  //       const id = this.courseApi[index].id;
  //       console.log(id);
  //       this.apiobj.deleteData(id).subscribe(res=>{
  //         console.warn(id+ " deleted successfully...")
  //       })
  // }

  // UpdateFromApi(row:any){
  //   this.coursetable=true;
  //   const index = this.courseApi.indexOf(row);

  //   this.isDisabled = !this.isDisabled;

  //   // console.log(index)
  //   console.log(this.courseApi[index])

  //   if(!this.isDisabled){
  //     this.code=row.code
  //     this.course=row.course_name
  //     this.Theorytime = row.theory_time
  //     this.practisetime = row.practice_time
  //     this.descriptions = row.description
  //     this.topics= row.topics
  //   }
  //   if(this.isDisabled){

  //   this.courseApi[index].code = this.code
  //   this.courseApi[index].course_name=this.course
  //   this.courseApi[index].theory_time=this.Theorytime
  //   this.courseApi[index].practice_time=this.practisetime
  //   this.courseApi[index].description=this.descriptions
  //   this.courseApi[index].topics=this.topics

  //   this.apiobj.updateData(this.courseApi[index].id,this.courseApi[index]).subscribe(res=>{
  //     console.log("updated...")
  //   })

  //   }

  // }
  // SaveToApi(){
  //   const apiobject = {
  //     code:"",
  //     course_name:"",
  //     theory_time: "",
  //     practice_time: "",
  //     description: "",
  //     topics: ""
  //    }

  //    apiobject.code=this.code;
  //    apiobject.course_name=this.course;
  //    apiobject.theory_time=this.Theorytime;
  //    apiobject.practice_time=this.practisetime;
  //    apiobject.description=this.descriptions;
  //    apiobject.topics=this.topics
  //    console.log(apiobject)
  //    if(apiobject.code!="" && apiobject.course_name!="" && apiobject.theory_time!="" && apiobject.practice_time!="" && apiobject.description!="" && apiobject.topics!="" ){


  //   this.apiobj.postData(apiobject).subscribe(res=>{
  //     console.log(res +" data saved successfully ");
  //   })
  // }
  //   this.isDisabled=true;
  //   this.tablehide=true;

  //     console.log(this.entries)
  //     this.coursetable=false;
  // }

  // DeleteFromApi(row:any){
  //       const index = this.courseApi.indexOf(row);
  //       const id = this.courseApi[index].id;
  //       console.log(id);
  //       this.apiobj.deleteData(id).subscribe(res=>{
  //         console.warn(id+ " deleted successfully...")
  //       })
  // }

  // UpdateFromApi(row:any){
  //   this.coursetable=true;
  //   const index = this.courseApi.indexOf(row);


  //   this.isDisabled = !this.isDisabled;



  //   // console.log(index)
  //   console.log(this.courseApi[index])

  //   if(!this.isDisabled){ 
  //     this.code=row.code
  //     this.course=row.course_name
  //     this.Theorytime = row.theory_time
  //     this.practisetime = row.practice_time
  //     this.descriptions = row.description
  //     this.topics= row.topics
  //   }
  //   if(this.isDisabled){

  //   this.courseApi[index].code = this.code
  //   this.courseApi[index].course_name=this.course
  //   this.courseApi[index].theory_time=this.Theorytime
  //   this.courseApi[index].practice_time=this.practisetime
  //   this.courseApi[index].description=this.descriptions
  //   this.courseApi[index].topics=this.topics

  //   this.apiobj.updateData(this.courseApi[index].id,this.courseApi[index]).subscribe(res=>{
  //     console.log("updated...")
  //   })

  //   }

  // }


  entries: any[] = [];
  entries1: any[] = [];


  code: string = '';
  course: string = '';
  theorytime: string = ''
  practisetime: string = '';
  descriptions: string = '';
  topics: string = '';


  code1: string = '';
  course1: string = '';
  Theorytime1: string = ''
  practisetime1: string = '';
  descriptions1: string = '';
  topics1: string = '';



  obj = {

    coursecode: '',
    coursename: '',
    theorytime: '',
    practicetime: '',
    coursedescription: '',
    topics: ''
  }
  obj1 = {
    topicCode: '',
    topicName: '',
    theoryTime: '',
    practicalTime: '',
    topicSummary: '',
    content: '',
    courseid:''
  }




  ELEMENT_DATA: PeriodicElement[] = [

    { Actions: '', Code: '', CourseName: '', TheoryTime: '', PractiseTime: '', Description: '', Topics: '' },



  ];

  ELEMENT_DATA1: PeriodicElement1[] = [

    { Actions1: '', Code1: '', CourseName1: '', TheoryTime1: '', PractiseTime1: '', Description1: '', Topics1: '', Files1: '' },



  ];


  displayedColumns: string[] = ['Actions', 'Code', 'CourseName', 'TheoryTime', 'PractiseTime', 'Description', 'Topics'];
  displayedColumns1: string[] = ['Actions1', 'Code1', 'CourseName1', 'TheoryTime1', 'PractiseTime1', 'Description1', 'Topics1', 'Files1'];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);
  dataSource1 = new MatTableDataSource(this.ELEMENT_DATA1);
  coursetable = false;


  // course submit
  onLocalstorage() {



    this.obj.coursecode = this.code;
    this.obj.coursename = this.course;
    this.obj.theorytime = this.theorytime;
    this.obj.practicetime = this.practisetime;
    this.obj.coursedescription = this.descriptions;
    this.obj.topics = this.topics



    sessionStorage.setItem("obj", JSON.stringify(this.obj));

    const personCopy = { ...this.obj };
    this.entries.push(personCopy)


    this.isDisabled = true;
    this.tablehide = true;

    console.log("array")
    console.log(this.entries)
    this.coursetable = false;
    console.log("object")
    console.log(this.obj)

    // =========================================================

    if (this.obj.coursecode != '' && this.obj.coursename != '' && this.obj.theorytime != '' && this.obj.practicetime != '' && this.obj.coursedescription != '' && this.obj.topics != '') {
      this.apiobj.postData(this.obj).subscribe((resp) => {
        console.warn(resp);
      }, (err) => {
        console.log(err);
      });
    }
    // ================================================================
    this.apiobj.getData().subscribe((res) => {
      this.courseApi = res;
    });
    //===================================================================
    this.code = ''
  }


  tablehide1 = false;
  topicApi: any = [];
  onLocalstorage1() {



    this.obj1.topicCode = this.code1;
    this.obj1.topicName = this.course1;
    this.obj1.theoryTime = this.Theorytime1;
    this.obj1.practicalTime = this.practisetime1;
    this.obj1.topicSummary = this.descriptions1;
    this.obj1.content = this.topics1
    this.obj1.courseid=this.selectedcourseid;
    console.log(this.obj1.content)

    sessionStorage.setItem("obj1", JSON.stringify(this.obj1));

    const personCopy1 = { ...this.obj1 };
    this.entries1.push(personCopy1)


    this.isDisabled = true;
    this.tablehide1 = true;
    this.tablehide = false;
    console.log(this.entries)
    this.coursetable = false;
    this.topicshow1 = false;


    this.apiobj.addTopic(this.obj1).subscribe((res)=>{
      console.log("topic added successfully");
    })


    this.apiobj.getTopic().subscribe((res) => {
      this.topicApi = res;
    });


  }
  file: any[] = [];

  onFileSelected(event: any) {
    const selectedFile = event.target.files[0];
    this.file.push(event.target.files[0]);
    if (selectedFile) {
      // Handle the selected file here (e.g., display its name or perform further actions).
      console.log('Selected File: ', selectedFile.name);
    }
    const formData = new FormData();
    // for (let i = 0; i < this.file.length; i++) {
    //   formData.append('file', this.file[i]);
    // }
    formData.append('file', this.file[this.file.length - 1]);
    console.log(this.file)
    console.log(formData)
    this.apiobj.upload(formData).subscribe((res) => {
      console.log(res);
      // this.dialogRef.close(res);

    }, error => {
      console.error(error);
    });
  }
  @ViewChild('fileInput') fileInput!: ElementRef;
  openFileSelector() {
    this.fileInput.nativeElement.click();

  }






  deleteRow(row: any) {
    const index = this.courseApi.indexOf(row);
    const deletedId = this.courseApi[index].courseid;
    console.log(deletedId)
    console.log(this.courseApi[index])
    if (index !== -1) {
      this.courseApi.splice(index, 1);
      // console.log('Deleted:', row);
      this.apiobj.deleteData(deletedId).subscribe((res) => {

      }, (err) => {
        console.log(err)
      })
    }

  }




  // for editing a row 

  isDisabled: boolean = false;
  tablehide = false;
  editRow(row: any) {

    this.coursetable = true;
    const index = this.courseApi.indexOf(row);
    this.isDisabled = !this.isDisabled;
    console.log(index)
    // console.log(this.entries[index].code)

    if (!this.isDisabled) {
      this.code = row.coursecode
      this.course = row.coursename
      this.theorytime = row.theorytime
      this.practisetime = row.practicetime
      this.descriptions = row.coursedescription
      this.topics = row.topics
    }
    if (this.isDisabled) {

      this.courseApi[index].coursecode = this.code
      this.courseApi[index].coursename = this.course
      this.courseApi[index].theorytime = this.theorytime
      this.courseApi[index].practicetime = this.practisetime
      this.courseApi[index].coursedescription = this.descriptions
      this.courseApi[index].topics = this.topics
      this.apiobj.updateData(this.courseApi[index]).subscribe((res) => {

      });

    }

  }








  //----------------------------------------------------------
  // constructor(private rout:Router){}
  title = 'course-page';
  @ViewChild('container1', { read: ViewContainerRef, static: true })
  container1!: ViewContainerRef;
  @ViewChild('container2', { read: ViewContainerRef, static: true })
  container2!: ViewContainerRef;
  @ViewChild('container5', { read: ViewContainerRef, static: true })
  container5!: ViewContainerRef;

  allClear() {
    this.code = '';
    this.course = '';
    this.theorytime = '';
    this.practisetime = '';
    this.descriptions = '';
    this.topics = '';
    this.coursetable = false
  }
  onAddTopic() {
    // this.container1.clear()
    // this.container1.createComponent(InputComponent)
    this.coursetable = true;

    this.isDisabled = false;
    this.code = '';
    this.course = '';
    this.theorytime = '';
    this.practisetime = '';
    this.descriptions = '';
    this.topics = '';

  }
  // topic 
  topicshow = false;
  coursebutton = true;
  selectedcourseid=''
  istopictableactive=false;

  refresh(){
    if(this.istopictableactive){
      this.onLocalstorage1();
    }
    else{
      this.onLocalstorage();
    }
  }

  onTopic(row: any) {
    this.topicshow = true;
    this.coursebutton = false;
    this.code = row.coursecode;
    this.selectedcourseid=row.courseid;
    const h1Element = this.el.nativeElement.querySelector('#topicname'); // Replace 'myH1' with the actual id
    if (h1Element) {
      this.renderer.setProperty(h1Element, 'textContent', this.code.concat(" > PHP Basics"));
    }
    this.tablehide = false;
    this.isDisabled = false;
    this.code1 = '';
    this.course1 = '';
    this.Theorytime1 = '';
    this.practisetime1 = '';
    this.descriptions1 = '';
    this.topics1 = '';
    console.log("course id "+this.selectedcourseid);
    this.istopictableactive=true;
  }
  topicshow1 = false;
  onAddTopic1() {
    // this.container1.clear()
    // this.container1.createComponent(InputComponent)
    // this.coursetable=true;

    this.isDisabled = false;
    this.code1 = '';
    this.course1 = '';
    this.Theorytime1 = '';
    this.practisetime1 = '';
    this.descriptions1 = '';
    this.topics1 = '';
    this.topicshow1 = true;
  }

  editRow1(row: any) {

    this.topicshow1 = true;
    const index = this.topicApi.indexOf(row);


    this.isDisabled = !this.isDisabled;



    console.log(index)
    console.log(this.topicApi[index].code)

    if (!this.isDisabled) {
      this.code1 = row.topicCode
      this.course1 = row.topicName
      this.Theorytime1 = row.theoryTime
      this.practisetime1 = row.practicalTime
      this.descriptions1 = row.topicSummary
      this.topics1 = row.content
    }
    if (this.isDisabled) {

  this.topicApi[index].topicCode = this.code1
      this.topicApi[index].topicName = this.course1
      this.topicApi[index].theoryTime = this.Theorytime1
      this.topicApi[index].practicalTime = this.practisetime1
      this.topicApi[index].topicSummary = this.descriptions1
      this.topicApi[index].content = this.topics1

      console.log(this.topicApi[index])
     this.apiobj.editTopic(this.topicApi[index]).subscribe((res)=>{
      console.log("edit done !!")
     })
    }

  }

  deleteRow1(row: any) {
    const index = this.topicApi.indexOf(row);
    // if (index !== -1) {
    
    //   console.log('Deleted:', row);
    // }
    // console.log(this.topicApi[index].topicId)
   this.apiobj.deleteTopic(this.topicApi[index].topicId).subscribe((res)=>{
    console.log("topic deleted...")
   });
   this.topicApi.splice(index, 1);
  }
}
