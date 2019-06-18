package com.woniu.dorm.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ImgPath {
	
	public static String imgpath(MultipartFile imgFile) throws IllegalStateException, IOException {
		String imgpath="";
		String path = "D:\\images";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		String filename = imgFile.getOriginalFilename();
		
		filename=UUID.randomUUID().toString()+filename; 
		imgpath=filename;
	
		
		filename=path+File.separator+filename;
		
		File file2 =new File(filename);
		imgFile.transferTo(file2);
		return imgpath;
	}

}
