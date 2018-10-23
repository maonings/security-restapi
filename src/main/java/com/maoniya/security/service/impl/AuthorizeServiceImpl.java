package com.maoniya.security.service.impl;

import com.maoniya.security.authorize.AuthorizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * describe: 基于角色的权限认证处理默认实现
 *
 * @author maoniya.com
 * @date 2018/10/23
 */
public class AuthorizeServiceImpl implements AuthorizeService {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizeService.class);

    public AuthorizeServiceImpl() {
        logger.info("The default authorizeService has init.");
    }

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        String uri = request.getRequestURI();
        if (user != null) {
            if (antPathMatcher.match("/hello", uri)) {
                for (GrantedAuthority authority : user.getAuthorities()) {
                    if ("user".equals(authority.getAuthority())) {
                        return true;
                    }
                }
            }
            if (antPathMatcher.match("/users", uri)) {
                for (GrantedAuthority authority : user.getAuthorities()) {
                    if ("admin".equals(authority.getAuthority())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
