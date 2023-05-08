package com.pet.project.rentauto.service.iterface;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadCar(MultipartFile multipartFile);
}
