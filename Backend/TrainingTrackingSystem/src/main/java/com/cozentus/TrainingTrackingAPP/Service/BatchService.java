package com.cozentus.TrainingTrackingAPP.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cozentus.TrainingTrackingAPP.dto.BatchProgramStudentDTO;
import com.cozentus.TrainingTrackingAPP.dto.TeacherCourseDTO;
import com.cozentus.TrainingTrackingAPP.model.Batch;
import com.cozentus.TrainingTrackingAPP.model.BatchTeacherCourse;
import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Student;
import com.cozentus.TrainingTrackingAPP.model.Teacher;
import com.cozentus.TrainingTrackingAPP.model.TeacherCourse;
import com.cozentus.TrainingTrackingAPP.repository.BatchRepository;
import com.cozentus.TrainingTrackingAPP.repository.BatchTeacherCourseRepository;
import com.cozentus.TrainingTrackingAPP.repository.CourseRepository;
import com.cozentus.TrainingTrackingAPP.repository.ProgramRepository;
import com.cozentus.TrainingTrackingAPP.repository.StudentRepository;
import com.cozentus.TrainingTrackingAPP.repository.TeacherCourseRepository;
import com.cozentus.TrainingTrackingAPP.repository.TeacherRepository;

@Service
public class BatchService {
	
@Autowired
private BatchRepository batchrepository;

@Autowired
private StudentRepository studentrepository;

@Autowired
private ProgramRepository programrepository;

@Autowired
private StudentService studentservice;

@Autowired
private TeacherCourseRepository teachercourserepository;

@Autowired
private CourseService courseservice;
@Autowired
private CourseRepository courserepository;
@Autowired
private TeacherService teacherservice;
@Autowired
private TeacherRepository teacherrepository;

@Autowired
private BatchTeacherCourseRepository batchteachercourserepository;



    public List<Batch> getAllBatches() {
        return batchrepository.findAll();
    }
 
    public Batch getBatchById(int id) {
        java.util.Optional<Batch> optionalBatch = batchrepository.findById(id);
        return optionalBatch.orElse(null);
    }
 
    public void saveBatch(BatchProgramStudentDTO batchprogramstudentdto) {
       Batch batch = new Batch();
       batch.setBatchcode(batchprogramstudentdto.getBatchcode());
       batch.setBatchname(batchprogramstudentdto.getBatchname());
       batch.setBatchstartdate(batchprogramstudentdto.getBatchstartdate());
       batch.setBatchid(batchprogramstudentdto.getBatchid());
       
       batchrepository.save(batch);
    }
    
     
    
    public void EditBatch(int batchid,BatchProgramStudentDTO batchdto) {
    	Batch selectedbatch = batchrepository.findById(batchid).get();
    	
    	if(selectedbatch!=null) {
    		System.out.println(selectedbatch);
    		selectedbatch.setBatchcode(batchdto.getBatchcode());
    		selectedbatch.setBatchname(batchdto.getBatchname());
    		selectedbatch.setBatchstartdate(batchdto.getBatchstartdate());
//    		selectedbatch.setBatchid(batchdto.getBatchid());
    		batchrepository.save(selectedbatch);
    	}
    }
    
    
    public void SaveBatchStudent(BatchProgramStudentDTO batchprogramstudentdto) {
    	 String studentname =  batchprogramstudentdto.getStudentName()+",";
  	   String[] students = studentname.split(",");
  	   System.out.println(Arrays.toString(students));
  	   for(String studentlist:students) {
  		   studentservice.GetAllStudent();
  		   Student selectedstudent = studentrepository.findByStudentId(studentservice.findStudentIdbyStudentName(studentlist));
  		   if(selectedstudent!=null) {
  		   Student newStudent = new Student();
  		   
  		   List<Batch> allbatch = batchrepository.findAll();
  		   newStudent.setBatch(batchrepository.findById(allbatch.get(allbatch.size()-1).getBatchid()).get());
  		   newStudent.setProgram(programrepository.findByProgramname(batchprogramstudentdto.getProgramname()));
  		   newStudent.setStudentName(selectedstudent.getStudentName());
  		   newStudent.setStudentCode(selectedstudent.getStudentCode());
  		   newStudent.setStudentEmail(selectedstudent.getStudentEmail());
  		   
  		   studentrepository.save(newStudent);
  		   }
  	   }
    	
    }
    
    
    public void editBatchProgram(BatchProgramStudentDTO batchprogramstudentdto) {
    
    	String studentname = batchprogramstudentdto.getStudentName();
    	String[] students = studentname.split(",");
    	List<Batch> allbatch = batchrepository.findAll();
    	  for(String studentlist:students) {
     		   studentservice.GetAllStudent();
     		   Student selectedstudent = studentrepository.findByStudentId(studentservice.findStudentIdbyStudentName(studentlist));
     		   selectedstudent.setBatch(batchrepository.findById(allbatch.get(allbatch.size()-1).getBatchid()).get());
     		   selectedstudent.setProgram(programrepository.findByProgramname(batchprogramstudentdto.getProgramname()));
     		   selectedstudent.setStudentName(selectedstudent.getStudentName());
     		   selectedstudent.setStudentCode(selectedstudent.getStudentCode());
     		   selectedstudent.setStudentEmail(selectedstudent.getStudentEmail());
     		   
     		   studentrepository.save(selectedstudent);
    	  
    	  }  
    
    } 
    
    
    
    public void saveBatchTeacher(TeacherCourseDTO teachercoursedto) {
    	
    	List<TeacherCourse> listofteachercourse = teachercourserepository.findAll();
//    	System.out.println(listofteachercourse);
    	
    	String coursename = teachercoursedto.getCoursename();
    	
        courseservice.GetAllService();
        Course selectedcourse = courserepository.findByCourseid(courseservice.findCourseIdByCoursename(coursename));
    	
        Teacher selectedTeacher = teacherrepository.findByTeachername(teachercoursedto.getTeachername());
        
        List<Batch> allbatch = batchrepository.findAll();
		
        
    	for(TeacherCourse teachercourselist:listofteachercourse) {
    		if(teachercourselist.getTeacher()== selectedTeacher && teachercourselist.getCourse()==selectedcourse) {
    		  int teachercourseid = teachercourselist.getTeachercourseid();
    		   System.out.println(teachercourseid);
    		   BatchTeacherCourse batchteachercourse = new BatchTeacherCourse();
    		      		   
    		   batchteachercourse.setBatch(batchrepository.findById(allbatch.get(allbatch.size()-1).getBatchid()).get());
    		   batchteachercourse.setTeachercourse(teachercourserepository.findByTeachercourseid(teachercourseid));	  
    		   batchteachercourserepository.save(batchteachercourse);
    		   
    		}
    	}
    }
    
    
    public void editBatchTeacher(TeacherCourseDTO teachercoursedto) {
    	
      
    }
    
    
    
    
    
    
     
    public void deleteBatch(int id) {
        batchrepository.deleteById(id);
    }
    
    
    
public List<String> getAllBatchCodeAndBatchName()
    
    {
            List<String> batchCodeAndBatchNameList = new ArrayList<>();
            for (Batch batch : batchrepository.findAll()) {
                batchCodeAndBatchNameList.add(batch.getBatchcode() + "-" + batch.getBatchname());
            }
            return batchCodeAndBatchNameList;
        }
    
 
 
    public Date getBatchStartDateBybatchcode(String batchcode) {
        Batch batch = batchrepository.findBybatchcode(batchcode);
        if (batch != null) {
            return batch.getBatchstartdate();
        }
        return null; // or handle the case where the batch with the provided code is not found
    }     
	
    public List<Object[]> findProgramInfoBybatchcode(String batchcode) {
        return batchrepository.findProgramInfoBybatchcode(batchcode);
    }
    
    
}