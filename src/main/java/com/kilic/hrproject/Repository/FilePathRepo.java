package com.kilic.hrproject.Repository;

import com.kilic.hrproject.Model.FilePath;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilePathRepo extends JpaRepository<FilePath,String> {
}
