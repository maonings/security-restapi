package com.maoniya.security.authentication;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * describe: 认证配置管理类
 *
 * @author maoniya.com
 * @date 2018/10/19
 */
public interface AuthenticationConfigManager {

    void config(HttpSecurity http) throws Exception;

}
