package com.cozentus.TrainingTrackingAPP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cozentus.TrainingTrackingAPP.dto.CourseProgram;
import com.cozentus.TrainingTrackingAPP.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer>{
	
	Program findByProgramname(String Programname);
	
	List<CourseProgram> getCoursesByprogramcode(String programcode);
	@Query("SELECT c.coursecode, c.coursename FROM Course c WHERE c.program.programcode = :programcode")
    List<Object[]> findCourseInfoByprogramcode(@Param("programcode") String programcode);

}
