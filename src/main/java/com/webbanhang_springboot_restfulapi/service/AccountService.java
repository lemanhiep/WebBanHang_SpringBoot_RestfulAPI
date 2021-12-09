package com.webbanhang_springboot_restfulapi.service;

import com.webbanhang_springboot_restfulapi.entity.Account;

public interface AccountService {

    Account findById(String username);
}
