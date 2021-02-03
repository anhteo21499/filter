package com.example.demo.services.business.impls;

import com.example.demo.exceptions.Response;
import com.example.demo.exceptions.ResponseDetail;
import com.example.demo.models.entities.CategoryEntity;
import com.example.demo.models.entities.DiaryCategoryEntity;
import com.example.demo.models.entities.DiaryEntity;
import com.example.demo.models.ins.FilterIn;
import com.example.demo.models.outs.DemoOut;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.DiaryCategoryRepository;
import com.example.demo.repositories.DiaryRepository;
import com.example.demo.services.business.FilterService;
import com.example.demo.services.mappers.CategoryMapper;
import com.example.demo.services.mappers.DiaryMapper;
import com.example.demo.services.mappers.FilterMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FilterServiceImpl implements FilterService {
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private DiaryMapper diaryMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private DiaryCategoryRepository diaryCategoryRepository;
    @Autowired
    private FilterMapper filterMapper;

    @Override
    public ResponseEntity<ResponseDetail<List<DemoOut>>> filters(FilterIn filterIn) {
        List<DiaryEntity> listDiaryEntity = diaryRepository.findDiaryEntity();
        List<CategoryEntity> listCategory = categoryRepository.findCategoryEntity();
        List<DiaryCategoryEntity> listDiaryCategory = diaryCategoryRepository.listDiaryCategory();
        List<DemoOut> listDemoOut = new ArrayList<>();
        for (DiaryCategoryEntity diaryCategoryEntity : listDiaryCategory) {
            DiaryEntity diaryEntity = listDiaryEntity.get(diaryCategoryEntity.getIdDiary() - 1);
            CategoryEntity categoryEntity = listCategory.get(diaryCategoryEntity.getIdCategory() - 1);
            listDemoOut.add(filterMapper.toDemoOut(diaryEntity, categoryEntity));
        }
        List<DemoOut> listFilter = listDemoOut.stream().filter(getConditionDiary(filterIn).stream().reduce(t -> true ,Predicate::and)).collect(Collectors.toList());
        return Response.ok(listFilter);
    }

    public List<Predicate<DemoOut>> getConditionDiary(FilterIn filterIn) {
        List<Predicate<DemoOut>> listCondition = new ArrayList<>();

        if (!StringUtils.isBlank(filterIn.getCategoryNameOne())) {
            Predicate<DemoOut> checkName1 = d -> d.getNameCategory().equals(filterIn.getCategoryNameOne());
            listCondition.add(checkName1);
        }
        if (!StringUtils.isBlank(filterIn.getCategoryNameTwo())) {
            Predicate<DemoOut> checkName2 = d -> d.getNameCategory().equals(filterIn.getCategoryNameTwo());
            listCondition.add(checkName2);
        }
        if (!StringUtils.isBlank(filterIn.getTitle())) {
            Predicate<DemoOut> checkTitle = d -> d.getTitle().equals(filterIn.getTitle());
            listCondition.add(checkTitle);
        }
        if (filterIn.isFavorite()) {
            Predicate<DemoOut> checkFavorite = d -> d.isFavorite() == filterIn.isFavorite();
            listCondition.add(checkFavorite);
        }
        if (filterIn.getToDateTime() != null && filterIn.getFromDateTime() != null) {
            Predicate<DemoOut> checkDatetime = d -> (d.getCreateAt().isAfter(filterIn.getToDateTime()))
                    && (d.getCreateAt().isBefore(filterIn.getFromDateTime()));
            listCondition.add(checkDatetime);
        }

        return listCondition;
    }


//        List<DiaryEntity> listDiary = filterDiary(filterIn);
//        List<CategoryEntity> listCategory = filterCategory(filterIn);
//        if (listDiary == null && listCategory == null ) return Response.badRequest(StringResponses.NOT_FOUND_DIARY);
//        if (listCategory == null) return Response.ok(diaryMapper.mapToListDiaryDto(listDiary));
//        List<DiaryCategoryEntity> listDiaryCategory = diaryCategoryRepository.listDiaryCategory()
//                .stream().filter(kn -> listCategory.stream()
//                        .map(CategoryEntity::getId)
//                        .anyMatch(d -> d.equals(kn.getIdCategory())))
//                .collect(Collectors.toList());
//        if (listDiaryCategory.isEmpty()) return Response.badRequest(StringResponses.NOT_FOUND_DIARY);
//        return Response.ok(listDiary.stream().filter(d -> listDiaryCategory.stream()
//                .map(DiaryCategoryEntity::getId)
//                .anyMatch(kn -> kn.equals(d.getId())))
//                .map(diaryMapper::mapToDiaryDto)
//                .collect(Collectors.toList()));
//





//    public List<DiaryEntity> filterDiary(FilterIn filterIn) {
//        List<Predicate<DiaryEntity>> listCondition = getConditionDiary(filterIn);
//        if(listCondition.isEmpty()) return null;
//        List<DiaryEntity> listDiary = diaryRepository.findDiaryEntity();
//        return listDiary.stream()
//                .filter(listCondition.stream().reduce(l -> true, Predicate::and))
//                .collect(Collectors.toList());
//    }
//
//    public List<CategoryEntity> filterCategory(FilterIn filterIn) {
//        List<Predicate<CategoryEntity>> listCondition = getConditionCategory(filterIn);
//        if(listCondition.isEmpty()) return null;
//        List<CategoryEntity> listCategory = categoryRepository.findCategoryEntity();
//        List<DiaryCategoryEntity> listDiaryCategory = diaryCategoryRepository.listDiaryCategory();
//        List<CategoryEntity> join = listCategory.stream()
//                .filter(c -> listDiaryCategory.stream()
//                        .map(DiaryCategoryEntity::getIdCategory)
//                        .anyMatch(kn -> kn.equals(c.getId())))
//
//                .collect(Collectors.toList());
//        return join.stream()
//                .filter(listCondition.stream().reduce(c -> true, Predicate::and))
//                .collect(Collectors.toList());
//    }

//    public List<Predicate<CategoryEntity>> getConditionCategory(FilterIn filterIn) {
//        List<Predicate<CategoryEntity>> listConditionCategory = new ArrayList<>();
//        if (!StringUtils.isBlank(filterIn.getCategoryNameOne())) {
//            Predicate<CategoryEntity> checkName1 = d -> d.getName().equals(filterIn.getCategoryNameOne());
//            listConditionCategory.add(checkName1);
//        }
//        if (!StringUtils.isBlank(filterIn.getCategoryNameTwo())) {
//            Predicate<CategoryEntity> checkName2 = d -> d.getName().equals(filterIn.getCategoryNameTwo());
//            listConditionCategory.add(checkName2);
//        }
//        return listConditionCategory;
//    }

}
