package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FoodDto;
import com.example.demo.service.FoodService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodController {

	private final FoodService foodService;

	@GetMapping
	public ResponseEntity<List<FoodDto>> getAllFoods() {
		List<FoodDto> allFoods = foodService.getAllFoods();
		return new ResponseEntity<>(allFoods, HttpStatus.OK);
	}

	@GetMapping("/{foodId}")
	public ResponseEntity<FoodDto> getFood(@PathVariable Long foodId) {
		FoodDto food = foodService.getFood(foodId);
		return new ResponseEntity<>(food, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<FoodDto> createFood(@RequestBody FoodDto foodDto) {
		FoodDto food = foodService.createFood(foodDto);
		return new ResponseEntity<>(food, HttpStatus.OK);
	}

}
