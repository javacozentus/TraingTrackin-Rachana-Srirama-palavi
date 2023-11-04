package com.cozentus.TrainingTrackingAPP.model;

public class JwtModel {

	private String Username;
	private String Password;
	public JwtModel(String username, String password) {
		super();
		Username = username;
		Password = password;
	}
	public JwtModel() {
		
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "JwtModel [Username=" + Username + ", Password=" + Password + "]";
	}
	
}
