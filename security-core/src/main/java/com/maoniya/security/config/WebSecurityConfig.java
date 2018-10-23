package security.config;

import security.authentication.AuthenticationConfigManager;
import security.authorize.AuthorizeConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * describe:
 *
 * @author maoniya.com
 * @date 2018/10/19
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private AuthenticationConfigManager authenticationConfigManager;

    /**
     * 重写默认的HttpSecurity配置
     * @param http
     * @throws Exception
     */
    protected void configure(HttpSecurity http) throws Exception {
        HttpSecurityWrap.create(http)
                .authorizeManager(authorizeConfigManager)
                .authenticationManager(authenticationConfigManager);
    }

}
