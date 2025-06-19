package com.ntt.challenge.usermanagement.repository;

import com.ntt.challenge.usermanagement.model.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginLogRepository extends JpaRepository<LoginLog, UUID> {}