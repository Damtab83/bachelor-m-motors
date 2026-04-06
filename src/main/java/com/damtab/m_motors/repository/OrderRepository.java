package com.damtab.m_motors.repository;

import com.damtab.m_motors.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
