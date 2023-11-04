export class demo{
    "examName":string= '';
    "studentNames":string [];
    "marks": number[]
 
 
    constructor(examName: string, studentNames: string[],marks:number[]) {
       this.examName=examName;
       this.marks=marks;
       this.studentNames=studentNames;
      }
 
}