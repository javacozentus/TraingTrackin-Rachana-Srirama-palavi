package com.cozentus.TrainingTrackingAPP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cozentus.TrainingTrackingAPP.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>{
	
	public Teacher findByTeacherid(Integer teacherid);
	public Teacher findByTeachername(String Teachername);
	
}
