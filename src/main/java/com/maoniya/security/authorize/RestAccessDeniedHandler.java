package com.maoniya.security.authorize;

import com.maoniya.security.support.JsonWriter;
import com.maoniya.security.support.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义REST认证成功处理逻辑
 *
 * date:  Created in 2018/10/8 9:17
 *
 * @author maoning
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException {
            JsonWriter.write(httpServletResponse, ResponseModel.error(HttpStatus.FORBIDDEN, "无权访问!"));
    }
}
