package com.cozentus.TrainingTrackingAPP.dto;

import java.util.Date;

import com.cozentus.TrainingTrackingAPP.model.Batch;
import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Program;
import com.cozentus.TrainingTrackingAPP.model.Student;
import com.cozentus.TrainingTrackingAPP.model.Teacher;
import com.cozentus.TrainingTrackingAPP.model.TeacherCourse;

public class BatchProgramStudentDTO {
	
	
	private int batchid;
	
	
	private String batchcode;
	
	
	private String batchname;
	
	
	
	private Date batchstartdate;
	
	
	private String createdby;
	

	private Date updateddate;
	
	
	private String updatedby;
	
//	==================================================================================
	
   private int programid;
	

	private String programcode;
	

	private String programname;
	

	private String programdesc;
	

	private int theorytime;
	
	
	private int practicetime;
	
// ====================================================================================	
	
	    private int studentId;


	    
	    private String studentCode;

	    private String studentName;

	   
	    private String studentEmail;


//	===================================================================================
	private Batch batch;
	private Program program;
	private Student student;
	private TeacherCourse teachercourse;
	private Course course;
	private Teacher teacher;
	private BatchProgramStudentDTO batchprogramstudent;
	
	
//	=====================================================================================
	
	
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
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
//	============================================================================================
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(BatchProgramStudentDTO batchprogramstudentdto) {
		if (this.batch == null || batchprogramstudent==null) {
		    this.batch = new Batch();
		    batchprogramstudent = new BatchProgramStudentDTO();
		}
		
		
		batch.setBatchcode(batchprogramstudentdto.getBatchcode());
		batch.setBatchname(batchprogramstudentdto.getBatchname());
		batch.setBatchstartdate(batchprogramstudentdto.getBatchstartdate());
		batch.setBatchid(batchprogramstudentdto.getBatchid());
		
		
	}
	@Override
	public String toString() {
		return "BatchProgramStudentDTO [studentName=" + studentName + "]";
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(BatchProgramStudentDTO batchprogramstudentdto) {
		if (this.program == null || batchprogramstudent==null) {
		    this.program = new Program();
		    batchprogramstudent = new BatchProgramStudentDTO();
		}
		
		program.setProgramcode(batchprogramstudentdto.getProgramcode());
		program.setProgramid(batchprogramstudentdto.getProgramid());
		program.setProgramname(batchprogramstudentdto.getProgramname());
		program.setProgramdesc(batchprogramstudentdto.getProgramdesc());
		program.setTheorytime(batchprogramstudentdto.getTheorytime());
		program.setPracticetime(batchprogramstudentdto.getPracticetime());
		
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(BatchProgramStudentDTO batchprogramstudentdto) {
		
		if (this.student == null || batchprogramstudent==null) {
		    this.student = new Student();
		    batchprogramstudent = new BatchProgramStudentDTO();
		}
		
		student.setStudentCode(batchprogramstudentdto.getStudentCode());
		student.setStudentEmail(batchprogramstudentdto.getStudentEmail());
		student.setStudentName(batchprogramstudentdto.getStudentName());
		student.setStudentId(batchprogramstudentdto.getStudentId());
		
		
	}
//	public TeacherCourse getTeachercourse() {
//		return teachercourse;
//	}
	public void setTeachercourse(BatchProgramStudentDTO batchprogramstudentdto) {
		

		if (this.teachercourse == null || batchprogramstudent==null || course==null || teacher==null) {
		    this.teachercourse = new TeacherCourse();
		    this.teacher= new Teacher();
		    this.course = new Course();
		    batchprogramstudent = new BatchProgramStudentDTO();
		}
		
		
		
		
	}
	
	
	
	
	
	
	

}
