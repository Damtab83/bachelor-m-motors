package com.damtab.m_motors.repository;

import com.damtab.m_motors.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
