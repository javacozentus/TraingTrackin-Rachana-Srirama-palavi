package com.cozentus.TrainingTrackingAPP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cozentus.TrainingTrackingAPP.Service.TeacherCourseService;
import com.cozentus.TrainingTrackingAPP.Service.TeacherService;
import com.cozentus.TrainingTrackingAPP.dto.TeacherCourseDTO;
import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Teacher;

@RestController
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private TeacherCourseService teachercourseservice;

	@PostMapping("/teacher")
	public TeacherCourseDTO insertIntoTeacher(@RequestBody TeacherCourseDTO teachercoursedto ) {
		
		return teacherService.InsertIntoTeacher(teachercoursedto);
		
	}
	
	@PutMapping("/teacher")
	public void updateTeacher(@RequestBody TeacherCourseDTO teachercoursedto) {
		
		teacherService.updateTeacher(teachercoursedto);
		
	}
	
	@GetMapping("get/teacher")
	public List<Teacher> findTeacherbyCourse(@RequestBody Course course){
		return teacherService.getTeacherbyCourseid(course);
	}
	
	@PostMapping("get/course")
    public List<String> findCoursebyTeacher(@RequestBody Teacher teacher){
		return teacherService.getCoursebyTeacherid(teacher);
	}
	
	@GetMapping("/teacher")
	public List<Teacher> getallTeacher(){
		return teacherService.GetAllTeacher();
	}
	
	@DeleteMapping("/teacher/{id}")
	public String deleteTeacherData(@PathVariable int id) {
	 	 return teacherService.deleteTeacher(id);
	}
	
	@GetMapping("/getteacher/{coursename}")
	public List<Teacher> getTeacherbyCourseName(@PathVariable String coursename){
		return teachercourseservice.findTeacher(coursename);
	}
	
}
