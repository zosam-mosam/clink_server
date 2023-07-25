package com.josam.clink.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//@CrossOrigin(origins="*")
@Controller
public class TestHello {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		System.out.println("하이");
		return "안녕";
	}
}
