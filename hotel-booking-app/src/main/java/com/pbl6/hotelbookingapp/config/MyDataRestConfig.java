package com.pbl6.hotelbookingapp.config;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Value("${allowed.origins}")
    private String[] theAllowedOrigins;
    @Value("${spring.data.rest.base-path}")
    private String basePath;
    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;

    }
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        cors.addMapping(basePath + "/**").allowedOrigins(theAllowedOrigins).allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH")
                .allowedHeaders("*");

    }
}
