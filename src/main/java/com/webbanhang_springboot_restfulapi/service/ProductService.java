package com.webbanhang_springboot_restfulapi.service;

import com.webbanhang_springboot_restfulapi.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByCategory(String cid);
}
