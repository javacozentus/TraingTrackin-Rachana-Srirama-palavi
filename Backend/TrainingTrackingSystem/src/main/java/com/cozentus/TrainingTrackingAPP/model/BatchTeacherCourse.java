package com.cozentus.TrainingTrackingAPP.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="batch_teachercourse")
public class BatchTeacherCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="batch_teachercourse_id")
	private int batchteachercourseid;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_id",referencedColumnName = "batch_id")
	private Batch batch;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_course_id",referencedColumnName = "teacher_course_id")
	private TeacherCourse teachercourse;


	public int getBatchteachercourseid() {
		return batchteachercourseid;
	}


	public void setBatchteachercourseid(int batchteachercourseid) {
		this.batchteachercourseid = batchteachercourseid;
	}


	public Batch getBatch() {
		return batch;
	}


	public void setBatch(Batch batch) {
		this.batch = batch;
	}


	public TeacherCourse getTeachercourse() {
		return teachercourse;
	}


	public void setTeachercourse(TeacherCourse teachercourse) {
		this.teachercourse = teachercourse;
	}

	
	
}
