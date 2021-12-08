package com.webbanhang_springboot_restfulapi.dao;

import com.webbanhang_springboot_restfulapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, String> {
}
