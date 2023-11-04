package com.cozentus.TrainingTrackingAPP.model;

import java.util.Date;
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
@Table(name="Batch")
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="batch_id")
	private int batchid;
	
	@Column(name="batch_code")
	private String batchcode;
	
	@Column(name="batch_name")
	private String batchname;
	
	
	@Column(name="batch_startdate")
	private Date batchstartdate;
	
	@Column(name="created_by")
	private String createdby;
	
	@Column(name="updated_date")
	private Date updateddate;
	
	@Column(name="updated_by")
	private String updatedby;
	

	
	 
	 @ManyToOne
	 @JoinColumn(name = "program_id", referencedColumnName = "program_id")
	 private Program program;
	
	 
	@OneToMany(mappedBy = "batch")	
	private List<Student> student;

	
	@OneToMany(mappedBy = "batch")	
	private List<BatchTeacherCourse> batchteachercourse;

	public int getBatchid() {
		return batchid;
	}


	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}


	public String getBatchcode() {
		return batchcode;
	}


	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}


	public String getBatchname() {
		return batchname;
	}


	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}


	public Date getBatchstartdate() {
		return batchstartdate;
	}


	public void setBatchstartdate(Date batchstartdate) {
		this.batchstartdate = batchstartdate;
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


	


	public Program getProgram() {
		return program;
	}


	public void setProgram(Program program) {
		this.program = program;
	}


	@Override
	public String toString() {
		return "Batch [batchid=" + batchid + ", batchcode=" + batchcode + ", batchname=" + batchname
				+ ", batchstartdate=" + batchstartdate + ", createdby=" + createdby + ", updateddate=" + updateddate
				+ ", updatedby=" + updatedby  + ", program=" + program
				+ ", student=" + student + "]";
	}
	
	
	
	
	
	


	
	
	
 
}
 