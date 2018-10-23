package security.authentication;

import security.config.JwtProperties;
import security.support.JsonWriter;
import security.support.ResponseModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * 自定义REST认证成功处理逻辑
 *
 * date:  Created in 2018/10/8 9:17
 *
 * @author maoning
 */
@Component
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication)
            throws IOException {
        Calendar cl = Calendar.getInstance();
        cl.add(Calendar.MILLISECOND, jwtProperties.getExpiresIn());
        String token = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(cl.getTime())
                .setSubject(authentication.getName())
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
        response.addHeader(jwtProperties.getHeader(), jwtProperties.getTokenPrefix() + " " + token);
        JsonWriter.write(response, ResponseModel.ok(authentication.getPrincipal()));
    }
}
