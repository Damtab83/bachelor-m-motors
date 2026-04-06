package com.damtab.m_motors.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TestingDriving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testingDriving_id;

    private LocalDateTime testDate;
    private Boolean confirmed;
}
