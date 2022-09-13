package com.kilic.hrproject.Service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("storage")
@Getter
@Setter
public class StorageProperties {

    private String location = "C:/Users/hakki/Documents/GitHub/HrProject-SpringBoot/src/main/resources/image";
    private String pdfLocation = "C:/Users/hakki/Documents/GitHub/HrProject-SpringBoot/src/main/resources/CvFolder";


}
