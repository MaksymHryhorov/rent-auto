package com.pet.project.rentauto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadCarResponse {
    private String carId;
    private String carUrl;
}
