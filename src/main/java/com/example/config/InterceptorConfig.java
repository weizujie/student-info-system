package com.example.config;

import com.example.interceptors.JWTInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.*;

import java.util.concurrent.Executors;

/**
 * 拦截器配置
 *
 * @Author: weizujie
 * @Date: 2020/8/21
 * @Github: https://github.com/weizujie
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                // 拦截以下接口
                .addPathPatterns("/**")
                // 不拦截以下接口
                .excludePathPatterns("/*")
                .excludePathPatterns("/api/v1/login")
                .excludePathPatterns("/api/v1/obtain")
                .excludePathPatterns("/api/v1/scholarism")
                .excludePathPatterns("/api/v1/gameLevel")
                .excludePathPatterns("/api/v1/raceName")
                .excludePathPatterns("/api/v1/raceScope")
//                .excludePathPatterns("/api/v1/obtain/exportExcel")
//                .excludePathPatterns("/api/v1/obtain/importExcel")
//                .excludePathPatterns("/api/v1/scholarism/importExcel")
//                .excludePathPatterns("/api/v1//scholarism/exportExcel")
                .excludePathPatterns("/static/images/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }


    /**
     * 异步请求配置
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(30000);
    }

    /**
     * 跨域处理
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
    }
}
