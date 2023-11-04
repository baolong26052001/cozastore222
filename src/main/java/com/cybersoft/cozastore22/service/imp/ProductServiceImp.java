package com.cybersoft.cozastore22.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ProductServiceImp {

    boolean insertProduct(MultipartFile file, String title, double price, int idCategory);
    Resource downloadProductFile(String tenFile);
}
