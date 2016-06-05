package com.example.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrameController {
	
	@Scheduled(cron="0/5 * *  * * ? ")
	public void printMsg() {
		System.out.println("testa");
	}
	
	@RequestMapping(value="/index")
	public String doIndex() {
		return "index";
	}
}
