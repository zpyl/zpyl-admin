package com.dorm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class ZpylCorsConfiguration {
    @Bean
    public CorsFilter corsFilter(){
        //初始化cors配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");//设置跨域的域名 corsConfiguration.addAllowedOrigin("manage.leiyou.com")
        corsConfiguration.setAllowCredentials(true);//是否允许携带cookie，如果可以，则域名不可以设置为*，因为*表示所有域名,则得不到cookie
        corsConfiguration.addAllowedMethod("*");//代表所有的请求方法：GET POST PUT DELETE 等
        corsConfiguration.addAllowedHeader("*");//允许携带任何头信息

        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource corsConfigurationSource=new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        //返回CorsFilter实例，参数：cors配置源对象
        return new CorsFilter(corsConfigurationSource);
    }
}
