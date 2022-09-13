package com.kilic.hrproject.Dto;

import com.kilic.hrproject.Model.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReferenceDto {
    private String name;
    private String surname;
    private String email;
    private List<JobAdvertisement> job;
    private String file;
}
