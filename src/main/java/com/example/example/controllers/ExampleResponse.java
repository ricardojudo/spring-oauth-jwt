package com.example.example.controllers;

import java.util.Random;

import lombok.Data;

@Data
public class ExampleResponse {

	private final String message;
	private final String status;

	public static ExampleResponse buildRandom() {
		Random random = new Random();
		return new ExampleResponse(String.format("Message %s", random.nextFloat()), String.valueOf(random.nextLong()));
	}

}
