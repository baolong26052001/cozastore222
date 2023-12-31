package com.cybersoft.cozastore22.controller;

import com.cybersoft.cozastore22.payload.response.BaseResponse;
import com.cybersoft.cozastore22.payload.response.CategoryResponse;
import com.cybersoft.cozastore22.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getCategory() {
        List<CategoryResponse> list = categoryServiceImp.getAllCategory();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(list);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}