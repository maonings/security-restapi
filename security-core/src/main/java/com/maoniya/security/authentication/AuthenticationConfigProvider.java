package security.authentication;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * describe:
 *
 * @author maoniya.com
 * @date 2018/10/19
 */
public interface AuthenticationConfigProvider {

    void config(HttpSecurity http) throws Exception;

}
