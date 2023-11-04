import { HttpClient, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { map } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService implements CanActivate {
  getCoursecodebycoursename(arg0: any) {
    throw new Error('Method not implemented.');
  }
 
  indexOf(row: any) {
    throw new Error('Method not implemented.');
  }

// url = "http://localhost:3000/course";
url = "http://localhost:8080";
constructor(private http:HttpClient,private router:Router) { }

getteachersData(){

return this.http.get(this.url+"/teacher");

}
postteachersData(teachersdata: any) {
  console.warn(teachersdata);
// const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
return this.http.post(this.url+"/teachers",teachersdata);


// return this.http.post(this.url+"/course", coursedata,{headers});


}
// deleteteachersData(id:any){
//  return this.http.delete(this.url+"/teachers/"+id);
// }


///---------
getData(){

  return this.http.get(this.url+"/course");
  
  }
  postData(coursedata: any) {
  // const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  
  console.warn(coursedata);
  
  // return this.http.post(this.url+"/course", coursedata,{headers});
  return this.http.post(this.url+"/course", coursedata);
  
  }
  deleteData(id:any){
   return this.http.delete(this.url+"/course/"+id);
  }
  updateData(data:any){
  
  return this.http.put(this.url+"/course",data);
  }


  postProgramData(programdata:any){
    return this.http.post(this.url+"/program",programdata)
  }


  getProgramData(){
   return this.http.get(this.url+"/program");
  }


  updateProgramIdInCourseTable(Programdata:any){
    return this.http.put(this.url+"/course/programid",Programdata);
  }
  updateProgramData(Programdata:any){
    return this.http.put(this.url+"/course/programid",Programdata);
  }


  addTeacher(teacherdata:any){

    return this.http.post(this.url+"/teacher",teacherdata);

  }



  getAllTeacher(){
    return this.http.get(this.url+"/teacher");
  }

  /////student//
 
getstudentData(){
  return this.http.get(this.url+"/students/all");
  }
  poststudentData(studentdata: any) {
  // const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
 
  console.warn(studentdata);
 
  // return this.http.post(this.url+"/course", coursedata,{headers});
  return this.http.post(this.url+"/students/add", studentdata);
 
  }
  deletestudentData(id:any){
   return this.http.delete(this.url+"/students/"+id);
  }
  updatestudentData(data:any,id:any){
 
  return this.http.put(this.url+"/students/"+id,data);
  }

  getAllCoursesByTeacherId(teacherdata:any){
   return this.http.post(this.url+"/get/course",teacherdata)
  }

  updateTeacherData(teacherdata:any){
    return this.http.put(this.url+"/teacher",teacherdata);
  }

  deleteTeacherdata(id:any){
    return this.http.delete(this.url+"/teacher/"+id);
  }


  // upload(formData: FormData): Observable<HttpEvent<string[]>> {
  //   return this.http.post<string[]>(`${this.url}/uploadfile`, formData, {
  //     reportProgress: true,
  //     observe: 'events'
  //   });
  // }
  upload(formData: FormData) {
    const headers = new HttpHeaders();
    return this.http.post(`${this.url}/uploadfile`, formData,{headers}); 
  }

  getCoursesByTeacher(data:any){
    return this.http.post(this.url+"get/course",data);
  }


  addBatch(data:any){
     return this.http.post(this.url+"/batch",data);
  }

  deleteprogramData(id:any){
    return this.http.delete(this.url+"/program/"+id);
   }

   addTopic(data:any){
      console.warn(data);
      return this.http.post(this.url+"/topics/add",data);

   }

   getTopic(){
    return this.http.get(this.url+"/topics");
   }

   editTopic(data:any){
    return this.http.put(this.url+"/topics/update",data);
   }

   deleteTopic(id:number){
    return this.http.delete(this.url+"/topics/delete/"+id);

   }

   //batch
 
getbatchData() {
 
  return this.http.get(this.url + '/batches');
}
 
postbatchData(batchdata: any) {
  return this.http.post(this.url+"/batch", batchdata);
}
// deletebatchData(id: any) {
//   return this.http.delete(this.url + '/batches' + id);
// }
// updatebatchData(data: any) {
//   return this.http.put(this.url + '/batches', data);
// }
 
addBatchData(batchData: any) {
  return this.http.post(this.url +'/batch', batchData);
 
}


getListofCoursesbyProgramname(programname:any){
  console.log(this.url+"/findcoursebyprogram/"+programname);
  return this.http.get(this.url+"/findcoursebyprogram/"+programname);

}

postSecondformbatch(data:any){
  return this.http.post(this.url+"/batch/student",data)
}


getteacherbycoursename(data:any){
   return this.http.get(this.url+"/getteacher/"+data)
}


postbatchform3(data:any){
  return this.http.post(this.url+"/batch/teacher",data);
  
}

postexamstudentmarks(data:any){
  return this.http.post(this.url+'/examstudentmarks',data);
}



 

getstudentData1(): Observable<string[]> {
  return this.http.get<string[]>(this.url + '/students/all')
    .pipe(
      map((response: any) => {
       
        return response;
      })
    );
    }


    // upload(formData: FormData) {
    //   return this.http.post(`${this.url}/uploadfile`, formData);
    // }
     
     
     
    //exam
    // getAllBatchCodeAndBatchName(){
    //   return this.http.get(this.url+ '/exam/get-batches-code-and-name');
    // }
    getAllBatchCodeAndBatchName(): Observable<string[]> {
      return this.http.get<string[]>(this.url+ '/exam/get-batches-code-and-name');
    }
     
    getBatchStartDateBybatchcode(data:any): Observable<string> {
      return this.http.get<string>(this.url + '/start-date/'+data);
     
     
    }
     
    getProgramInfoBybatchname(data:any){
        return this.http.get(this.url+ '/program-info/'+ data);
      }
     
    getCoursecodebycoursename1(data:any){
      return this.http.get(this.url+ '/course-info/'+data);
    }
     
     
    //exam
 
getexamData() {
  return this.http.get(this.url + '/evaluationsexam');
  }
  postexamData(data: any) {
  console.warn(data);
    return this.http.post(this.url + '/evaluationsexam', data);
  }
  deletetexamData(id: any) {
    return this.http.delete(this.url+'/evaluationsexam/'+id);
   
  }
  updateexamData(id: any,data:any) {
    return this.http.put(this.url+"/evaluationsexam/"+id,data);
  }

  updateexamData1(data: any) {
    return this.http.put(this.url + '/evalutiontableexam/edit/', data);
  }
   
   
   
  //assignment
   
  getassignmentData() {
  return this.http.get(this.url + '/evaluationsassignment');
  }
  postassignmentData(data: any) {
  console.warn(data);
    return this.http.post(this.url + '/evaluationsassignment', data);
  }
  deletetassignmentData(id: any) {
    return this.http.delete(this.url + '/evaluationsassignment/' + id);
  }
  updateassignmentData(id:any,data:any) {
    return this.http.put(this.url+"/evaluationsassignment/"+id,data);
  }
 
 
  public  getCurrentUser(){
    let headers = new HttpHeaders().set("Authorization", `Bearer ${localStorage.getItem("token")}`);
    return this.http.get(this.url+"/current-user",{headers});
  }
  
  
  generateToken(logindata:any){
  
    return this.http.post(this.url+"/token",logindata);
  
  }
  public loginUser(token:any){
    localStorage.setItem("token",token);
    return true;
   }
  
   public isLogin(){
    let tokenStr=localStorage.getItem("token");
    if(tokenStr==undefined || tokenStr=='' || tokenStr==null){
      return false;
    }else{
      return true;
    }
   }
  
  
   public isLogout(){
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
   }
  
   public getToken(){
    return localStorage.getItem("token");
   }
  
   public setUserDetails(user:any){
     localStorage.setItem("user",JSON.stringify(user));
   }
   
  
   public getUser(){
    let userstr= localStorage.getItem("user");
    if(userstr!=null){
       return JSON.parse(userstr);
    }
    else{
      this.isLogout();
      return null;
    }
   }
  
  
  
   public getUserrole(){
    let user = this.getUser();
    return user.authorities[0].authority;
   }
  
   canActivate() {
    if (this.getUserrole() === 'ROLE_ADMIN' || this.getUserrole() === 'ROLE_TEACHER') {
      return true;
    } else {
      this.router.navigate(['']); // Redirect to the login page or another appropriate page.
      return false;
    }
  }
  
  


 
 

  }