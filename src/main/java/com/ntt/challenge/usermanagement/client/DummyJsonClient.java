package com.ntt.challenge.usermanagement.client;

import com.ntt.challenge.usermanagement.dto.AuthRequest;
import com.ntt.challenge.usermanagement.dto.AuthResponse;
import com.ntt.challenge.usermanagement.dto.UsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(name = "dummyjson", url = "https://dummyjson.com")
public interface DummyJsonClient {

    @PostMapping("/auth/login")
    ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request);

    @GetMapping("/auth/me")
    ResponseEntity<Map<String, Object>> getMe(@RequestHeader("Authorization") String accessToken);

    @GetMapping("/users")
    ResponseEntity<UsersResponse> getAllUsers();
}