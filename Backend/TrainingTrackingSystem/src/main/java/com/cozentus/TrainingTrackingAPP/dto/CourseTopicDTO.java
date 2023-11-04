package com.cozentus.TrainingTrackingAPP.dto;


import java.util.List;

import com.cozentus.TrainingTrackingAPP.model.Topic;

public class CourseTopicDTO {
	
	
	
	 private int courseid;
	    private List<Topic> topics;
	    public CourseTopicDTO(int courseid, List<Topic> topics, int topicId, String topicCode,
				String topicName, int topicPercentageCompleted, String topicSummary, int theoryTime, int practicalTime,
				String content, String courseCode, String courseName,int orderNum) {
			super();
			this.courseid = courseid;
			this.topics = topics;
			this.topicId = topicId;
	
			this.topicCode = topicCode;
			this.topicName = topicName;
			this.topicPercentageCompleted = topicPercentageCompleted;
			this.topicSummary = topicSummary;
			this.theoryTime = theoryTime;
			this.practicalTime = practicalTime;
			this.content = content;
			this.orderNum=orderNum;
			
		}
		public int getTopicId() {
			return topicId;
		}
		public void setTopicId(int topicId) {
			this.topicId = topicId;
		}
		public int getCourseId() {
			return courseId;
		}
		public void setCourseId(int courseId) {
			this.courseId = courseId;
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
		
		private int topicId;
	    private int courseId;
	    private String topicCode;
	    private String topicName;
	    private int topicPercentageCompleted;
	    private String topicSummary;
	    private int theoryTime;
	    private int practicalTime;
	    private String content;
	    private int orderNum;
	   
		public int getOrderNum() {
			return orderNum;
		}
		public void setOrderNum(int orderNum) {
			this.orderNum = orderNum;
		}
		public int getCourseid() {
			return courseid;
		}
		public void setCourseid(int courseid) {
			this.courseid = courseid;
		}
		public List<Topic> getTopics() {
			return topics;
		}
		public void setTopics(List<Topic> topics) {
			this.topics = topics;
		}
		public CourseTopicDTO(int courseid, List<Topic> topics) {
			super();
			this.courseid = courseid;
			this.topics = topics;
		}
		public CourseTopicDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "CourseTopicDTO [courseId=" + courseid + ", topics=" + topics + "]";
		}
	    
	
}
