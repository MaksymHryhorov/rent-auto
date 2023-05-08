package com.pet.project.rentauto.controller;

import com.pet.project.rentauto.dto.CarDto;
import com.pet.project.rentauto.dto.UploadCarResponse;
import com.pet.project.rentauto.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UploadCarResponse uploadCar(@RequestParam("file") MultipartFile file) {
        return carService.uploadCar(file);
    }

    @PostMapping("/video")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadVideoCar(@RequestParam("file") MultipartFile file,
                                 @RequestParam("carId") String carId) {
        return carService.uploadVideoCar(file, carId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CarDto editCarMetadata(@RequestBody CarDto carDto) {
        return carService.editCar(carDto);
    }

    @GetMapping
    public String getHello() {
        return "HELLO";
    }
}
