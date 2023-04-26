package com.kh.app.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploader {
	
	public static AttachmentVo saveFile(String path , Part f) throws Exception {
		String randomName = UUID.randomUUID().toString();
		String originName = f.getSubmittedFileName();
		String ext = originName.substring( originName.lastIndexOf(".") ); 
		String changeName = randomName + ext;
		File target = new File(path + changeName);
		
		
		try (
				FileOutputStream fos = new FileOutputStream(target);
				InputStream is = f.getInputStream();
			) 
		{
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = is.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
		}
		
		AttachmentVo vo = new AttachmentVo();
		vo.setOriginName(originName);
		vo.setChangeName(changeName);
		return vo;
	}//method

}//class
