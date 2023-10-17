package com.example.singingclubvotingproject.config;

import com.example.singingclubvotingproject.z_interceptor.AccessInterceptor;
import jakarta.annotation.Resource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration  //标识是一个配置文件
public class ServletConfig implements WebMvcConfigurer { //设置开始的定义
//    @Resource

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/**").addResourceLocations("file:"+configModel.getFilePath());
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        System.out.println("进入拦截器------------");

        // 注册拦截器  除了login和注册不拦截 其他都拦截
        registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/testredis")
                .excludePathPatterns("/image/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/*.html")
                .excludePathPatterns("/*.js")
                .excludePathPatterns("/*.jpg")
                .excludePathPatterns("/login/login")
        //登入不拦截
                ;
    }


}
