package com.cozentus.TrainingTrackingAPP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cozentus.TrainingTrackingAPP.model.Batch;



@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {
	public Batch findBybatchcode(String batchcode);
	//@Query("SELECT p.programcode, p.programname FROM Student s INNER JOIN s.program p WHERE s.batchcode = :batchcode")
	@Query("SELECT s.program.programcode, s.program.programname FROM Student s WHERE s.batch.batchcode = :batchcode")
	List<Object[]> findProgramInfoBybatchcode(@Param("batchcode") String batchcode);
	
}
