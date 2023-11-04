package com.cozentus.TrainingTrackingAPP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cozentus.TrainingTrackingAPP.model.Program;
import com.cozentus.TrainingTrackingAPP.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    // You can add custom query methods here if needed
	
	
	public Student findByStudentName(String StudentName);
	
	 public Student findByStudentId(Integer studentid);
	 
//	 public Student findByStudentCode(String StudetCode);
	public  List<Student> findByStudentCode(String StudentCode);
	
	 public List<Student> findByProgram(Program programname);

	 @Query("SELECT s FROM Student s WHERE s.program.programcode = :programcode")
	    List<Student> findStudentsByprogramcode(@Param("programcode") String programcode);
}
