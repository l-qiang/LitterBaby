package com.github.xuexi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoXuexiController {
	
	@Autowired
	private AutoXuexi autoXuexi;
	
	@GetMapping("/start")
	public void start() {
		autoXuexi.start();
	}
}
