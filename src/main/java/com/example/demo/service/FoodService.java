package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FoodDto;

public interface FoodService {
	List<FoodDto> getAllFoods();

	FoodDto getFood(Long foodId);

	FoodDto createFood(FoodDto foodDto);
}
