package com.cozentus.TrainingTrackingAPP.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cozentus.TrainingTrackingAPP.model.Credentials;
 
@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Integer>{
	
	
	public Credentials findByUserId(String userId);
 
}