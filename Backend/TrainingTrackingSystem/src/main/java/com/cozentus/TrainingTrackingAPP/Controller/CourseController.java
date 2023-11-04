package com.cozentus.TrainingTrackingAPP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cozentus.TrainingTrackingAPP.Service.CourseService;
import com.cozentus.TrainingTrackingAPP.dto.CourseProgram;
import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.repository.CourseRepository;



@RestController
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class CourseController {

	
	@Autowired
	private CourseRepository courserepoobj;
	
	@Autowired
	private CourseService courseserobj;
	
	@PostMapping("/course")
	public Course insertcourse(@RequestBody Course course) {
		
		return courseserobj.InsertCourseService(course);
		
	}
	
	@GetMapping("/course")
	public List<Course> getAll(){
		return courseserobj.GetAllService();
	}
	
	@DeleteMapping("/course/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		courserepoobj.deleteById(id);
	}
	
	@PutMapping("/course")
	public Course updatCourse(@RequestBody Course course) {
		return courseserobj.UpdateCourseService(course);
	}
	@GetMapping("/email")
	public void send_email() {
	     courseserobj.sendEmail("javatrainees2@gmail.com", "hii","helloo");
	}
//	@GetMapping("/course/coursename")
//	public List<Course> getcoursedetailsbycoursename(@RequestBody CourseProgram CourseName) {
//		
//		return (List<Course>) courserepoobj.findByCoursename(CourseName.getCoursename());
//	}
	
	@PutMapping("/course/programid")
	public Course updateprogramid(@RequestBody CourseProgram courseprogram) {
		return courseserobj.UpdateProgramIDService(courseprogram);
	}
	
	
	
//	@GetMapping("/coursename")
//	public List<String> getCourseName(@RequestBody int programid){
//        return courseserobj.getCourseNamesByProgramId(programid);		
//	}
	
	
	@GetMapping("/findcoursebyprogram/{programname}")
	public List<Course> findCourseByProgram(@PathVariable String programname){
		
		return courseserobj.findCoursebyProgram(programname);
	}
}
