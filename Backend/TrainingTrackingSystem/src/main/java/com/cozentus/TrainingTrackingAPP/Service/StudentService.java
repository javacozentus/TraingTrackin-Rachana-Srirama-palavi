package com.cozentus.TrainingTrackingAPP.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cozentus.TrainingTrackingAPP.model.Student;
import com.cozentus.TrainingTrackingAPP.repository.ProgramRepository;
import com.cozentus.TrainingTrackingAPP.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProgramService programService;

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private ProgramRepository programRepository; // Assuming you have a ProgramRepository

//    public void addStudentWithProgram(Student student, int programId) {
//        // Find the program by its ID
//        Program program = programRepository.findById(programId).orElse(null);
//
//        if (program != null) {
//            student.setProgram(program); // Associate the student with the program
//            studentRepository.save(student); // Save the student with the associated program
//        } else {
//            // Handle the case where the program with the given ID does not exist.
//            // You can throw an exception or perform error handling as needed.
//        }
//    }
	List<Student> uniqueList = new ArrayList<Student>();
	List<Student> duplicateStudent = new ArrayList<Student>();
//	for retriving 
	public List<Student> GetAllStudent(){
		this.uniqueList.clear();		
		this.duplicateStudent= studentRepository.findAll();		
		for (Student student : duplicateStudent) {
		    boolean isStudentNameUnique = true;
		    for (Student existingStudent : uniqueList) {
		        if (student.getStudentName().equals(existingStudent.getStudentName())) {
		            // If a course with the same name already exists, mark it as not unique
		            isStudentNameUnique = false;
		            break;
		        }
		    }

		    if (isStudentNameUnique) {
		        this.uniqueList.add(student);
		    }
		}
		
		return this.uniqueList;
	}
	
	public Integer findStudentIdbyStudentName(String Studentname) {
		this.GetAllStudent();
	    for (Student student : uniqueList) {
	        if (Studentname.equals(student.getStudentName())) {
	            return student.getStudentId();
	        }
	    }
	    return null; // Return null if the course with the given name is not found
	}
	
	
	
	public Integer findStudentIdbyStudentCode(String StudentCode) {
		this.GetAllStudent();
	    for (Student student : uniqueList) {
	        if (StudentCode.equals(student.getStudentCode())) {
	            return student.getStudentId();
	        }
	    }
	    return null; // Return null if the course with the given name is not found
	}
	
	
	public void deleteStudent(String StudentCode) {
	GetAllStudent();
		
	    for (int i=0;i<duplicateStudent.size();i++) {
	    	
	        if (StudentCode.equals(duplicateStudent.get(i).getStudentCode())) {
	        	
//	        	System.out.println(uniqueList);
//	        	   System.out.println(i);
//	        	   System.out.println(findStudentIdbyStudentCode(duplicateStudent.get(i).getStudentCode()));
	           studentRepository.deleteById(duplicateStudent.get(i).getStudentId()); 
	        }
	    }
	    GetAllStudent();
	   // Return null if the course with the given name is not found
	   
	}


    public Student addStudent(Student student) {
    	StringBuilder randomChars = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        StringBuilder randomNumber = new StringBuilder();
        String numbers = "1234567890";

        for (int i = 0; i < 4; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            randomChars.append(characters.charAt(randomIndex));
            
            int randomIndex1 = (int) (Math.random() * numbers.length());
            randomNumber.append(numbers.charAt(randomIndex1));
        }

		
        String password = "Student@"+randomChars.toString()+"@"+randomNumber.toString();
        courseService.sendEmail("javatrainees2@gmail.com","Student Name : " +student.getStudentName()+"\n"+"UserName: "+ student.getStudentEmail()+"\n"+"password: "+password,"Login Credentials for Student..");
		
        return studentRepository.save(student); 
    }
    
//    public Student addStudentWithProgram(StudentProgram studentProgram) {
//        Student student = new Student();
//        student.setStudentName(studentProgram.getStudentName());
//        student.setStudentEmail(studentProgram.getStudentEmail());
//
//        // Create and set the associated program
//        Program program = new Program();
//        program.setProgramid(studentProgram.getProgramid());
//        student.setProgram(program);
//
//        return studentRepository.save(student);
//    }
//   public Student addStudents(Student student) {
//        // Add validation and error handling as needed
//        if (student.getProgram() == null) {
//            // Handle the case where the program is not provided.
//            // You can return an error or throw an exception as per your requirement.
//            return null;
//        }
//        
//        // You can perform additional validation here.
//
//        // Save the student to the database
//        return studentRepository.save(student);
//    }
    
    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
    
    public Student updateStudent(String StudentCode, Student updatedStudent) {
    	
    	List<Student> existingStudent = studentRepository.findByStudentCode(StudentCode);
//    	System.out.println(existingStudent);
    	
    	for(int i=0;i<existingStudent.size();i++) {

            Student student = existingStudent.get(i);
            System.out.println(i);
            
            // Update the fields of the existing student with the values from updatedStudent
     
                student.setStudentCode(updatedStudent.getStudentCode());            
                student.setStudentName(updatedStudent.getStudentName());
                student.setStudentEmail(updatedStudent.getStudentEmail());
           
       studentRepository.save(student);
    	}
    	
    	  this.GetAllStudent();
            return null; 
          
    }
    public List<String> findStudentNamesByprogramcode(String programcode) {
        List<Student> students = studentRepository.findStudentsByprogramcode(programcode);
        return students.stream()
                .map(Student::getStudentName) // Extract student names
                .collect(Collectors.toList());
    }
  

}

