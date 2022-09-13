package com.kilic.hrproject.Service;

import com.kilic.hrproject.Model.FilePath;
import com.kilic.hrproject.Repository.FilePathRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FilePathService {

    private final FilePathRepo filePathRepo;

    public void save(FilePath filePath){
        filePathRepo.save(filePath);
    }


    public FilePath getFilePath(String id){
        return filePathRepo.findById(id).get();
    }
}
