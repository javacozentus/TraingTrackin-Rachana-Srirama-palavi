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
@Table(name="teacher")
public class Teacher {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="teacher_id")
		private int teacherid;
	    
	    @Column(name="teacher_code")
		private String teachercode;
	    @Column(name="teacher_name")
		private String teachername;
	    @Column(name="teacher_email")
		private String teacheremail;
		
	    @Column(name="created_by")
	    private String createdby;
	    
	    @Column(name="updated_by")
	    private String updatedby;
	    
	    @Column(name="created_date")
	    private Date createddate;
	    
	    @Column(name="updated_date")
	    private Date updateddate;
	    
	

		public int getTeacherid() {
			return teacherid;
		}

		public void setTeacherid(int teacherid) {
			this.teacherid = teacherid;
		}

		public String getTeachercode() {
			return teachercode;
		}

		public void setTeachercode(String teachercode) {
			this.teachercode = teachercode;
		}

		public String getTeachername() {
			return teachername;
		}

		public void setTeachername(String teachername) {
			this.teachername = teachername;
		}

		public String getTeacheremail() {
			return teacheremail;
		}

		public void setTeacheremail(String teacheremail) {
			this.teacheremail = teacheremail;
		}

		public String getCreatedby() {
			return createdby;
		}

		public void setCreatedby(String createdby) {
			this.createdby = createdby;
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

		public Date getUpdateddate() {
			return updateddate;
		}

		public void setUpdateddate(Date updateddate) {
			this.updateddate = updateddate;
		}
		 @OneToMany(mappedBy = "teacher")	
		 private List<TeacherCourse> teacherCourse;
		
		@Override
		public String toString() {
			return "Teacher [teacherid=" + teacherid + ", teachercode=" + teachercode + ", teachername=" + teachername
					+ ", teacheremail=" + teacheremail + ", createdby=" + createdby + ", updatedby=" + updatedby
					+ ", createddate=" + createddate + ", updateddate=" + updateddate + " ]";
		}
		
}
