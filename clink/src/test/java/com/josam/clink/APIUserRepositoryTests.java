package com.josam.clink;


import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.josam.clink.security.APIUser;
import com.josam.clink.security.APIUserRepository;

import lombok.extern.java.Log;

@SpringBootTest
@Log
public class APIUserRepositoryTests {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private APIUserRepository apiUserRepository;
	
	@Test
	public void testInserts() {
		IntStream.rangeClosed(1,7).forEach(i -> {
			APIUser apiUser = APIUser.builder()
					.mid("t"+i)
					.mpw(passwordEncoder.encode("t"+i))
					.build();
			apiUserRepository.save(apiUser);
		});
	}
}
