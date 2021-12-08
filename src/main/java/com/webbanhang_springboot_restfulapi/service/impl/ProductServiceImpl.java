package com.webbanhang_springboot_restfulapi.service.impl;


import com.webbanhang_springboot_restfulapi.dao.ProductDAO;
import com.webbanhang_springboot_restfulapi.entity.Product;
import com.webbanhang_springboot_restfulapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO pdao;

    @Override
    public List<Product> findAll() {
        return pdao.findAll();
    }
}
