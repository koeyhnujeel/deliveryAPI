package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "food", schema = "delivery")
@Setter @Getter
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id", unique = true, nullable = false)
	private Long foodId;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "price", nullable = false)
	private int price;

	/*
	한식, 일식, 양식, 중식
	* */
	@Column(name = "tag", nullable = false)
	private String tag;
}
