package com.webbanhang_springboot_restfulapi.service;

import com.webbanhang_springboot_restfulapi.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

}
