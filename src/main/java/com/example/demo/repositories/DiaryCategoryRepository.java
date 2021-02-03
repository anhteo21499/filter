package com.example.demo.repositories;

import com.example.demo.models.entities.DiaryCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiaryCategoryRepository extends JpaRepository<DiaryCategoryEntity,Integer> {
    @Query(value = "select dc from DiaryCategoryEntity dc")
    List<DiaryCategoryEntity> listDiaryCategory();
}
