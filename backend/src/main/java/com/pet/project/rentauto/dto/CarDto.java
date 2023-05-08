package com.pet.project.rentauto.dto;

import com.pet.project.rentauto.model.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private String id;
    private String brand;
    private String model;
    private String carUrl;
    private String videoCarUrl;
    private Double price;
    private Integer rent;
    private Integer carAvailable;
    private List<String> reservedCars;
    private CarType carType;
}
