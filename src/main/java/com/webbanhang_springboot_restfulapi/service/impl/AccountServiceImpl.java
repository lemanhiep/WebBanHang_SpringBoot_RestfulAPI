package com.webbanhang_springboot_restfulapi.service.impl;

import com.webbanhang_springboot_restfulapi.dao.AccountDAO;
import com.webbanhang_springboot_restfulapi.entity.Account;
import com.webbanhang_springboot_restfulapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
    AccountDAO adao;

  @Override
  public Account findById(String username) {
    return adao.findById(username).get();
  }
}
