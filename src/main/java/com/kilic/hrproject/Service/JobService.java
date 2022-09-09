package com.kilic.hrproject.Service;

import com.kilic.hrproject.Model.JobAdvertisement;
import com.kilic.hrproject.Repository.JobRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepo repo;

    public void save(JobAdvertisement advertisement){
        repo.save(advertisement);
    }


    public List<JobAdvertisement> getAll(){
       return repo.findAll(Sort.by("deadline"));
    }
}
