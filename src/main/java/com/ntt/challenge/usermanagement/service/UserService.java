package com.ntt.challenge.usermanagement.service;

import com.ntt.challenge.usermanagement.client.DummyJsonClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final DummyJsonClient dummyJsonClient;

    public UserService(DummyJsonClient dummyJsonClient) {
        this.dummyJsonClient = dummyJsonClient;
    }

    public List<Map<String, Object>> getAllUsers() {
        return dummyJsonClient.getAllUsers().getBody().getUsers();
    }
}