package com.goodee.proj.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer {
	@Value("${upload.base.directory}")
	private String baseDir;
	@Value("${file.view.url}")
	private String fileViewURL;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(fileViewURL).addResourceLocations("file:" + baseDir);
	}
	
}
