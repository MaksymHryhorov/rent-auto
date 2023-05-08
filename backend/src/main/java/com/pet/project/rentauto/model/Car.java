package com.pet.project.rentauto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "Car")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    @Id
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
