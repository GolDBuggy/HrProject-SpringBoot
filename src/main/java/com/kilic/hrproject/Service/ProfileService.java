package com.kilic.hrproject.Service;

import com.kilic.hrproject.Model.Profile;
import com.kilic.hrproject.Repository.ProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepo repo;

    public void saveProfile(Profile profile){
        repo.save(profile);
    }
}
