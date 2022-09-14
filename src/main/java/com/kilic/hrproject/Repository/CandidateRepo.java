package com.kilic.hrproject.Repository;

import com.kilic.hrproject.Model.Candidate;
import com.kilic.hrproject.Model.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate,Long> {

    boolean existsCandidateByEmailAndJobAdvertisements(String email, JobAdvertisement advertisement);
}
