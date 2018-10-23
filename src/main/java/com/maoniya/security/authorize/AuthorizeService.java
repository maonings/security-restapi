package com.maoniya.security.authorize;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * describe:
 *
 * @author maoniya.com
 * @date 2018/10/22
 */
public interface AuthorizeService {

    /**
     * 权限认证核心方法
     * @param request
     * @param authentication
     * @return
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
