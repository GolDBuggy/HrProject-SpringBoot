package com.kilic.hrproject.Service;

import com.kilic.hrproject.Dto.ApplyDto;
import com.kilic.hrproject.Model.Candidate;
import com.kilic.hrproject.Repository.CandidateRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepo candidateRepo;
    private final JobService jobService;

    public List<Candidate> getAll(){
        return candidateRepo.findAll();
    }

    public void save(ApplyDto applyDto){
        Candidate candidate= Candidate.builder().country(applyDto.getCountry()).
                birthday(applyDto.getBirthday()).email(applyDto.getEmail()).jobExperiance(applyDto.getJobExperiance()).
                salary(applyDto.getSalary()).name(applyDto.getName()).surname(applyDto.getSurname()).
                jobAdvertisements(Arrays.asList(jobService.getById(applyDto.getJobId()))).applied(true).
                province(applyDto.getProvince()).build();
        candidateRepo.save(candidate);
    }



}
