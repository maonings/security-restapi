package com.maoniya.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 拦截登录请求，判断如果登录请求的contentType是json，取出JSON请求参数放入request parameter中
 *
 * date:  Created in 2018/10/8 9:44
 *
 * @author maoning
 */
@Component
public class JsonParameterConvertFilter implements Filter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        String contentType = request.getContentType();
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        if (antPathMatcher.match("/login", uri)
                && HttpMethod.POST.matches(request.getMethod())
                && contentTypeIsJson(contentType)) {
            HashMap<String, String> parameter = objectMapper.readValue(request.getInputStream(), HashMap.class);
            String username = parameter.get("username");
            String password = parameter.get("password");
            JsonParameterConvertHttpServletRequestWrapper requestWrapper = new JsonParameterConvertHttpServletRequestWrapper(request);
            requestWrapper.addParameter("username", username);
            requestWrapper.addParameter("password", password);
            request = requestWrapper;
        }
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private boolean contentTypeIsJson(String contentType) {
        return "application/json;charset=UTF-8".equalsIgnoreCase(contentType) || "application/json".equalsIgnoreCase(contentType);
    }

    /**
     * 重写HttpServletRequestWrapper，用来把JSON请求中的参数取出来并放入request.parameter
     * 因为SpringSecurity的UsernamePasswordAuthenticationFilter是从request中取参数的
     */
    private class JsonParameterConvertHttpServletRequestWrapper extends HttpServletRequestWrapper {

        // 所有参数的Map集合
        private Map<String, String> parameterMap = new HashMap<>();

        public JsonParameterConvertHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        public void addParameter(String key, String value) {
            parameterMap.put(key, value);
        }

        /**
         * 重写getParameter方法
         * @param key
         * @return
         */
        @Override
        public String getParameter(String key) {
            return parameterMap.get(key);
        }
    }
}
