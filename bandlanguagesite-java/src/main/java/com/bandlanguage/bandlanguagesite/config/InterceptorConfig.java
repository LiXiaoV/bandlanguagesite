package com.bandlanguage.bandlanguagesite.config;

import com.bandlanguage.bandlanguagesite.filter.UserLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiaov
 * @since 2021-06-28 15:27
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public UserLoginInterceptor userLoginInterceptor(){
        return new UserLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginInterceptor()) //登录逻辑拦截类
                .addPathPatterns("/**")  //需要拦截的请求（设置的全部拦截）
                .excludePathPatterns("/doLoginByUsername"); //忽略的请求
    }

}
