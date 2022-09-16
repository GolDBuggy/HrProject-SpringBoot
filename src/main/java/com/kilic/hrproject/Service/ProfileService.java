package com.kilic.hrproject.Service;

import com.kilic.hrproject.Model.JobAdvertisement;
import com.kilic.hrproject.Model.Profile;
import com.kilic.hrproject.Repository.ProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepo repo;
    private final ImageService imageService;

    public void saveProfile(Profile profile){
        imageService.save(profile.getImage());
        repo.save(profile);
    }

    public void updateProfile(Profile profile){
        checkJob(profile);
        repo.save(profile);
    }

    public void deleteProfileJob(Profile profile){
        repo.save(profile);
    }



    private void checkJob(Profile profile){
        if(repo.existsProfileBySavedJobsAndId(profile.getSavedJobs().get(profile.getSavedJobs().size()-1), profile.getId()))
            throw new RuntimeException("Already saved");
    }

}
