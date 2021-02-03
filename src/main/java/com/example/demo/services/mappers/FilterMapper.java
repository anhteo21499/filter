package com.example.demo.services.mappers;

import com.example.demo.models.entities.CategoryEntity;
import com.example.demo.models.entities.DiaryEntity;
import com.example.demo.models.outs.CategoryDto;
import com.example.demo.models.outs.DemoOut;
import com.example.demo.models.outs.DiaryDto;
import com.example.demo.models.outs.FilterOut;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

@Component
public class FilterMapper {
    public FilterOut toFilterOut(DiaryDto diaryDto, String namCategory){
        FilterOut filterOut = new FilterOut();
        filterOut.setCategoryName(namCategory);
        filterOut.setTitle(diaryDto.getTitle());
        filterOut.setFavorite(diaryDto.isStatusFavorite());
        filterOut.setCreateAt(diaryDto.getCreateAt());
        return filterOut;
    }

    public DemoOut toDemoOut(DiaryEntity diaryEntity , CategoryEntity categoryEntity){
        DemoOut demo = new DemoOut();
        demo.setDiId(diaryEntity.getId());
        demo.setCaId(categoryEntity.getId());
        demo.setNameCategory(categoryEntity.getName());
        demo.setTitle(diaryEntity.getTitle());
        demo.setFavorite(diaryEntity.isStatusFavorite());
        demo.setCreateAt(diaryEntity.getCreateAt());
        return demo;
    }


}
