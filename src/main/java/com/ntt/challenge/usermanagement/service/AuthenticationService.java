package com.ntt.challenge.usermanagement.service;

import com.ntt.challenge.usermanagement.client.DummyJsonClient;
import com.ntt.challenge.usermanagement.dto.AuthRequest;
import com.ntt.challenge.usermanagement.dto.AuthResponse;
import com.ntt.challenge.usermanagement.model.LoginLog;
import com.ntt.challenge.usermanagement.repository.LoginLogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class AuthenticationService {

    private final DummyJsonClient dummyJsonClient;
    private final LoginLogRepository loginLogRepository;

    public AuthenticationService(DummyJsonClient dummyJsonClient, LoginLogRepository loginLogRepository) {
        this.dummyJsonClient = dummyJsonClient;
        this.loginLogRepository = loginLogRepository;
    }

    public AuthResponse authenticate(AuthRequest authRequest) {
        ResponseEntity<AuthResponse> response = dummyJsonClient.login(authRequest);

        if (response.getStatusCode().is2xxSuccessful()) {
            AuthResponse authResponse = response.getBody();
            saveLoginLog(authRequest.username(), authResponse.accessToken(), authResponse.refreshToken());
            return authResponse;
        }

        throw new RuntimeException("Authentication failed");
    }

    public Map<String, Object> getAuthenticatedUser(String accessToken) {
        ResponseEntity<Map<String, Object>> response = dummyJsonClient.getMe("Bearer " + accessToken);
        return response.getBody();
    }

    private void saveLoginLog(String username, String accessToken, String refreshToken) {
        LoginLog log = new LoginLog();
        log.setUsername(username);
        log.setAccessToken(accessToken);
        log.setRefreshToken(refreshToken);
        log.setLoginTime(LocalDateTime.now());
        loginLogRepository.save(log);
    }

    public List<Map<String, Object>> getAllUsers() {
        return dummyJsonClient.getAllUsers().getBody().getUsers();
    }
}