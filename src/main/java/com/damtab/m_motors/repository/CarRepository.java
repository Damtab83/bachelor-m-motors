package com.damtab.m_motors.repository;

import com.damtab.m_motors.pojo.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
