package com.maoniya.security.authorize;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
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

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.anyRequest().access("@rbacServiceImpl.hasPermission(request, authentication)");
        return true;
    }
}
