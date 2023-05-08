package com.pet.project.rentauto.service;

import com.pet.project.rentauto.dto.CarDto;
import com.pet.project.rentauto.dto.UploadCarResponse;
import com.pet.project.rentauto.model.Car;
import com.pet.project.rentauto.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CarService {

    private final S3Service s3Service;
    private final CarRepository carRepository;

    public UploadCarResponse uploadCar(final MultipartFile multipartFile) {
        String carUrl = s3Service.uploadCar(multipartFile);
        Car car = new Car();
        car.setCarUrl(carUrl);
        Car updatedCar = carRepository.save(car);
        return new UploadCarResponse(updatedCar.getId(), updatedCar.getCarUrl());
    }

    public CarDto editCar(final CarDto carDto) {
        Car car = getCarById(carDto.getId());
        setCarPropertiesFromDto(car, carDto);
        carRepository.save(car);
        return carDto;
    }

    public String uploadVideoCar(final MultipartFile file, final String carId) {
        Car car = getCarById(carId);
        String videoCarUrl = s3Service.uploadCar(file);
        car.setVideoCarUrl(videoCarUrl);
        carRepository.save(car);
        return videoCarUrl;
    }

    private Car getCarById(final String carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find car with id" + carId));
    }

    private void setCarPropertiesFromDto(Car car, CarDto carDto) {
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setPrice(carDto.getPrice());
        car.setRent(carDto.getRent());
        car.setReservedCars(carDto.getReservedCars());
        car.setCarType(carDto.getCarType());
        car.setCarAvailable(carDto.getCarAvailable());
    }
}
