package com.josam.clink;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.josam.clink.communityManager.CommunityManagerService;

import com.josam.clink.communityPost.CommunityPostVO;

@SpringBootTest
@AutoConfigureMockMvc
public class BoardTest {

	@Autowired
	CommunityManagerService communityManagerService;
	
}
