package com.cozentus.TrainingTrackingAPP.Service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cozentus.TrainingTrackingAPP.dto.EvaluationstudentDTO;
import com.cozentus.TrainingTrackingAPP.model.EvaluationName;
import com.cozentus.TrainingTrackingAPP.model.Student;
import com.cozentus.TrainingTrackingAPP.repository.EvaluationNameRepository;
import com.cozentus.TrainingTrackingAPP.repository.StudentRepository;
 
@Service
public class EvaluationNameService{
 
    @Autowired
    private EvaluationNameRepository evaluationNameRepository;
    
    @Autowired
    private StudentRepository studentRepository;
 
    public List<EvaluationName> getAllEvaluations() {
        return evaluationNameRepository.findAll();
    }
    
    public List<EvaluationName> getAllEvaluations1() {
        return evaluationNameRepository.findAll();
    }
 
    
    public EvaluationName getEvaluationNameById1(int id) {
        return evaluationNameRepository.findById(id).orElse(null);
    }
 
    public EvaluationName saveEvaluation(EvaluationName evaluationName) {
    	evaluationName.setType("Exam");
        return evaluationNameRepository.save(evaluationName);
    }
    
    public EvaluationName saveEvaluation1(EvaluationName evaluationName) {
    	evaluationName.setType("Assignment");
        return evaluationNameRepository.save(evaluationName);
    }
    
    public void deleteEvaluation(int id) {
        evaluationNameRepository.deleteById(id);
    }
    
    
    
    public void deleteEvaluation1(int id) {
        evaluationNameRepository.deleteById(id);
    }
    
    public EvaluationName updateEvaluation(EvaluationName updatedEvaluation) {
        // Check if the evaluation with the provided ID exists
        EvaluationName existingEvaluation = evaluationNameRepository.findById(updatedEvaluation.getId())
                .orElseThrow(() -> new IllegalArgumentException("Evaluation with ID " + updatedEvaluation.getId() + " not found"));
 
        // Update the fields with the new values
        existingEvaluation.setCourse(updatedEvaluation.getCourse());
        existingEvaluation.setTeacher(updatedEvaluation.getTeacher());
        existingEvaluation.setBatch(updatedEvaluation.getBatch());
        existingEvaluation.setStudent(updatedEvaluation.getStudent());
        existingEvaluation.setType(updatedEvaluation.getType());
        existingEvaluation.setSubmissionDate(updatedEvaluation.getSubmissionDate());
        existingEvaluation.setEvaluationName(updatedEvaluation.getEvaluationName());
        existingEvaluation.setTotalMarks(updatedEvaluation.getTotalMarks());
        existingEvaluation.setMarksSecured(updatedEvaluation.getMarksSecured());
        existingEvaluation.setCreatedDate(updatedEvaluation.getCreatedDate());
        existingEvaluation.setCreatedBy(updatedEvaluation.getCreatedBy());
        existingEvaluation.setUpdatedDate(updatedEvaluation.getUpdatedDate());
        existingEvaluation.setUpdatedBy(updatedEvaluation.getUpdatedBy());
       
 
        // Save the updated evaluation
        return evaluationNameRepository.save(existingEvaluation);
    }
    public EvaluationName updateEvaluation1(EvaluationName updatedEvaluation) {
        // Check if the evaluation with the provided ID exists
        EvaluationName existingEvaluation = evaluationNameRepository.findById(updatedEvaluation.getId())
                .orElseThrow(() -> new IllegalArgumentException("Evaluation with ID " + updatedEvaluation.getId() + " not found"));
 
        // Update the fields with the new values
        existingEvaluation.setCourse(updatedEvaluation.getCourse());
        existingEvaluation.setTeacher(updatedEvaluation.getTeacher());
        existingEvaluation.setBatch(updatedEvaluation.getBatch());
        existingEvaluation.setStudent(updatedEvaluation.getStudent());
        existingEvaluation.setType(updatedEvaluation.getType());
        existingEvaluation.setSubmissionDate(updatedEvaluation.getSubmissionDate());
        existingEvaluation.setEvaluationName(updatedEvaluation.getEvaluationName());
        existingEvaluation.setTotalMarks(updatedEvaluation.getTotalMarks());
        existingEvaluation.setMarksSecured(updatedEvaluation.getMarksSecured());
        existingEvaluation.setCreatedDate(updatedEvaluation.getCreatedDate());
        existingEvaluation.setCreatedBy(updatedEvaluation.getCreatedBy());
        existingEvaluation.setUpdatedDate(updatedEvaluation.getUpdatedDate());
        existingEvaluation.setUpdatedBy(updatedEvaluation.getUpdatedBy());
 
        // Save the updated evaluation
        return evaluationNameRepository.save(existingEvaluation);
    }
    
    public void saveEvaluations(EvaluationstudentDTO evaluationStudentDto) {
        for (int i = 0; i < evaluationStudentDto.getStudentNames().length; i++) {
            Student student = new Student();
            student.setStudentName(evaluationStudentDto.getStudentNames()[i]);
            student = studentRepository.save(student);
 
            EvaluationName evaluation = new EvaluationName();
            evaluation.setEvaluationName(evaluationStudentDto.getExamName());
            evaluation.setStudent(student);
            evaluation.setMarksSecured(evaluationStudentDto.getMarks()[i]);
 
            evaluationNameRepository.save(evaluation);
        }
    
    }
 
    
	
}
 