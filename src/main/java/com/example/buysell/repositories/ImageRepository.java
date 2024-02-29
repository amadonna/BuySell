package com.example.buysell.repositories;

import com.example.buysell.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Override
    Optional<Image> findById(Long aLong);
}
