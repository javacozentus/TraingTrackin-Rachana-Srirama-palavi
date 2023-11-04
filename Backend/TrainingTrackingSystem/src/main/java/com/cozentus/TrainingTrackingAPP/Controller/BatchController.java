package com.cozentus.TrainingTrackingAPP.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cozentus.TrainingTrackingAPP.Service.BatchService;
import com.cozentus.TrainingTrackingAPP.dto.BatchProgramStudentDTO;
import com.cozentus.TrainingTrackingAPP.dto.TeacherCourseDTO;
import com.cozentus.TrainingTrackingAPP.model.Batch;

@CrossOrigin(allowedHeaders = "*" , origins = "*")
@RestController
public class BatchController {
 
    @Autowired
    private BatchService batchService;
 
    @GetMapping("/batch")
    public List<Batch> getAllBatches() {
        return batchService.getAllBatches();
    }
     
 
    public Batch getBatchById(@PathVariable int id) {
        return batchService.getBatchById(id);
    }
 
    @PostMapping("/batch")
    public void saveBatch(@RequestBody BatchProgramStudentDTO batchprogramstudentdto) {
        batchService.saveBatch(batchprogramstudentdto);
    }
    
    @PostMapping("batch/student")
    public void saveBatchStudentData(@RequestBody BatchProgramStudentDTO batchprogramstudentdto) {
    	batchService.SaveBatchStudent(batchprogramstudentdto);
    }
    
    @PostMapping("batch/teacher")
    public void saveBatchTeacherData(@RequestBody TeacherCourseDTO teachercoursedto) {
    	batchService.saveBatchTeacher(teachercoursedto);
    }
    
//    @PutMapping("/apibatches/{id}")
//    public void updateBatch(@PathVariable int id, @RequestBody Batch updatedBatch) {
//        Batch existingBatch = batchService.getBatchById(id);
// 
//        if (existingBatch != null) {
//            existingBatch.setBatchcode(updatedBatch.getBatchcode());
//            existingBatch.setBatchname(updatedBatch.getBatchname());
//            existingBatch.setBatchstartdate(updatedBatch.getBatchstartdate());
//            existingBatch.setCreatedby(updatedBatch.getCreatedby());
//            existingBatch.setUpdateddate(new Date()); 
//            existingBatch.setUpdatedby(updatedBatch.getUpdatedby());
// 
//            batchService.saveBatch(existingBatch);  
//        }
//    }
 
    @DeleteMapping("apibatches/{id}")
    public void deleteBatch(@PathVariable int id) {
        batchService.deleteBatch(id);
    }
    
    @PutMapping("/batch/{batchid}")
    public String updateBatch(@PathVariable int batchid,@RequestBody BatchProgramStudentDTO batch) {
    	batchService.EditBatch(batchid,batch);
    	return "updated successfully";
    }
    
    @GetMapping("/exam/get-batches-code-and-name")
    public ResponseEntity<List<String>> getAllBatchCodeAndBatchName() {
              List<String> batchCodeAndBatchNameList = batchService.getAllBatchCodeAndBatchName();
              return ResponseEntity.ok(batchCodeAndBatchNameList);
          }
      
     
      
      @GetMapping("/exam")
      public String getExamMenu() {
          return "exam";
      }
      
      @GetMapping("/start-date/{batchcode}")
      public Date getBatchStartDateBybatchcode(@PathVariable String batchcode) {
          return batchService.getBatchStartDateBybatchcode(batchcode);
      }
      
      @GetMapping("/program-info/{batchcode}")
      public List<Object[]> getProgramInfoBybatchcode(@PathVariable("batchcode") String batchcode) {
          return batchService.findProgramInfoBybatchcode(batchcode);
      }
      
    
    
}
