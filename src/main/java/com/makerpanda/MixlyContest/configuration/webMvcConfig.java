package com.makerpanda.MixlyContest.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Configuration
public class webMvcConfig implements WebMvcConfigurer {
    private String path = "upload/";
    private String htmlpath="src/main/resources/static/display/";
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String p = new File(path).getAbsolutePath() + File.separator;//取得在服务器中的绝对路径
        String hp= new File(htmlpath).getAbsolutePath() + File.separator;

        registry.addResourceHandler("/upload/**","/display/**") // 外部访问地址
                .addResourceLocations("file:" + p)// springboot需要增加file协议前缀
                .addResourceLocations("file:" + hp)// springboot需要增加file协议前缀
                .setCacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES));// 设置浏览器缓存30分钟
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/zhongxin1","/zhongxin2",
//                        "/banji","/xinxi1","/xinxi2",
//                        "/xinxi3","/xinxi4","/xinxi5",
//                        "/xinxi6","/zuopin")
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/",
                        "/login1","/static/assets/**",
                        "/login2","/getmima","/404",
                        "/about",
                        "/chuangke","/index","/ziliao",
                        "/zhanshi","/zhanshi1","/zhuce",
                        "/jzhuce","/xzhuce",
                        "/studentlogin","/teacherlogin",
                        "/xzhucetijiao","/jzhucetijiao",
                        "/getverifycode","/upload/**",
                        "/display/**","/assets/**");
    }

}
