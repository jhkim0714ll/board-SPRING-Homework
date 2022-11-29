package com.kjh.boardhomework.global.webconfig;

import com.kjh.boardhomework.global.interceptor.BearerAuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    private final BearerAuthInterceptor authInterceptor;

    public WebMVCConfig(BearerAuthInterceptor bearerAuthInterceptor) {
        this.authInterceptor = bearerAuthInterceptor;
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**");
    }
}
