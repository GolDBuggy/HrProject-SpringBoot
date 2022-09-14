package com.kilic.hrproject.Service;

import com.kilic.hrproject.Dto.ApplyDto;
import com.kilic.hrproject.Model.Candidate;
import com.kilic.hrproject.Model.FilePath;
import com.kilic.hrproject.Model.JobAdvertisement;
import com.kilic.hrproject.Repository.CandidateRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepo candidateRepo;
    private final FilePathService filePathService;
    private final StorageService storageService;
    private final JobService jobService;

    public List<Candidate> getAll(){
        return candidateRepo.findAll();
    }

    public void save(ApplyDto applyDto){
        checkExist(applyDto.getEmail(), jobService.getById(applyDto.getJobId()));
        Candidate candidate= Candidate.builder().country(applyDto.getProfile().getCountry()).
                birthday(applyDto.getProfile().getBirthday()).email(applyDto.getEmail()).jobExperiance(applyDto.getJobExperiance()).
                salary(applyDto.getSalary()).name(applyDto.getName()).surname(applyDto.getSurname()).
                jobAdvertisements(Arrays.asList(jobService.getById(applyDto.getJobId()))).applied(true).
                province(applyDto.getProfile().getProvince()).path(savePath(applyDto.getFile().getOriginalFilename())).build();
        candidateRepo.save(candidate);
    }

    private FilePath savePath(String path){
        FilePath filePath=FilePath.builder().id(UUID.randomUUID().toString()).path(path).build();
        filePathService.save(filePath);
        return filePath;
    }


    private void checkExist(String email, JobAdvertisement jobAdvertisement){
        if (candidateRepo.existsCandidateByEmailAndJobAdvertisements(email,jobAdvertisement))
            throw new RuntimeException("You have already applied!");
    }



}
