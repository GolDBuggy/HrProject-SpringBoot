package com.kilic.hrproject.Repository;

import com.kilic.hrproject.Model.JobAdvertisement;
import com.kilic.hrproject.Model.Member;
import com.kilic.hrproject.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepo extends JpaRepository<Profile,Long> {

    boolean existsProfileBySavedJobsAndId(JobAdvertisement jobAdvertisements,long id);
}
