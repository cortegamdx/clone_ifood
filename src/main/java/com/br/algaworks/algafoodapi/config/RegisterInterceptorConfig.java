package com.br.algaworks.algafoodapi.config;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class RegisterInterceptorConfig implements WebMvcConfigurer {


    @Autowired
    RequestInterceptorConfig requestInterceptorConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(requestInterceptorConfig);
    }


}
