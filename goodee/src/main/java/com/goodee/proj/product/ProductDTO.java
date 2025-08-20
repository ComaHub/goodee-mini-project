package com.goodee.proj.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {

	private Long productNumber;
	@NotBlank
	private String name;
	@NotBlank
	private String category;
	@NotNull
	private Long amount;
	@NotNull
	private Long price;
}
