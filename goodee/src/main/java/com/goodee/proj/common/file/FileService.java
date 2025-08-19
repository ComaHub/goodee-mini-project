package com.goodee.proj.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileService {
	public static final int ACCOUNT = 1;
	public static final int ANIMAL = 2;
	public static final int PRODUCT = 3;
	
	@Value("${upload.base.directory}")
	private String dir;
	
	public String getAttachTypeString(int attachType) {
		return switch (attachType) {
			case 1 -> "account";
			case 2 -> "animal";
			case 3 -> "product";
			default -> throw new IllegalArgumentException();
		};
	}
	
	public String saveFile(int attachType, MultipartFile attach) throws Exception {
		File file = new File(dir + getAttachTypeString(attachType));
		if (!file.exists()) file.mkdirs();
		
		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "-" + attach.getOriginalFilename();
		file = new File(file, fileName);
		
		FileCopyUtils.copy(attach.getBytes(), file);
		
		return fileName;
	}

	public void viewFile(FileDTO fileDTO, HttpServletResponse response) throws Exception {
		String filePath = dir + getAttachTypeString(fileDTO.getType());
		File file = new File(filePath, fileDTO.getSaved());
		
		response.setContentLengthLong(file.length());
		String fileName = URLEncoder.encode(fileDTO.getOrigin(), "UTF-8");
		
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + fileName + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		FileInputStream fis = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		try (fis; os) {
			FileCopyUtils.copy(fis, os);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
