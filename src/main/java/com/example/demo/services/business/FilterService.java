package com.example.demo.services.business;

import com.example.demo.exceptions.ResponseDetail;
import com.example.demo.models.ins.FilterIn;
import com.example.demo.models.outs.DemoOut;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FilterService {
    ResponseEntity<ResponseDetail<List<DemoOut>>> filters(FilterIn filterIn);
}
