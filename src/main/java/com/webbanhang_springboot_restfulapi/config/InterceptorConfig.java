package com.webbanhang_springboot_restfulapi.config;


import com.webbanhang_springboot_restfulapi.interceptor.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    GlobalInterceptor globalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(globalInterceptor)
               .addPathPatterns("/**")
               .excludePathPatterns("/rest/**", "/admin/**", "/assets/**");
    }
}
