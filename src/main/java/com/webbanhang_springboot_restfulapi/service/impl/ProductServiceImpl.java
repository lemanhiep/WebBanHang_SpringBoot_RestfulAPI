package com.webbanhang_springboot_restfulapi.service.impl;


import com.webbanhang_springboot_restfulapi.dao.ProductDAO;
import com.webbanhang_springboot_restfulapi.entity.Product;
import com.webbanhang_springboot_restfulapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO pdao;

    @Override
    public List<Product> findAll() {
        return pdao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return pdao.findById(id).get();
    }

    @Override
    public List<Product> findByCategory(String cid) {
        return pdao.findByCategory(cid);
    }
}
