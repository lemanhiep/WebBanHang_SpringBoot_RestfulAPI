package com.webbanhang_springboot_restfulapi.rest.controller;

import com.webbanhang_springboot_restfulapi.entity.Product;
import com.webbanhang_springboot_restfulapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }
}
