package com.kilic.hrproject.Dto;

import com.kilic.hrproject.Model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String country;
    private String province;
    private String graduation;
    private String school;
    private String department;
    private String certificate;
    private Image image;
}
