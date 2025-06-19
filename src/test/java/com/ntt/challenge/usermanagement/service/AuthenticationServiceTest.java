package com.ntt.challenge.usermanagement.service;

import com.ntt.challenge.usermanagement.client.DummyJsonClient;
import com.ntt.challenge.usermanagement.dto.AuthRequest;
import com.ntt.challenge.usermanagement.dto.AuthResponse;
import com.ntt.challenge.usermanagement.model.LoginLog;
import com.ntt.challenge.usermanagement.repository.LoginLogRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class AuthenticationServiceTest {

    @MockBean
    private DummyJsonClient dummyJsonClient;

    @MockBean
    private LoginLogRepository loginLogRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Test
    void testAuthenticate_Success() {
        AuthRequest request = new AuthRequest("emilys", "emilyspass");

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", 1);
        userMap.put("username", "emilys");

        AuthResponse mockResponse = new AuthResponse("token123", "refresh123", "emilys","emily.johnson@x.dummyjson.com","Emily","Johnson","female","https://dummyjson.com/icon/emilys/128",1);

        when(dummyJsonClient.login(request)).thenReturn(ResponseEntity.ok(mockResponse));
        when(loginLogRepository.save(any(LoginLog.class))).thenReturn(new LoginLog());

        AuthResponse result = authenticationService.authenticate(request);

        assertNotNull(result);
        assertEquals("token123", result.accessToken());
        verify(loginLogRepository, times(1)).save(any(LoginLog.class));
    }
}