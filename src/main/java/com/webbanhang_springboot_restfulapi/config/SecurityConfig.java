package com.webbanhang_springboot_restfulapi.config;

import com.webbanhang_springboot_restfulapi.entity.Account;
import com.webbanhang_springboot_restfulapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountService accountService;
    BCryptPasswordEncoder pe;

    //cung cấp nguồn dữ liệu đăng nhập
    @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            try {
                Account user = accountService.findById(username);
                String password = pe.encpde(user.getPassword());
                String[] roles = user.getAuthorities().stream()
                        .map(er -> er.getRole().getId())
                        .collect(Collectors.toList()).toArray(new String[0]);
            return User.withUsername(username).password(password).roles(roles).build();
            }
            catch (NoSuchElementException e)
            {
                throws new UsernameNotFoundException(username + "not found!");
            }
        });
    }
    //phần quyền sử dụng
    protected void configure(HttpSecurity http) throws Exception {}
    //cơ chế mã hóa mật khẩu
    public BCryptPasswordEncoder getPasswordEncoder() {}
}
