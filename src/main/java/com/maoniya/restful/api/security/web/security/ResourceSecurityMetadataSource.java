package com.maoniya.restful.api.security.web.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 定义访问某个资源所需要的权限（角色）
 *
 * date:  Created in 2018/10/9 17:11
 *
 * @author maoning
 */
@Component
public class ResourceSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    /**
     * 获取某个资源所需的权限（角色）
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) o;
        System.out.println(fi);
        System.out.println("-_--_--_--_--_--_-");
        return null;
    }

    /**
     * 获取全部权限（角色）
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 看了源码，太复杂，没看懂，返回true和false都无所谓，
     * SpringSecurityChain加载的时候会加载一个默认的SecurityMetadataSource实现类，
     * 所以AbstractSecurityInterceptor的afterPropertiesSet方法在验证的时候，实际上是调用的D.....总之就是很复杂~~~~
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
