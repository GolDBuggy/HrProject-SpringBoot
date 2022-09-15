package com.kilic.hrproject.Dto;

import com.kilic.hrproject.Model.JobAdvertisement;
import com.kilic.hrproject.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavedJobListDto {

    private MemberSecDto member;
    private List<JobAdvertisement> savedJobs;

}
