package com.maoniya.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * describe: 默认认证配置管理器
 *
 * @author maoniya.com
 * @date 2018/10/19
 */
@Component
public class DefaultAuthenticationConfigManager implements AuthenticationConfigManager {

    @Autowired
    private List<AuthenticationConfigProvider> authenticationConfigProviders;

    @Override
    public void config(HttpSecurity http) throws Exception {
        for (AuthenticationConfigProvider provider
                : authenticationConfigProviders) {
            provider.config(http);
        }
    }

}
