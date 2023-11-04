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

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private int topicId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "order_num")
    private int orderNum;

    @Column(name = "topic_code")
    private String topicCode;

    @Column(name = "topic_name")
    private String topicName;

    @Column(name = "topic_percentage_completed")
    private int topicPercentageCompleted;

    @Column(name = "topic_summary")
    private String topicSummary;

    @Column(name = "theory_time")
    private int theoryTime;

    @Column(name = "practical_time")
    private int practicalTime;

    @Column(name = "content")
    private String content;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public Course getCourse() {
		return course;
	}

	public Course setCourse(Course courseId) {
		return this.course = courseId;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getTopicCode() {
		return topicCode;
	}

	public void setTopicCode(String topicCode) {
		this.topicCode = topicCode;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public int getTopicPercentageCompleted() {
		return topicPercentageCompleted;
	}

	public void setTopicPercentageCompleted(int topicPercentageCompleted) {
		this.topicPercentageCompleted = topicPercentageCompleted;
	}

	public String getTopicSummary() {
		return topicSummary;
	}

	public void setTopicSummary(String topicSummary) {
		this.topicSummary = topicSummary;
	}

	public int getTheoryTime() {
		return theoryTime;
	}

	public void setTheoryTime(int theoryTime) {
		this.theoryTime = theoryTime;
	}

	public int getPracticalTime() {
		return practicalTime;
	}

	public void setPracticalTime(int practicalTime) {
		this.practicalTime = practicalTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Topic(int topicId, Course courseId, int orderNum, String topicCode, String topicName,
			int topicPercentageCompleted, String topicSummary, int theoryTime, int practicalTime, String content,
			Date updatedDate, String updatedBy, Date createdDate, String createdBy) {
		super();
		this.topicId = topicId;
		this.course = course;
		this.orderNum = orderNum;
		this.topicCode = topicCode;
		this.topicName = topicName;
		this.topicPercentageCompleted = topicPercentageCompleted;
		this.topicSummary = topicSummary;
		this.theoryTime = theoryTime;
		this.practicalTime = practicalTime;
		this.content = content;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", courseId=" + course + ", orderNum=" + orderNum + ", topicCode="
				+ topicCode + ", topicName=" + topicName + ", topicPercentageCompleted=" + topicPercentageCompleted
				+ ", topicSummary=" + topicSummary + ", theoryTime=" + theoryTime + ", practicalTime=" + practicalTime
				+ ", content=" + content + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}

    // Constructors, getters, setters, and other methods
    
    
}
