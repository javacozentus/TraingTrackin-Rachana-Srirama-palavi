package com.cozentus.TrainingTrackingAPP.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
 
@Entity
@Table(name = "credentials")
public class Credentials {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int credentialId;
 
    @Column(name = "user_id")
    private String userId;
 
    private String password;
 
    private String role;
 
    @Temporal(TemporalType.DATE)
    @Column(name = "modified_date")
    private Date modifiedDate;
 
    @Column(name = "updated_by", length = 30)
    private String updatedBy;
 
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;
 
    @Column(name = "created_by", length = 30)
    private String createdBy;
 
	public int getCredentialId() {
		return credentialId;
	}
 
	public void setCredentialId(int credentialId) {
		this.credentialId = credentialId;
	}
 
	public String getUserId() {
		return userId;
	}
 
	public void setUserId(String userId) {
		this.userId = userId;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public String getRole() {
		return role;
	}
 
	public void setRole(String role) {
		this.role = role;
	}
 
	public Date getModifiedDate() {
		return modifiedDate;
	}
 
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
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
 
	@Override
	public String toString() {
		return "credentials [credentialId=" + credentialId + ", userId=" + userId + ", password=" + password + ", role="
				+ role + ", modifiedDate=" + modifiedDate + ", updatedBy=" + updatedBy + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", getCredentialId()=" + getCredentialId() + ", getUserId()="
				+ getUserId() + ", getPassword()=" + getPassword() + ", getRole()=" + getRole() + ", getModifiedDate()="
				+ getModifiedDate() + ", getUpdatedBy()=" + getUpdatedBy() + ", getCreatedDate()=" + getCreatedDate()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
 
	public Credentials(int credentialId, String userId, String password, String role, Date modifiedDate,
			String updatedBy, Date createdDate, String createdBy) {
		super();
		this.credentialId = credentialId;
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.modifiedDate = modifiedDate;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
 
	public Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}
 
    
    
}
 
 
