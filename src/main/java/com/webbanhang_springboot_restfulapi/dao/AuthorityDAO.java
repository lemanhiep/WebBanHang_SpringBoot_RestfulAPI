package com.webbanhang_springboot_restfulapi.dao;

import com.webbanhang_springboot_restfulapi.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
}
