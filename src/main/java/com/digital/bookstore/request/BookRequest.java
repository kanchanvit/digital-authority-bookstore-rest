package com.digital.bookstore.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
	private Integer id;
	private String name;
	private String description;
	private String author;
	private String classification;
	private Float price;
	private String ISBN;
}
