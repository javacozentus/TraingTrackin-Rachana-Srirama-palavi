package com.cozentus.TrainingTrackingAPP.Controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.cozentus.TrainingTrackingAPP.Service.EvaluationNameService;
import com.cozentus.TrainingTrackingAPP.dto.EvaluationstudentDTO;
import com.cozentus.TrainingTrackingAPP.model.EvaluationName;
 
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class EvaluationNameController {
 
    @Autowired
    private EvaluationNameService evaluationNameService;
 
    @GetMapping("/evaluationsexam")
    public List<EvaluationName> getAllEvaluations() {
        return evaluationNameService.getAllEvaluations();
    }
 
    @GetMapping("/evaluationsassignment")
    public List<EvaluationName> getAllEvaluations1() {
        return evaluationNameService.getAllEvaluations1();
    }
 
    @GetMapping("/evaluations/{id}")
    public ResponseEntity<EvaluationName> getEvaluationNameById(@PathVariable int id) {
        EvaluationName evaluationName = evaluationNameService.getEvaluationNameById1(id);
        if (evaluationName != null) {
            return new ResponseEntity<>(evaluationName, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 
    @PostMapping("/evaluationsexam")
    public ResponseEntity<EvaluationName> saveEvaluation(@RequestBody EvaluationName evaluationName) {
        EvaluationName savedEvaluationName = evaluationNameService.saveEvaluation(evaluationName);
        return new ResponseEntity<>(savedEvaluationName, HttpStatus.CREATED);
    }
 
    @PostMapping("/evaluationsassignment")
    public ResponseEntity<EvaluationName> saveEvaluation1(@RequestBody EvaluationName evaluationName) {
        EvaluationName savedEvaluationName = evaluationNameService.saveEvaluation1(evaluationName);
        return new ResponseEntity<>(savedEvaluationName, HttpStatus.CREATED);
    }
 
    @DeleteMapping("/evaluationsexam/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable int id) {
        evaluationNameService.deleteEvaluation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
 
    @DeleteMapping("/evaluationsassignment/{id}")
    public ResponseEntity<Void> deleteEvaluation1(@PathVariable int id) {
        evaluationNameService.deleteEvaluation1(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
 
    @PutMapping("/evaluationsexam/{id}")
    public ResponseEntity<EvaluationName> updateEvaluation(@PathVariable int id, @RequestBody EvaluationName updatedEvaluation) {
        updatedEvaluation.setId(id);
 
        EvaluationName updatedEntity = evaluationNameService.updateEvaluation(updatedEvaluation);
 
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }
    
    @PutMapping("/evaluationsassignment/{id}")
    public ResponseEntity<EvaluationName> updateEvaluation1(@PathVariable int id, @RequestBody EvaluationName updatedEvaluation) {
        updatedEvaluation.setId(id);
 
        EvaluationName updatedEntity = evaluationNameService.updateEvaluation1(updatedEvaluation);
 
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }
    
    
    @PostMapping("/examstudentmarks")
    public ResponseEntity<String> createExam(@RequestBody EvaluationstudentDTO  evaluationdStudentDto) {
    	evaluationNameService.saveEvaluations(evaluationdStudentDto);
        return ResponseEntity.ok("Exam created successfully.");
    }
    
 
}
 