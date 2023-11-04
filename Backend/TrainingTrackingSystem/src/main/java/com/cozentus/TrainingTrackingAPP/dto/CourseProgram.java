package com.cozentus.TrainingTrackingAPP.dto;

import java.util.Date;

import com.cozentus.TrainingTrackingAPP.model.Program;

public class CourseProgram {
	
	private String coursename;
	private int programid;

	private String programcode;
	

	private String programname;
	

	private String programdesc;
	

	private int theorytime;
	

	private int practicetime;
	
	
	private Date updateddate;
	
	
	private String updatedby;
	

	private Date createddate;
	
	private Program program;
	
	

	
	
	public void setProgram(CourseProgram courseprogram) {
		if (this.program == null) {
		    this.program = new Program(); // Initialize program if it's null
		}
		
	    program.setProgramid(courseprogram.getProgramid());
		program.setProgramcode(courseprogram.getProgramcode());
		program.setProgramname(courseprogram.getProgramname());
	    program.setTheorytime(courseprogram.getTheorytime());
		program.setPracticetime(courseprogram.getPracticetime());
		program.setProgramdesc(courseprogram.getProgramdesc());
		program.setUpdatedby(courseprogram.getUpdatedby());
		program.setUpdateddate(courseprogram.getUpdateddate());
		program.setCreatedby(courseprogram.getCreatedby());
		program.setCreateddate(courseprogram.getCreateddate());
		
		
	}

	
	public Program getProgram() {
		return program;
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

	private String createdby;

	public int getProgramid() {
		return programid;
	}

	public void setProgramid(int programid) {
		this.programid = programid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

}
