package com.josam.clink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.josam.clink.communityManager.CommunityManagerService;

@SpringBootTest
@AutoConfigureMockMvc
public class BoardTest {

	@Autowired
	CommunityManagerService communityManagerService;
	
}
