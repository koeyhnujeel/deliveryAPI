package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FoodDto {
	private Long foodId;
	private String name;
	private int price;
	private String tag;
}
