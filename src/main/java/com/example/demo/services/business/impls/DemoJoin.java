//package com.example.demo.services.business.impls;
//
//import com.example.demo.models.entities.CategoryEntity;
//import com.example.demo.models.entities.DiaryCategoryEntity;
//import com.example.demo.models.entities.DiaryEntity;
//import com.example.demo.models.outs.DemoOut;
//import com.example.demo.repositories.CategoryRepository;
//import com.example.demo.repositories.DiaryCategoryRepository;
//import com.example.demo.repositories.DiaryRepository;
//import com.example.demo.services.mappers.CategoryMapper;
//import com.example.demo.services.mappers.DiaryMapper;
//import com.example.demo.services.mappers.FilterMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DemoJoin {
//    @Autowired
//    private DiaryRepository diaryRepository;
//    @Autowired
//    private DiaryMapper diaryMapper;
//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Autowired
//    private CategoryMapper categoryMapper;
//    @Autowired
//    private DiaryCategoryRepository diaryCategoryRepository;
//    @Autowired
//    private FilterMapper filterMapper;
//
//    public List<DemoOut> demoOutList(){
//        List<DiaryEntity> listDiaryEntity = diaryRepository.findDiaryEntity();
//        List<CategoryEntity> listCategory = categoryRepository.findCategoryEntity();
//        List<DiaryCategoryEntity> listDiaryCategory = diaryCategoryRepository.listDiaryCategory();
//        List<DemoOut> listDemoOut = new ArrayList<>();
//        for(int i= 0 ; i < listDiaryCategory.size() ; i ++){
//             DiaryEntity diaryEntity = listDiaryEntity.get(listDiaryCategory.get(i).getIdDiary());
//             CategoryEntity categoryEntity = listCategory.get(listDiaryCategory.get(i).getIdCategory());
//             listDemoOut.add(filterMapper.toDemoOut(diaryEntity,categoryEntity));
//        }
//        return listDemoOut;
//    }
//}
