package com.makerpanda.MixlyContest.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Configuration
public class webMvcConfig implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer{
    private String path = "upload/";
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String p = new File(path).getAbsolutePath() + File.separator;//取得在服务器中的绝对路径
        System.out.println("Mapping /upload/** from " + p);
        registry.addResourceHandler("/upload/**") // 外部访问地址
                .addResourceLocations("file:" + p)// springboot需要增加file协议前缀
                .setCacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES));// 设置浏览器缓存30分钟
    }
}
