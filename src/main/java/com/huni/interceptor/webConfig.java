package com.huni.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new loginInterceptor()).addPathPatterns("/order/**")
                .addPathPatterns("/post/**")
                ;
        registry.addInterceptor(new adminLoginInterceptor()).addPathPatterns("/admin/**/**").addPathPatterns("/admin")
                .excludePathPatterns("/admin/login")
               ;
                ;
    }
}