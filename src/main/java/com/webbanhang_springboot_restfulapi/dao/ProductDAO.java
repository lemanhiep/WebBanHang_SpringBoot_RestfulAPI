package com.webbanhang_springboot_restfulapi.dao;

import com.webbanhang_springboot_restfulapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p where p.category.id=?1")
    List<Product> findByCategory(String cid);
}
