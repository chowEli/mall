package com.zyl.mall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsProcessor;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;

/**
 * 跨域配置类：解决跨域问题
 */
@Configuration
public class MallCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration configuration = new CorsConfiguration();
        //配置跨域
        configuration.addAllowedHeader("*"); //允许哪些请求头跨域
        configuration.addAllowedMethod("*");      //允许哪些请求方式跨域
        configuration.addAllowedOrigin("*");       //允许哪些请求来源跨域
        configuration.setAllowCredentials(true);         //是否允许携带cookie跨域

        source.registerCorsConfiguration("/**",configuration);
        return new CorsWebFilter(source);
    }


}
