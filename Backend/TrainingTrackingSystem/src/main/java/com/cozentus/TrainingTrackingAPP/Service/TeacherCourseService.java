package com.cozentus.TrainingTrackingAPP.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Teacher;
import com.cozentus.TrainingTrackingAPP.model.TeacherCourse;
import com.cozentus.TrainingTrackingAPP.repository.CourseRepository;
import com.cozentus.TrainingTrackingAPP.repository.TeacherCourseRepository;

@Service
public class TeacherCourseService {
	
	@Autowired
	private CourseRepository courserepository;
	
	@Autowired
	private TeacherCourseRepository teachercourserepository;
	
	public List<Teacher> findTeacher(String coursename){
		
//		List<Course> allcourse = (List<Course>) courserepository.findByCoursename(coursename);
		
		List<Teacher> allteacher = new ArrayList<Teacher>();
		List<TeacherCourse> allteachercourse = teachercourserepository.findAll();
		int k=0;
		for(int i=0;i<allteachercourse.size();i++) {
			if(allteachercourse.get(i).getCourse().getCoursename().equals(coursename)) {
				System.out.println("match..");
				allteacher.add(k++, allteachercourse.get(i).getTeacher());
			
				
			}
		
		}
		
		return allteacher;
		
		
	}

}
