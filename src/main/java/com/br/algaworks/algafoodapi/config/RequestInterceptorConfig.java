package com.br.algaworks.algafoodapi.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@Log4j2
public class RequestInterceptorConfig implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         log.info(String.format("[REQUEST][METHOD] - %s",request.getMethod()));
         log.info(String.format("[REQUEST][URL] - %s",request.getRequestURL()));

        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
        if(String.valueOf(response.getStatus()).startsWith("2")){
            log.info(String.format("[RESPONSE][INTERCEPTOR][SUCCESS][STATUS] - %s",response.getStatus()));
        }else {
            //Mostrar a classe/metodo que originou o erro.
            log.error(String.format("[RESPONSE][INTERCEPTOR][ERROR][METHOD] - %s", handler.toString()));
        }

    }
}
