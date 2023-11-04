package com.cozentus.TrainingTrackingAPP.model;
 
import java.util.Date;
  
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
 
@Entity
@Table(name = "evaluation_name")
public class EvaluationName {
 
    public EvaluationName() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private int evaluationId;
 
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
 
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
 
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;
 
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
 
    @Column(name = "type", length = 20)
    private String type;
 
    @Column(name = "submission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;
 
    @Column(name = "evaluation_name", length = 20)
    private String evaluationName;
 
    @Column(name = "total_marks")
    private int totalMarks;
 
    @Column(name = "marks_secured")
    private int marksSecured;
 
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
 
    @Column(name = "created_by", length = 30)
    private String createdBy;
 
    @Column(name = "updated_date")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
 
    @Column(name = "updated_by", length = 30)
    private String updatedBy;
 
	public int getId() {
		return evaluationId;
	}
 
	public void setId(int id) {
		this.evaluationId = id;
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
 
	public Batch getBatch() {
		return batch;
	}
 
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
 
	public Student getStudent() {
		return student;
	}
 
	public void setStudent(Student student) {
		this.student = student;
	}
 
	public String getType() {
		return type;
	}
 
	public void setType(String type) {
		this.type = type;
	}
 
	public Date getSubmissionDate() {
		return submissionDate;
	}
 
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
 
	public String getEvaluationName() {
		return evaluationName;
	}
 
	public void setEvaluationName(String evaluationName) {
		this.evaluationName = evaluationName;
	}
 
	public int getTotalMarks() {
		return totalMarks;
	}
 
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
 
	public int getMarksSecured() {
		return marksSecured;
	}
 
	public void setMarksSecured(int marksSecured) {
		this.marksSecured = marksSecured;
	}
 
	public Date getCreatedDate() {
		return createdDate;
	}
 
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
 
	public String getCreatedBy() {
		return createdBy;
	}
 
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
 
	public Date getUpdatedDate() {
		return updatedDate;
	}
 
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
 
	public String getUpdatedBy() {
		return updatedBy;
	}
 
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
 
	@Override
	public String toString() {
		return "EvaluationName [id=" + evaluationId + ", course=" + course + ", teacher=" + teacher + ", batch=" + batch
				+ ", student=" + student + ", type=" + type + ", submissionDate=" + submissionDate + ", evaluationName="
				+ evaluationName + ", totalMarks=" + totalMarks + ", marksSecured=" + marksSecured + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy
				+ ", getId()=" + getId() + ", getCourse()=" + getCourse() + ", getTeacher()=" + getTeacher()
				+ ", getBatch()=" + getBatch() + ", getStudent()=" + getStudent() + ", getType()=" + getType()
				+ ", getSubmissionDate()=" + getSubmissionDate() + ", getEvaluationName()=" + getEvaluationName()
				+ ", getTotalMarks()=" + getTotalMarks() + ", getMarksSecured()=" + getMarksSecured()
				+ ", getCreatedDate()=" + getCreatedDate() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getUpdatedDate()=" + getUpdatedDate() + ", getUpdatedBy()=" + getUpdatedBy() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
 
	public EvaluationName(int id, Course course, Teacher teacher, Batch batch, Student student, String type,
			Date submissionDate, String evaluationName, int totalMarks, int marksSecured, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.evaluationId = id;
		this.course = course;
		this.teacher = teacher;
		this.batch = batch;
		this.student = student;
		this.type = type;
		this.submissionDate = submissionDate;
		this.evaluationName = evaluationName;
		this.totalMarks = totalMarks;
		this.marksSecured = marksSecured;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}
    
    
 
}