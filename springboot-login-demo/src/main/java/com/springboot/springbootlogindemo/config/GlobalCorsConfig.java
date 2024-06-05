package com.springboot.springbootlogindemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")    // Add mapping path, "/**" indicates global cross-origin access for all paths
                        .allowedOriginPatterns("*")    // Specify which IPs, ports, and domain names are allowed access. Since SpringBoot 2.4.0, allowedOrigins has been replaced by allowedOriginPatterns
                        .allowedOriginPatterns(String.valueOf(true))  // Whether to allow sending Cookie information
                        .allowedOriginPatterns("GET", "POST", "PUT", "DELETE")     // Specify which HTTP methods are allowed for cross-origin access
                        .allowedOriginPatterns("*")     // Allow which headers in HTTP requests
                        .allowedOriginPatterns("*");   // Expose which headers (as cross-origin access cannot get all headers by default)
            }
        };
    }
}
