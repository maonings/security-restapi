package com.maoniya.security.authentication;

import com.maoniya.security.support.JsonWriter;
import com.maoniya.security.support.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重写AuthenticationEntryPoint，
 * 默认的AuthenticationEntryPoint会将用户重定向到登录页面。
 * 但是在REST设计中，只需返回认证结果，由请求发起者重新发起认证请求。
 *
 * date:  Created in 2018/10/8 10:56
 *
 * @author maoning
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e)
            throws IOException {
        JsonWriter.write(response, ResponseModel.error(HttpStatus.UNAUTHORIZED, "Authentication require."));
        return;
    }
}
