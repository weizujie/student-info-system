package com.example.config;

import com.example.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: weizujie
 * @Date: 2020/8/21
 * @Github: https://github.com/weizujie
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                // 拦截以下接口
                .addPathPatterns("/**")
                // 不拦截以下接口
                .excludePathPatterns("/api/v1/login")
                .excludePathPatterns("/api/v1/register");
    }
}
