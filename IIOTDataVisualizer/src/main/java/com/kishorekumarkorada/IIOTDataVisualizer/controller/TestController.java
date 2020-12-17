package com.kishorekumarkorada.IIOTDataVisualizer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	
	@RequestMapping("/getDetails")
	public ResponseEntity<String> getTestName() {
		return new ResponseEntity<String>("Hammayyaaa",HttpStatus.OK);
	}
}
