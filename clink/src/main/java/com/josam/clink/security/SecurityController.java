package com.josam.clink.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = {"http://172.19.48.1:5500/"})
public class SecurityController {
	
//	@ApiOperation("Sample GET doA")
	@GetMapping("/doA")
	public List<String> doA() {
		return Arrays.asList("AAA","BBB","CCC");
	}

}
