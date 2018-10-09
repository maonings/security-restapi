package com.maoniya.restful.api.security.web.filter;

import com.maoniya.restful.api.security.web.config.JwtProperties;
import com.maoniya.restful.api.security.web.support.JsonWriter;
import com.maoniya.restful.api.security.model.ResponseModel;
import com.maoniya.restful.api.security.web.config.JwtProperties;
import com.maoniya.restful.api.security.web.security.DaoUserDetailsService;
import com.maoniya.restful.api.security.web.support.JsonWriter;
import com.maoniya.restful.api.security.web.config.JwtProperties;
import com.maoniya.restful.api.security.web.support.JsonWriter;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT认证过滤器
 *
 * date:  Created in 2018/10/9 11:50
 *
 * @author maoning
 */
@Component
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private DaoUserDetailsService daoUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader(this.jwtProperties.getHeader());
        if (!StringUtils.isEmpty(token) && token.startsWith(this.jwtProperties.getTokenPrefix())) {
            UserDetails userDetails;
            try {
                String sub = Jwts.parser()
                        .setSigningKey(this.jwtProperties.getSecretKey())
                        .parseClaimsJws(token.replace(this.jwtProperties.getTokenPrefix(), ""))
                        .getBody()
                        .getSubject();
                userDetails = this.daoUserDetailsService.loadUserByUsername(sub);
            } catch (Exception e) {
                JsonWriter.write(response, new ResponseModel<>(HttpStatus.BAD_REQUEST, "Invalid token")); return;
            }
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
