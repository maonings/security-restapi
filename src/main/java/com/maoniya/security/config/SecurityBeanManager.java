package com.maoniya.security.config;

import com.maoniya.security.authorize.AuthorizeService;
import com.maoniya.security.service.impl.AuthorizeServiceImpl;
import com.maoniya.security.service.impl.UserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * describe:
 *
 * @author maoniya.com
 * @date 2018/10/23
 */
@Configuration
public class SecurityBeanManager {

    @Bean
    @ConditionalOnMissingBean(name = "userDetailsService")
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authorizeService")
    public AuthorizeService authorizeService() {
        return new AuthorizeServiceImpl();
    }

}
