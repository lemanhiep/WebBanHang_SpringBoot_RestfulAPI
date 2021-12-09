package com.webbanhang_springboot_restfulapi.service.impl;

import com.webbanhang_springboot_restfulapi.dao.CategoryDAO;
import com.webbanhang_springboot_restfulapi.entity.Category;
import com.webbanhang_springboot_restfulapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl  implements CategoryService {
   @Autowired
    CategoryDAO cdao;

    @Override
    public List<Category> findAll() {
        return cdao.findAll();
    }
}
