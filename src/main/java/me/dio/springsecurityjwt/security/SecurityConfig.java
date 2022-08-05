package me.dio.springsecurityjwt.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {

    public static String PREFIX;
    public static String KEY;
    public static Long EXPIRATION;

    public void setPREFIX(String prefix) {
        SecurityConfig.PREFIX = prefix;
    }

    public void setKEY(String key) {
        SecurityConfig.KEY = key;
    }

    public void setEXPIRATION(Long expiration) {
        SecurityConfig.EXPIRATION = expiration;
    }
}
