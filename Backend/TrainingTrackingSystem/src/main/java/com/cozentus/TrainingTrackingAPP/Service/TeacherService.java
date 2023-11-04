package com.cozentus.TrainingTrackingAPP.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cozentus.TrainingTrackingAPP.dto.TeacherCourseDTO;
import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Credentials;
import com.cozentus.TrainingTrackingAPP.model.Teacher;
import com.cozentus.TrainingTrackingAPP.model.TeacherCourse;
import com.cozentus.TrainingTrackingAPP.repository.CourseRepository;
import com.cozentus.TrainingTrackingAPP.repository.CredentialsRepository;
import com.cozentus.TrainingTrackingAPP.repository.ProgramRepository;
import com.cozentus.TrainingTrackingAPP.repository.TeacherCourseRepository;
import com.cozentus.TrainingTrackingAPP.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ProgramRepository programRepository;
	
	@Autowired
	private TeacherCourseRepository teacherCourseRepository;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CredentialsRepository credentialsrepository;
	
	public TeacherCourseDTO InsertIntoTeacher(TeacherCourseDTO teachercourse) {
		
		Teacher teacher = new Teacher();
		teacher.setTeachername(teachercourse.getTeachername());
		teacher.setTeachercode(teachercourse.getTeachercode());
		teacher.setTeacheremail(teachercourse.getTeacheremail());
		
		
		
		
		
		StringBuilder randomChars = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        StringBuilder randomNumber = new StringBuilder();
        String numbers = "1234567890";

        for (int i = 0; i < 4; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            randomChars.append(characters.charAt(randomIndex));
            
            int randomIndex1 = (int) (Math.random() * numbers.length());
            randomNumber.append(numbers.charAt(randomIndex1));
        }

		
        String password = "Teacher@"+randomChars.toString()+"@"+randomNumber.toString();
		
        String password1 = new BCryptPasswordEncoder().encode(password);
		
        
		teacher = teacherRepository.save(teacher);
		 courseService.sendEmail("javatrainees2@gmail.com","Teacher Name : " +teachercourse.getTeachername()+"\n"+"UserName: "+ teachercourse.getTeacheremail()+"\n"+"password: "+password,"Login Credentials for Teacher..");
		
		String[] courses = teachercourse.getCoursename().split(",");
		System.out.println(Arrays.toString(courses));
		
		 for (String courseName : courses) {
 	        Course updatedCourse = courseRepository.findByCourseid(courseService.findCourseIdByCoursename(courseName));

 	       if (updatedCourse != null) {
 	          TeacherCourse teacherCourse1 = new TeacherCourse();
 	          teacherCourse1.setTeacher(teacher);  // Set the teacher for this course
 	          teacherCourse1.setCourse(updatedCourse);
 	          teacherCourseRepository.save(teacherCourse1);
 	      }
 	    }
		
		 Credentials credential = new Credentials();
		 credential.setUserId(teachercourse.getTeacheremail());
		 credential.setPassword(password1);
		 credential.setRole("ROLE_TEACHER");
		
		 credentialsrepository.save(credential);
		 
		return teachercourse;
	
	}
	
//	==================================================
	public void updateTeacher(TeacherCourseDTO teachercoursedto) {
		
		Teacher teacher = teacherRepository.findByTeacherid(teachercoursedto.getTeacherid());
		System.out.println(teacher);
		
        teacher.setTeachercode(teachercoursedto.getTeachercode());
        teacher.setTeachername(teachercoursedto.getTeachername());
//        teacher.setTeacheremail(teachercoursedto.getTeacheremail());
        
        teacherRepository.save(teacher);
        
        String updatedCourses[]=teachercoursedto.getCoursename().split(",");
        
        
        
        List<TeacherCourse> existingTeacherCourses = teacherCourseRepository.findByTeacher(teacher);

        for (TeacherCourse existingTeacherCourse : existingTeacherCourses) {
            Course existingCourse = existingTeacherCourse.getCourse();
            String existingCourseName = existingCourse.getCoursename();

            // Check if the existing course name is in the updated list of courses
            if (!Arrays.asList(updatedCourses).contains(existingCourseName)) {
                // If the existing course is not in the updated list, delete it
                teacherCourseRepository.delete(existingTeacherCourse);
            }
        }

        // Add or update the TeacherCourse records for the updated courses
        for (String courseName : updatedCourses) {
            Course updatedCourse = courseRepository.findByCourseid(courseService.findCourseIdByCoursename(courseName));
            if (updatedCourse != null) {
                TeacherCourse existingTeacherCourse = teacherCourseRepository.findByCourseAndTeacher(updatedCourse, teacher);
                if (existingTeacherCourse != null) {
                    // If a record exists, update it
                    // You can add code to update any additional fields as needed
                    teacherCourseRepository.save(existingTeacherCourse);
                } else {
                    // If a record doesn't exist, create a new one and save it
                    TeacherCourse teacherCourse = new TeacherCourse();
                    teacherCourse.setTeacher(teacher);
                    teacherCourse.setCourse(updatedCourse);
                    teacherCourseRepository.save(teacherCourse);
                }
            }
        }
			 
	}
	
//	====================================================
	public List<String> getCoursebyTeacherid(Teacher teacher){
		List<Course> coursesTaughtByTeacher = teacherCourseRepository.findCoursesTaughtByTeacher(teacher);
		List<String> courseNames = coursesTaughtByTeacher.stream()
			    .map(course -> course.getCoursename())
			    .collect(Collectors.toList());
		return courseNames;
	}
	
	
	public List<Teacher> getTeacherbyCourseid(Course course){
		List<Teacher> teachersTeachingCourse = teacherCourseRepository.findTeachersTeachingCourse(course);

		return teachersTeachingCourse;

	}
	
	public List<Teacher> GetAllTeacher(){
		return teacherRepository.findAll();
	}
	
	public String deleteTeacher(int teacher) {
		
		teacherRepository.deleteById(teacher);
		return "delte successfully...";
		
	}
	
	
	
	
	
	
}
