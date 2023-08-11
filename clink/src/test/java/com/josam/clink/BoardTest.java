package com.josam.clink;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.josam.clink.communityManager.CommunityManagerService;
import com.josam.clink.communityPost.CommunityPostVO;
import com.josam.clink.security.APIUser;

@SpringBootTest
@AutoConfigureMockMvc
public class BoardTest {

	@Autowired
	CommunityManagerService communityManagerService;

	
}
