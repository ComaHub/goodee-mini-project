package com.goodee.proj.common.file;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileDTO {
	private Long attachNumber;
	private Long keyData;
	private Integer type;
	private String origin;
	private String saved;
}
