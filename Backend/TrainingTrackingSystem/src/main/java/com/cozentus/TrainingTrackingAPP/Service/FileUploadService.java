package com.cozentus.TrainingTrackingAPP.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadService {
public final String 	uploadDir ="D:\\CozentusBackendProject\\TrainingTrackingSystem\\src\\main\\resources\\static\\images";

public boolean uploadFile(MultipartFile multiPartFile)
{
	boolean multipartfile= false;
	try {
		Files.copy(multiPartFile.getInputStream(),Paths.get(uploadDir+File.separator+multiPartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
	}
	catch(Exception e){
		
	}
	return multipartfile;
}
	

}