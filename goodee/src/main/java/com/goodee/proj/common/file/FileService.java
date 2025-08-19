package com.goodee.proj.common.file;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileService {
	public final int account = 1;
	public final int animal = 2;
	public final int product = 3;
	
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
}
