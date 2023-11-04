package com.cozentus.TrainingTrackingAPP.dto;

import java.util.Arrays;

public class EvaluationstudentDTO {
	private String examName;
  
    private String[] studentNames;
    private Integer[] marks;
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	
	public String[] getStudentNames() {
		return studentNames;
	}
	public void setStudentNames(String[] studentNames) {
		this.studentNames = studentNames;
	}
	public Integer[] getMarks() {
		return marks;
	}
	public void setMarks(Integer[] marks) {
		this.marks = marks;
	}
	public EvaluationstudentDTO(String examName,  String[] studentNames, Integer[] marks) {
		super();
		this.examName = examName;
		//this.totalMarks = totalMarks;
		this.studentNames = studentNames;
		this.marks = marks;
	}
	public EvaluationstudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EvaluationstudentDTO [examName=" + examName + ", totalMarks=" +  ", studentNames="
				+ Arrays.toString(studentNames) + ", marks=" + Arrays.toString(marks) + "]";
	}


}
