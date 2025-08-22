package com.GimnasioCertant.Gimnasio.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new authInterceptor())
                .addPathPatterns("/**") // se aplica a todo
                .excludePathPatterns("/Redirect/login", "/Redirect/Ingresar","/css/**", "/js/**"); // permitidos
    }
}

