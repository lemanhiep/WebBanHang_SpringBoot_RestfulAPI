package com.webbanhang_springboot_restfulapi.dao;

import com.webbanhang_springboot_restfulapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product,Integer> {
}
