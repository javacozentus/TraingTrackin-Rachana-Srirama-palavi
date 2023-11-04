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
import org.springframework.web.bind.annotation.RestController;

import com.cozentus.TrainingTrackingAPP.Service.ProgramService;
import com.cozentus.TrainingTrackingAPP.dto.CourseProgram;
import com.cozentus.TrainingTrackingAPP.model.Program;
import com.cozentus.TrainingTrackingAPP.repository.ProgramRepository;

@RestController
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class ProgramController {

	@Autowired
	private ProgramRepository programrepoobj;
	
	@Autowired
	private ProgramService programserobj;
	
	@PostMapping("/program")
	public CourseProgram insertProgram(@RequestBody CourseProgram courseprogram) {
		
		return programserobj.InsertProgramService(courseprogram);	
	}
	
	@GetMapping("/program")
	public List<Program> getAll(){
		return programserobj.GetAllService();
	}
	
	@DeleteMapping("/program/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		programrepoobj.deleteById(id);
	}
	
	@PutMapping("/program")
	public Program updateProgram(@RequestBody CourseProgram program) {
		return programserobj.UpdateProgramService(program);
	}
	@GetMapping("/course-info/{programcode}")
	public List<Object[]> findCourseInfoByprogramcode(@PathVariable String programcode) {
	    return programserobj.findCourseInfoByprogramcode(programcode);
	}

	
}
