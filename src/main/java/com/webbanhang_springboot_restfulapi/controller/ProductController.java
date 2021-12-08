package com.webbanhang_springboot_restfulapi.controller;



import com.webbanhang_springboot_restfulapi.entity.Product;
import com.webbanhang_springboot_restfulapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("/product/list")
    public String list(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("items", list);
        return "product/list";
    }
    @RequestMapping("/product/detail/{id}")
    public String detail(Model model) {
        return "product/detail";
    }
}
