package com.cozentus.TrainingTrackingAPP.model;

import java.util.Date;
import java.util.List;

import com.cozentus.TrainingTrackingAPP.dto.CourseProgram;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;

@Entity
@Table(name="course")

public class Course {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private int courseid;
	

//	@ManyToOne
//	@JoinColumn(name = "program_id")
//	private Program program_id;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "program_id")
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private Program program_id;
	


	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "program_id",referencedColumnName = "program_id")
	 private Program program;


	 @OneToMany(mappedBy = "course")	
	 private List<TeacherCourse> teacherCourse;



	public Program getProgram() {
		return program;
	}




	




	public void setProgram(Program program) {
		this.program = program;
	}




	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", program_id=" + program + ", coursecode=" + coursecode
				+ ", coursename=" + coursename + ", coursedescription=" + coursedescription + ", practicetime="
				+ practicetime + ", theorytime=" + theorytime + ", createddate=" + createddate + ", createdby="
				+ createdby + ", updateddate=" + updateddate + ", updatedby=" + updatedby + "]";
	}




	public int getCourseid() {
		return courseid;
	}

	@Column(name="course_code")
	private String coursecode;
	
	@Column(name="course_name")
	private String coursename;
	
	@Column(name="course_description")
	private String coursedescription;
	
	@Column(name="practice_time")
	private int practicetime;
	
	@Column(name="theory_time")
	private int theorytime;
	
	
	@Column(name="created_date")
	private Date createddate;
	
	@Column(name="created_by")
	private String createdby;
	
	@Column(name="updated_date")
	private Date updateddate;
	
	@Column(name="updated_by")
	private String updatedby;

	
	




	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	
	

	public String getCoursecode() {
		return coursecode;
	}
	


	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
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

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	

	

}
