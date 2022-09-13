package com.kilic.hrproject.Service;

import com.kilic.hrproject.Model.Image;
import com.kilic.hrproject.Repository.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepo imageRepo;

    public void save(Image image){
        image.setId(UUID.randomUUID().toString());
        imageRepo.save(image);
    }

    public Image getImage(String id){
        return imageRepo.findById(id).get();
    }

}
