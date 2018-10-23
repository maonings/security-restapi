package com.maoniya.security.service.impl;

import com.maoniya.security.authorize.AuthorizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 从数据库查询用户信息默认实现
 *
 * date:  Created in 2018/9/28 17:42
 *
 * @author maoning
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizeService.class);

    public UserDetailsServiceImpl() {
        logger.info("The default userDetailsService has init.");
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (!"admin".equals(s)) {
            throw new UsernameNotFoundException("User not found");
        }
        String username = "admin";
        String password = passwordEncoder.encode("admin");
        return new User(username, password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
