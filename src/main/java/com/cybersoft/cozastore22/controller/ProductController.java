package com.cybersoft.cozastore22.controller;

import com.cybersoft.cozastore22.service.imp.FileStorageServiceImp;
import com.cybersoft.cozastore22.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getProduct() {

        return new ResponseEntity<>("Product Get", HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertProduct(@RequestParam MultipartFile file, @RequestParam String title,
                                           @RequestParam double price, @RequestParam int idCategory) {
        productServiceImp.insertProduct(file, title, price, idCategory);
        return new ResponseEntity<>("Product Insert", HttpStatus.OK);
    }

    @GetMapping("/{tenfile}")
    public ResponseEntity<?> downloadProductFile(@PathVariable String tenfile){
        Resource resource = productServiceImp.downloadProductFile(tenfile);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + tenfile + "\"").body(resource);

    }

}
