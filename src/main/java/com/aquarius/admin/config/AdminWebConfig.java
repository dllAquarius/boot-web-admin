package com.aquarius.admin.config;

import com.aquarius.admin.interceptor.LoginInterceptor;
import com.aquarius.admin.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/7
 * @Description:
 * 1、编写一个拦截器实现HandlerInterceptor
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 2、指定拦截规则【如果是拦截所有，静态资源页会被拦截】
 * @EnableWebMvc  全面接管
 * 1、 静态资源 视图解析器 欢迎页    全部失效
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 访问 /aa/**  所有请求 都去 classpath:/static/ 下面进行匹配
//        registry.addResourceHandler("/aa/**")
//                .addResourceLocations("classpath:/static/");
//    }

    /**
     * Filter、Interceptor 几乎拥有相同的功能
     * 1、Filter是Servlet定义的原生组件。好处是可以脱离Spring应用也能使用
     * 2、Interceptor 是Spring定义的接口。可以使用Spring的自动装配等功能
     */
    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有请求都被拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**"); // 放行的请求

        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**") //所有请求都被拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**"); // 放行的请求

    }
}
