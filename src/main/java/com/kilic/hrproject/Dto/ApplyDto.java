package com.kilic.hrproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyDto {

    private String name;
    private String surname;
    private String email;
    private InformationDto profile;
    private BigDecimal salary;
    private int jobExperiance;
    private boolean applied;
    private long jobId;
    private MultipartFile file;
}
