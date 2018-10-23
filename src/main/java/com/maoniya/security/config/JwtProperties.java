package com.maoniya.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * JWT自定义配置
 *
 * date:  Created in 2018/10/9 13:13
 *
 * @author maoning
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String header = "token";

    private String secretKey = "1234567890";

    private Integer expiresIn = 7200;

    private String tokenPrefix = "Bearer";

    public int getExpiresIn() {
        return expiresIn * 1000;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "JwtProperties{" +
                "expiresIn=" + this.getExpiresIn() +
                ", header='" + this.getHeader() + '\'' +
                ", tokenPrefix='" + this.getTokenPrefix() + '\'' +
                ", secretKey='" + this.getSecretKey() + '\'' +
                '}';
    }
}
