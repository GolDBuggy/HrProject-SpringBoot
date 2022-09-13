package com.kilic.hrproject.Repository;

import com.kilic.hrproject.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepo extends JpaRepository<Image, String> {
}
