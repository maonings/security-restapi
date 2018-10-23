package security.config;

import security.authentication.AuthenticationConfigManager;
import security.authorize.AuthorizeConfigManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * describe:
 *
 * @author maoniya.com
 * @date 2018/10/22
 */
public final class HttpSecurityWrap {

    private HttpSecurity http;

    private HttpSecurityWrap(HttpSecurity http) {
        this.http = http;
    }

    public static HttpSecurityWrap create(HttpSecurity http) {
        return new HttpSecurityWrap(http);
    }

    public HttpSecurityWrap authenticationManager(AuthenticationConfigManager authenticationConfigManager)
            throws Exception {
        authenticationConfigManager.config(http);
        return this;
    }

    public HttpSecurityWrap authorizeManager(AuthorizeConfigManager authorizeConfigManager)
            throws Exception {
        authorizeConfigManager.config(http.authorizeRequests());
        return this;
    }
}
