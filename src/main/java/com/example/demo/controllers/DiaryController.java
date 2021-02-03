package com.example.demo.controllers;

import com.example.demo.exceptions.ResponseDetail;
import com.example.demo.models.ins.DiaryIn;
import com.example.demo.models.ins.FilterIn;
import com.example.demo.models.outs.CategoryDto;
import com.example.demo.models.outs.DemoOut;
import com.example.demo.models.outs.DiaryDto;
import com.example.demo.services.business.DiaryService;
import com.example.demo.services.business.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/diaries")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;
    @Autowired
    private FilterService filterDiaryService;

    @GetMapping
    public ResponseEntity<ResponseDetail<List<DiaryDto>>> read() {
        return diaryService.read();
    }

    @PostMapping
    public ResponseEntity<ResponseDetail<DiaryDto>> postClass(@RequestBody DiaryIn diaryIn) {
        return diaryService.createDiary(diaryIn);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseDetail<DiaryDto>> updateClassById(@PathVariable("id") int id, @RequestBody DiaryIn diaryIn) {
        return diaryService.updateDiaryById(id, diaryIn);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseDetail<DiaryDto>> deleteClassById(@PathVariable(value = "id") int id) {
        return diaryService.deleteDiaryById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDetail<DiaryDto>> findDiaryById(@PathVariable int id) {
        return diaryService.findDiaryById(id);
    }

//    @GetMapping("/filters")
//    public ResponseEntity<ResponseDetail<List<DiaryDto>>> filtersDiary(
//            @RequestParam(value = "title", required = false) String title,
//            @RequestParam(value = "favorite", required = false) boolean favorite,
//            @RequestParam(value = "toDate", required = false) LocalDateTime toDate,
//            @RequestParam(value = "fromDate", required = false) LocalDateTime fromDate) {
////        return filterDiaryService.
////                filterDiary(new FilterIn(title,favorite,LocalDateTime.of(2020,01,01,6,20,00)
////                        ,LocalDateTime.of(2020,12,28,6,20,00)));
//        return filterDiaryService.
//                filterDiary(new FilterIn(title, favorite, null
//                        , null));
//    }

    @GetMapping("/filters")
    public ResponseEntity<ResponseDetail<List<DemoOut>>> filterCategory(
            @RequestParam(value = "name1", required = false) String name1,
            @RequestParam(value = "name2", required = false) String name2,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "favorite", required = false) boolean favorite,
            @RequestParam(value = "toDate", required = false) LocalDateTime toDate,
            @RequestParam(value = "fromDate", required = false) LocalDateTime fromDate
    ) {
        return filterDiaryService.filters(new FilterIn(name1, name2, title, favorite
                , LocalDateTime.of(2020, 01, 01, 6, 20, 00)
                , LocalDateTime.of(2020, 12, 30, 6, 20, 00)));
    }
}

