package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigService {
    public ConfigService(@Value("${spring.datasource.url}") String dbUrl,@Value("${spring.datasource.username}") String ServerName,
                         @Value("${spring.datasource.password}") String ServerPass){
        this.DbUrl = dbUrl;
        this.ServerName=ServerName;
        this.ServerPass=ServerPass;
    }

    public String DbUrl;
    public String ServerName;
    public String ServerPass;
}

