package com.digital.bookstore.response;

import java.util.List;

import com.digital.bookstore.request.BookRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class DiscountedPrice {
	
	private Integer bookId;
	private Float discountedPrice;
}
