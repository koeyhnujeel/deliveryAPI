package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Food;
import com.example.demo.dto.FoodDto;
import com.example.demo.repository.FoodRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

	private final FoodRepository foodRepository;

	@Override
	public List<FoodDto> getAllFoods() {
		List<Food> all = foodRepository.findAll();
		if (all.isEmpty()) {
			throw new EntityNotFoundException("등록된 음식이 없습니다.");
		}

		List<FoodDto> allFoods = new ArrayList<>();
		for (Food food : all) {
			FoodDto foodDto = new FoodDto();
			BeanUtils.copyProperties(food, foodDto);
			allFoods.add(foodDto);
		}

		return allFoods;
	}

	@Override
	public FoodDto getFood(Long foodId) {
		Optional<Food> res = foodRepository.findById(foodId);
		if (res.isEmpty()) {
			throw new  IllegalArgumentException("존재하지 않는 음식입니다");
		}

		Food food = res.get();
		FoodDto foodDto = new FoodDto();
		BeanUtils.copyProperties(food, foodDto);

		return foodDto;
	}

	@Override
	public FoodDto createFood(FoodDto foodDto) {
		Food food = new Food();
		BeanUtils.copyProperties(foodDto, food);

		Food savedFood = foodRepository.save(food);
		BeanUtils.copyProperties(savedFood, foodDto);

		return foodDto;
	}
}
