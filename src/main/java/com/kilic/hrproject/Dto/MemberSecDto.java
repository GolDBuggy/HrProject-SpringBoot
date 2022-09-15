package com.kilic.hrproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberSecDto {

    private String email;
    private String name;
    private String surname;

}
