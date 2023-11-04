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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cozentus.TrainingTrackingAPP.Service.ProgramService;
import com.cozentus.TrainingTrackingAPP.Service.StudentService;
import com.cozentus.TrainingTrackingAPP.model.Student;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProgramService programService;


    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.GetAllStudent();
    }
    
    
//    @PostMapping("/add")
//    public ResponseEntity<String> addStudentWithPrograms(
//            @RequestBody Student student,
//            @RequestParam Integer programId
//    ) {
//        studentService.addStudentWithProgram(student, programId);
//        return new ResponseEntity<>("Student added successfully with Program ID: " + programId, HttpStatus.CREATED);
//    }
    
//    @PostMapping("/addstudent")
//    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
//        Student createdStudent = studentService.addStudent(student);
//        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
//    }
//    
	/*
	 * @PostMapping("/addStudentWithProgram") public ResponseEntity<Student>
	 * addStudentWithProgram(@RequestBody StudentProgram studentProgram) { Student
	 * createdStudent = studentService.addStudentWithProgram(studentProgram); if
	 * (createdStudent != null) { return new ResponseEntity<>(createdStudent,
	 * HttpStatus.CREATED); } else { return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
    
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        // Set the program to null to avoid adding a program ID.
        student.setProgram(null);

        Student createdStudent = studentService.addStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable int studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        @PutMapping("/{studentCode}")
        public ResponseEntity<Student> updateStudent(@PathVariable String studentCode, @RequestBody Student updatedStudent) {
            Student updated = studentService.updateStudent(studentCode, updatedStudent);
            if (updated != null) {
                return new ResponseEntity<>(updated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        // Delete (DELETE) - Delete a student by ID
        @DeleteMapping("/{studentCode}")
        public ResponseEntity<String> deleteStudent(@PathVariable String studentCode) {
            studentService.deleteStudent(studentCode);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        }
        
    }
