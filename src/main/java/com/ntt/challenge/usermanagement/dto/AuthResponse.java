package com.ntt.challenge.usermanagement.dto;

import java.util.Map;

public record AuthResponse(String accessToken, String refreshToken, String username, String email, String firstName, String lastName, String gender, String image, int id) {}