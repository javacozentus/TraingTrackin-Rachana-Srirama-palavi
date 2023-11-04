package com.cozentus.TrainingTrackingAPP.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="teacher_course")
public class TeacherCourse {

	@Id
	@Column(name="teacher_course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teachercourseid;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "course_id",referencedColumnName = "course_id")
	 private Course course;
	
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "teacher_id",referencedColumnName = "teacher_id")
	 private Teacher teacher;

	
	 @OneToMany(mappedBy = "teachercourse")	
	  private List<BatchTeacherCourse> batchteachercourse;
	 

	public int getTeachercourseid() {
		return teachercourseid;
	}


	public void setTeachercourseid(int teachercourseid) {
		this.teachercourseid = teachercourseid;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	@Override
	public String toString() {
		return "TeacherCourse [teachercourseid=" + teachercourseid + ", course=" + course + ", teacher=" + teacher
				+ "]";
	}
	
	

	
}
