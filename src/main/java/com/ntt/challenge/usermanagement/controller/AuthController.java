package com.ntt.challenge.usermanagement.controller;

import com.ntt.challenge.usermanagement.dto.AuthRequest;
import com.ntt.challenge.usermanagement.dto.AuthResponse;
import com.ntt.challenge.usermanagement.service.AuthenticationService;
import com.ntt.challenge.usermanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/me")
    public ResponseEntity<?> me(@RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(authenticationService.getAuthenticatedUser(payload.get("accessToken")));
    }
}