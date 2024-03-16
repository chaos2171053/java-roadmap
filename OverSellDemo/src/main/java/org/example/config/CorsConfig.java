package org.example.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 创建CORS配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许所有方法（GET、POST等）
        corsConfiguration.addAllowedMethod("*");
        // 允许所有头部信息
        corsConfiguration.addAllowedHeader("*");
        // 允许跨域请求包含身份验证信息
        corsConfiguration.setAllowCredentials(true);

        // 添加映射路径和对应的配置
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        // 返回CorsFilter
        return new CorsFilter(source);
    }
}
