package com.example.demo.repositories;

import com.example.demo.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
    @Query(value = "select c from CategoryEntity c")
    List<CategoryEntity> findCategoryEntity();
}
