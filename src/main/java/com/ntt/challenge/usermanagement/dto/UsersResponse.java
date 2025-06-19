package com.ntt.challenge.usermanagement.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UsersResponse {
    private List<Map<String, Object>> users;
}
