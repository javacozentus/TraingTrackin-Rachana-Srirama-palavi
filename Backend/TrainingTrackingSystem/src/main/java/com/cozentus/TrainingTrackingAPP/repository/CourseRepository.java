package com.cozentus.TrainingTrackingAPP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Program;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

     public Course findByCoursename(String coursename);
     
     public Course findByCourseid(Integer courseid);

	public List<Course> findByProgram(Program updatedprogram);
	
	@Query("SELECT c.courseid FROM Course c WHERE c.coursename = :coursename")
	int findCourseIdByCoursename(String coursename);
     
	
	
	
}
