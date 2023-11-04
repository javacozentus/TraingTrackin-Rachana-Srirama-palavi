package com.cozentus.TrainingTrackingAPP.model;



import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="program")
public class Program {
	
	@Id
	@Column(name="program_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int programid;
	
	@Column(name = "program_code")
	private String programcode;
	
	@Column(name = "program_name")
	private String programname;
	
	@Column(name = "program_description")
	private String programdesc;
	
	@Column(name = "theory_time")
	private int theorytime;
	
	@Column(name="practice_time")
	private int practicetime;
	
   @OneToMany(mappedBy = "program")	
   private List<Course> course;
   
   
   @OneToMany(mappedBy = "program")	
   private List<Student> student;
   
   @OneToMany(mappedBy = "program")	
   private List<Batch> batch;
   
   
	public int getProgramid() {
		return programid;
	}

	public void setProgramid(int programid) {
		this.programid = programid;
	}

	public String getProgramcode() {
		return programcode;
	}

	public void setProgramcode(String programcode) {
		this.programcode = programcode;
	}

	public String getProgramname() {
		return programname;
	}

	public void setProgramname(String programname) {
		this.programname = programname;
	}

	public String getProgramdesc() {
		return programdesc;
	}

	public void setProgramdesc(String programdesc) {
		this.programdesc = programdesc;
	}

	public int getTheorytime() {
		return theorytime;
	}

	public void setTheorytime(int theorytime) {
		this.theorytime = theorytime;
	}

	public int getPracticetime() {
		return practicetime;
	}

	public void setPracticetime(int practicetime) {
		this.practicetime = practicetime;
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

	@Column(name = "updated_date")
	private Date updateddate;
	
	@Column(name = "updated_by")
	private String updatedby;
	
	@Override
	public String toString() {
		return "Program [programid=" + programid + ", programcode=" + programcode + ", programname=" + programname
				+ ", programdesc=" + programdesc + ", theorytime=" + theorytime + ", practicetime=" + practicetime
				+ ", course=" + course + ", student=" + student + ", batch=" + batch + ", updateddate=" + updateddate
				+ ", updatedby=" + updatedby + ", createddate=" + createddate + ", createdby=" + createdby + "]";
	}

	@Column(name="created_date")
	private Date createddate;
	
	@Column(name = "created_by")
	private String createdby;
	

	

	

}
