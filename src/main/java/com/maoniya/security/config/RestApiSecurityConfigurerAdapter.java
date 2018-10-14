package com.maoniya.security.config;

import com.maoniya.security.authentication.JsonParameterConvertFilter;
import com.maoniya.security.authentication.JwtTokenAuthenticationFilter;
import com.maoniya.security.core.DaoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * RestApiSecurityConfigAdapter.java
 *
 * @author MaoNing
 * @version 1.0.0
 * @Date 2018/10/14 22:10
 */
@Configuration
public class RestApiSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private DaoUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private JsonParameterConvertFilter jsonParameterConvertFilter;

    @Autowired
    private JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * SpringSecurity基本配置，其中用到的四个自定义类作用可跟进类里面查看
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jsonParameterConvertFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                    .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint)
                    .and()
                .formLogin()
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(authenticationFailureHandler)
                    .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                .csrf()
                    .disable()
                .headers()
                    .cacheControl()
                    .disable()
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 构造一个密码加密算法实例
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 定制AuthenticationProvider。
     * 指定密码加密算法用户数据来源，关闭SpringSecurity默认隐藏UserNotFoundException，自定义错误信息。
     *
     * @return AuthenticationProvider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setHideUserNotFoundExceptions(false);
        authenticationProvider.setMessageSource(new DelegatingMessageSource());
        return authenticationProvider;
    }

}
