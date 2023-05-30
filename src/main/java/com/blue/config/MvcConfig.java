package com.blue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc 加上该注解表示全面接管mvc配置，当前配置只是扩展mvc配置，不需要全面接管
public class MvcConfig implements WebMvcConfigurer {
    //一般设置默认视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:D:\\springboot\\blog-spring\\src\\main\\resources\\static\\images\\");
        registry.addResourceHandler("/music/**").addResourceLocations("file:D:\\springboot\\blog-spring\\src\\main\\resources\\static\\music\\");
//下面为部署至云服务器的映射路径
//        registry.addResourceHandler("/images/**").addResourceLocations("file:/www/wwwroot/blog/blog-spring/images/");
//        registry.addResourceHandler("/music/**").addResourceLocations("file:/www/wwwroot/blog/blog-spring/music/");
    }

}
