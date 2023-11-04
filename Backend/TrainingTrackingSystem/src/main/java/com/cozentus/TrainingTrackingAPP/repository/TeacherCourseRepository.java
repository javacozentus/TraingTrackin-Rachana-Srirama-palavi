package com.cozentus.TrainingTrackingAPP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Teacher;
import com.cozentus.TrainingTrackingAPP.model.TeacherCourse;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Integer> {

	List<Course> findCoursesByTeacher(Teacher teacher);

	TeacherCourse findByTeacherAndCourse(Teacher teacher, Course removedCourse);

	List<TeacherCourse> findByTeacher(Teacher teacher);
	 TeacherCourse findByCourseAndTeacher(Course course, Teacher teacher);
	 @Query("SELECT tc.course FROM TeacherCourse tc WHERE tc.teacher = :teacher")
	    List<Course> findCoursesTaughtByTeacher(@Param("teacher") Teacher teacher);
	 
	 
	   @Query("SELECT tc.teacher FROM TeacherCourse tc WHERE tc.course = :course")
	    List<Teacher> findTeachersTeachingCourse( @Param("course") Course course);
	   
	   
	  public TeacherCourse findByTeachercourseid(int Teachercourseid);
	  
	  List<TeacherCourse> findByCourse(Course course);
	

}
