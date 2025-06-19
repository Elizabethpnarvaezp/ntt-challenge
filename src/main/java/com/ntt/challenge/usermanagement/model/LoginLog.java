package com.ntt.challenge.usermanagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "login_log")
public class LoginLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "username", length = 255, nullable = false)
    private String username;

    @Column(name = "login_time", nullable = false)
    private LocalDateTime loginTime;

    @Column(name = "access_token", columnDefinition = "TEXT", nullable = false)
    private String accessToken;

    @Column(name = "refresh_token", columnDefinition = "TEXT")
    private String refreshToken;
}