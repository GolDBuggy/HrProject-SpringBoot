package com.kilic.hrproject.Repository;

import com.kilic.hrproject.Model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate,Long> {
}
