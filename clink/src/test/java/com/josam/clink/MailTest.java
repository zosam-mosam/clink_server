package com.josam.clink;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.josam.clink.user.MailService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MailTest {

    @Mock
    private MailService mailService;

    @Test
    void testSendMail() {
        // 메서드 호출
        sendMail("soieu9898@gmail.com");

        // 메서드 호출 검증
        verify(mailService, times(1)).sendMail("soieu9898@gmail.com");
    }

    private void sendMail(String email) {
        // 메일 전송 로직 구현
        mailService.sendMail(email);
    }
}

