package com.cybersoft.cozastore22.service;

import com.cybersoft.cozastore22.service.imp.FileStorageServiceImp;
import com.cybersoft.cozastore22.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private FileStorageServiceImp fileStorageServiceImp;

    @Override
    public boolean insertProduct(MultipartFile file, String title, double price, int idCategory) {
        boolean isSave = fileStorageServiceImp.saveFile(file);
        if (isSave) {
            // Khi save hình thành công thêm dữ liệu vào bảng Product và ProductDetail
            // Khi save dữ liệu database thành công thì thuộc tính id của Entity sẽ có giá trị
            // Transaction
        }
        return false;
    }

    @Override
    public Resource downloadProductFile(String tenFile) {
        return fileStorageServiceImp.loadFile(tenFile);

    }
}
