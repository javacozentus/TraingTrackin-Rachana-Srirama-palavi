package com.cozentus.TrainingTrackingAPP.Controller;
 
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
 
import com.cozentus.TrainingTrackingAPP.Service.FileUploadService;
 
@RestController
@CrossOrigin("*")
public class FileController {
	@Autowired
	private FileUploadService fileUploadService;
@PostMapping("/uploadfile")
	public String uploadFile(@RequestParam("file")MultipartFile file)
	{
	try {
	
	if(file.isEmpty())
	{
		return "file not found";
	}
	
	//code for uploading file
	
	boolean status = fileUploadService.uploadFile(file);
	if(fileUploadService.uploadFile(file)) {
		return "file is uploaded successfully";
	}
	}
	
	
	catch(Exception e){
		
		e.printStackTrace();
		return "exception found";
	}
	return "file is uploaded successfully";
	
	}
}