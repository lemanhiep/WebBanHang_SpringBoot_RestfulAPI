package com.webbanhang_springboot_restfulapi.service;

import com.webbanhang_springboot_restfulapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
}
