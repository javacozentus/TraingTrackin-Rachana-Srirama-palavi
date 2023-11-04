package com.cozentus.TrainingTrackingAPP.dto;

import java.util.Date;

import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Teacher;


public class TeacherCourseDTO {
	

    private int teacherid;
	
	private String teachercode;
    
	private String teachername;
    
	private String teacheremail;
	
  
    private String createdby;
    

    private String updatedby;
    
  
    private Date createddate;
    
    private Date updateddate;
    
    private String coursename;
    
    private int courseid;
    

	private String coursecode;
	

  



	private String coursedescription;
	

	private int practicetime;
	

	public String getCoursecode() {
		return coursecode;
	}

	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}

	public String getCoursedescription() {
		return coursedescription;
	}

	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}

	public int getPracticetime() {
		return practicetime;
	}

	public void setPracticetime(int practicetime) {
		this.practicetime = practicetime;
	}

	public int getTheorytime() {
		return theorytime;
	}

	public void setTheorytime(int theorytime) {
		this.theorytime = theorytime;
	}

	

	private int theorytime;
	
	


    
    
    private Teacher teacher;
    
    private Course course;

	

	public void setTeacher(TeacherCourseDTO teacherCourseDTO) {
		if (this.teacher == null || teacherCourseDTO==null) {
		    this.teacher = new Teacher();
		    teacherCourseDTO = new TeacherCourseDTO();
		    // Initialize program if it's null
		}
		
		teacher.setTeacherid(teacherCourseDTO.getTeacherid());
		teacher.setTeachercode(teacherCourseDTO.getTeachercode());
		teacher.setTeacheremail(teacherCourseDTO.getTeacheremail());
		teacher.setTeachername(teacherCourseDTO.getTeachername());
		teacher.setCreatedby(teacherCourseDTO.getCreatedby());
		teacher.setCreateddate(teacherCourseDTO.getCreateddate());
		teacher.setUpdatedby(teacherCourseDTO.getUpdatedby());
		teacher.setUpdateddate(teacherCourseDTO.getUpdateddate());
		
		
	}
	public Teacher getTeacher() {
		return teacher;
	}

//	public void setCourse(TeacherCourseDTO teacherCourseDTO) {
//		if (this.course == null && teacherCourseDTO==null) {
//		    this.course = new Course(); // Initialize program if it's null
//		    teacherCourseDTO = new TeacherCourseDTO();
//		}
//		course.setCourseid(teacherCourseDTO.getCourseid());
//		course.setCoursename(teacherCourseDTO.getCoursename());
//		course.setCoursecode(teacherCourseDTO.getCoursecode());
//		course.setCoursedescription(teacherCourseDTO.getCoursedescription());
//		course.setTheorytime(teacherCourseDTO.getTheorytime());
//		course.setPracticetime(teacherCourseDTO.getPracticetime());
//		
//	}
	
	public void setCourse(Course course) {
		this.course=course;
	}
	
	public Course getCourse() {
		return course;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeachercode() {
		return teachercode;
	}

	public void setTeachercode(String teachercode) {
		this.teachercode = teachercode;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeacheremail() {
		return teacheremail;
	}

	public void setTeacheremail(String teacheremail) {
		this.teacheremail = teacheremail;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	
	

}
