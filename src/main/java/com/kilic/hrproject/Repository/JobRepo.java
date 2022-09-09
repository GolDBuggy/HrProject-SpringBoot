package com.kilic.hrproject.Repository;

import com.kilic.hrproject.Model.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<JobAdvertisement,Long> {
}
