package com.maoniya.security.config;

import com.maoniya.security.authentication.AuthenticationConfigManager;
import com.maoniya.security.authorize.AuthorizeConfigManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * describe:
 *
 * @author maoniya.com
 * @date 2018/10/22
 */
public final class RestHttpSecurity {

    private HttpSecurity http;

    private RestHttpSecurity(HttpSecurity http) {
        this.http = http;
    }

    public static RestHttpSecurity create(HttpSecurity http) {
        return new RestHttpSecurity(http);
    }

    public RestHttpSecurity authenticationManager(AuthenticationConfigManager authenticationConfigManager)
            throws Exception {
        authenticationConfigManager.config(http);
        return this;
    }

    public RestHttpSecurity authorizeManager(AuthorizeConfigManager authorizeConfigManager)
            throws Exception {
        authorizeConfigManager.config(http.authorizeRequests());
        return this;
    }
}
