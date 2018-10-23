package com.maoniya.security.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * describe: 基于RBAC实现的访问授权控制
 *
 * @author maoniya.com
 * @date 2018/10/19
 */
@Component
@Order(Integer.MAX_VALUE - 8)
public class RbacAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    public boolean config(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler)
                    .and()
                .authorizeRequests()
                    .anyRequest()
                    .access("@authorizeService.hasPermission(request, authentication)");
        return true;
    }
}
