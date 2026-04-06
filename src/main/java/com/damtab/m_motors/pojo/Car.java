package com.damtab.m_motors.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long car_id;

    @NotBlank
    private String brand;

    private String model;

    private String motorization;
    private Integer kilometer;
    private Integer price;
    private Boolean funding;


    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User userCustomer;

    @OneToMany
    @JoinColumn(name = "imageCar_id")
    private List<ImageCar> images;

    @OneToOne(optional = true)
    @JoinColumn(name = "testDriving_id")
    private TestingDriving testing;


    private boolean availableForBuy;
    private boolean availableForRent;
}
