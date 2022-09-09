package com.kilic.hrproject.Service;

import com.kilic.hrproject.Model.Candidate;
import com.kilic.hrproject.Repository.CandidateRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepo candidateRepo;

    public List<Candidate> getAll(){
        return candidateRepo.findAll();
    }

    public void save(Candidate candidate){
        candidateRepo.save(candidate);
    }



}
