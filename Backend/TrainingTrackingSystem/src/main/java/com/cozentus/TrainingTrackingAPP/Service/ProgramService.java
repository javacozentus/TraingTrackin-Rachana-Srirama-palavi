package com.cozentus.TrainingTrackingAPP.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cozentus.TrainingTrackingAPP.dto.CourseProgram;
import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Program;
import com.cozentus.TrainingTrackingAPP.repository.CourseRepository;
import com.cozentus.TrainingTrackingAPP.repository.ProgramRepository;

@Service
public class ProgramService {
	

	@Autowired
	private ProgramRepository programrepoobj;
	
	@Autowired
	private CourseRepository courserepobj;
	
	@Autowired
	private CourseService courseserobj;
	
//	for insert 
	public CourseProgram InsertProgramService(CourseProgram courseprogram) {
		
		Program program = new Program();
		program.setProgramcode(courseprogram.getProgramcode());
		program.setProgramdesc(courseprogram.getProgramdesc());
		program.setProgramname(courseprogram.getProgramname());
		program.setTheorytime(courseprogram.getTheorytime());
		program.setPracticetime(courseprogram.getPracticetime());
		
		programrepoobj.save(program);
		String coursename =  courseprogram.getCoursename()+",";
		String[] courses = coursename.split(",");
		
		for(String courseName:courses) {
			 Course updatedCourse = courserepobj.findByCourseid(courseserobj.findCourseIdByCoursename(courseName));
			 courseserobj.GetAllService();
			 System.out.println(courseserobj.findCourseIdByCoursename(courseName));
			 
			  if (updatedCourse != null) {
				  Course updatedCourse1 = new Course();
//             updatedCourse.setProgram(program);
             updatedCourse1.setProgram(program);
             updatedCourse1.setCoursecode(updatedCourse.getCoursecode());
             updatedCourse1.setCoursedescription(updatedCourse.getCoursedescription());
             updatedCourse1.setCoursename(updatedCourse.getCoursename());
             updatedCourse1.setTheorytime(updatedCourse.getTheorytime());
             updatedCourse1.setPracticetime(updatedCourse.getPracticetime());
             
             courserepobj.save(updatedCourse1);
			  }else {
	            	
	                System.out.println("updateprogram is null");
	            }
             System.out.println("Course Inserted Succesfully");
			
			 
		}
		
		System.out.println("program inserted Successfully...");
		return null;
		
	}
	
//	for retriving 
	public List<Program> GetAllService(){
		return programrepoobj.findAll();
	}
	
//	for deletion 
	public void deleteProgramService(Integer id){
	    programrepoobj.deleteById(id);
	}
	
//	for updation 
	public Program UpdateProgramService(CourseProgram program) {
			
		Integer id = program.getProgramid();
		Program updatedprogram = programrepoobj.findById(id).get();
		
		updatedprogram.setProgramcode(program.getProgramcode());
		updatedprogram.setProgramname(program.getProgramname());
		updatedprogram.setProgramdesc(program.getProgramdesc());
		updatedprogram.setTheorytime(program.getTheorytime());
		updatedprogram.setPracticetime(program.getPracticetime());
		programrepoobj.save(updatedprogram);
		String coursename =  program.getCoursename()+",";
		String[] courses = coursename.split(",");
		
		 List<Course> programCourses = courserepobj.findByProgram(updatedprogram);
		 System.out.println(programCourses);
		 for (Course course : programCourses) {
	            if (!Arrays.asList(courses).contains(course.getCoursename())) {
	                // If the course is no longer in the list, set its program to null
	                course.setProgram(null);
	                courserepobj.save(course);
	            }
	        }
		 courseserobj.GetAllService();
		 for (String courseName : courses) {
	            Course updatedCourse = courserepobj.findByCourseid(courseserobj.findCourseIdByCoursename(courseName));
	           if (updatedCourse != null && updatedCourse.getProgram()==null) {
	            	
	            	
	                updatedCourse.setProgram(updatedprogram);
	                 updatedCourse.setProgram(updatedCourse.getProgram());
	                updatedCourse.setCoursecode(updatedCourse.getCoursecode());
	                updatedCourse.setCoursedescription(updatedCourse.getCoursedescription());
	                updatedCourse.setCoursename(updatedCourse.getCoursename());
	                
	                courserepobj.save(updatedCourse);
	            } 
	           else if (updatedCourse != null && updatedCourse.getProgram()!=null) {
	        	   Course newCourse = new Course();
	        	   newCourse.setProgram(updatedprogram);
	        	   newCourse.setCoursecode(updatedCourse.getCoursecode());
	        	   newCourse.setCoursename(updatedCourse.getCoursename());
	        	   newCourse.setCoursedescription(updatedCourse.getCoursedescription());
	        	   courserepobj.save(newCourse);
	           }
	           else {
	            	System.out.println("updateprogram is null");
	            }
	        }
		 return null;
	}
	
	
	public List<Object[]> findCourseInfoByprogramcode(String programcode) {
        return  programrepoobj.findCourseInfoByprogramcode(programcode);
    }
	

}
