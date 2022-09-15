package com.kilic.hrproject.Repository;

import com.kilic.hrproject.Model.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepo extends JpaRepository<JobAdvertisement,Long> {

    Optional<JobAdvertisement> findByJobName(String name);
}
