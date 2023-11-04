package com.cozentus.TrainingTrackingAPP.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cozentus.TrainingTrackingAPP.dto.CourseProgram;
import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Program;
import com.cozentus.TrainingTrackingAPP.repository.CourseRepository;
import com.cozentus.TrainingTrackingAPP.repository.ProgramRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courserepoobj;
	
	@Autowired
	private ProgramRepository programRepository;
	
//	for insert 
	public Course InsertCourseService(Course course) {
		
		return courserepoobj.save(course);
		
	}
	List<Course> uniqueList = new ArrayList<Course>();
//	for retriving 
	public List<Course> GetAllService(){
		
		
		List<Course> duplicateList= courserepoobj.findAll();
		
		for (Course course : duplicateList) {
		    boolean isCourseNameUnique = true;
		    for (Course existingCourse : uniqueList) {
		        if (course.getCoursename().equals(existingCourse.getCoursename())) {
		            // If a course with the same name already exists, mark it as not unique
		            isCourseNameUnique = false;
		            break;
		        }
		    }

		    if (isCourseNameUnique) {
		        uniqueList.add(course);
		    }
		}
		
		return uniqueList;
	}
	
	public Integer findCourseIdByCoursename(String coursename) {
	    for (Course course : uniqueList) {
	        if (coursename.equals(course.getCoursename())) {
	            return course.getCourseid();
	        }
	    }
	    return null; // Return null if the course with the given name is not found
	}

	
	
	
	
	
	
//	for deletion 
	public void deleteCourseService(Integer id){
	    courserepoobj.deleteById(id);
	}
	
//	for updation 
	public Course UpdateCourseService(Course course) {
		
		
		Integer id = course.getCourseid();
		Course updatedcourse = courserepoobj.findById(id).get();
		
		updatedcourse.setCoursecode(course.getCoursecode());
		updatedcourse.setCoursename(course.getCoursename());
		updatedcourse.setTheorytime(course.getTheorytime());
		updatedcourse.setPracticetime(course.getPracticetime());
		updatedcourse.setCoursedescription(course.getCoursedescription());
		
		return courserepoobj.save(updatedcourse);
	}

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String toEmail, String subject , String body) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("javatrainees2@gmail.com");
		message.setTo(toEmail);
		message.setText(subject);
		message.setSubject(body);
		
		mailSender.send(message);
		
		System.out.println("Mail sent successfully");
		}
	
	public List<Course> GetAllCourseDetails(CourseProgram courseprogram){
		return (List<Course>) courserepoobj.findByCoursename(courseprogram.getCoursename());
	}
	
    public Course UpdateProgramIDService(CourseProgram course) {
		
    	String[] courses = course.getCoursename().split(",");
    	System.out.println(Arrays.toString(courses));
    	
    	Program program = new Program();
    	program.setProgramcode(course.getProgramcode());
    	program.setProgramname(course.getProgramname());
    	program.setProgramdesc(course.getProgramdesc());
    	program.setTheorytime(course.getTheorytime());
    	program.setPracticetime(course.getPracticetime());
    	
    	Program savedProgram = programRepository.save(program);
    	   for (String courseName : courses) {
    	        Course updatedCourse = courserepoobj.findByCoursename(courseName);
    	        updatedCourse.setProgram(savedProgram);
    	        courserepoobj.save(updatedCourse);
    	    }
    	
//    	for(int i=0;i<courses.length;++i) {
//    		List<Course> list1 = new ArrayList<>();
//    		
//    		list1.add(courserepoobj.findByCoursename(courses[i]));
////    		List<Course> list1 = courserepoobj.findByCoursename(course.getCoursename());
//            System.out.println(list1.get(0).getCourseid());
//            int courseid = list1.get(0).getCourseid();
//    	    Course updatedcourse = courserepoobj.findById(courseid).get();
//    		course.setProgram(course);
//   		    updatedcourse.setProgram(course.getProgram());	
//          courserepoobj.save(updatedcourse);
//    	    
//    	}
	
		return null;
         
//		Integer id = course.getCourseid();
//		Course updatedcourse = courserepoobj.findById(id).get();
//		
//		updatedcourse.setProgram(course);
		
//		updatedcourse.setCoursecode(course.getCoursecode());
//		updatedcourse.setCoursename(course.getCoursename());
//		updatedcourse.setTheorytime(course.getTheorytime());
//		updatedcourse.setPracticetime(course.getPracticetime());
//		updatedcourse.setCoursedescription(course.getCoursedescription());
			
		
	
	
	
}
    
  
public List<Course> findCoursebyProgram(String programname) {    
	
	List<Course> courses = courserepoobj.findByProgram(programRepository.findByProgramname(programname));
	
	 List<Course> uniqueCourses = courses.stream()
             .collect(Collectors.toMap(Course::getCoursename, course -> course, (existing, replacement) -> existing))
             .values()
             .stream()
             .collect(Collectors.toList());
	
	return uniqueCourses;
}
    
    
    
}