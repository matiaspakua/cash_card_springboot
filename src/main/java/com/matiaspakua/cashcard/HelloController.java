package com.matiaspakua.cashcard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value = "/hello")
	public String HelloWorld() {
		return "Welcome to Springboot";
		
	}
}
