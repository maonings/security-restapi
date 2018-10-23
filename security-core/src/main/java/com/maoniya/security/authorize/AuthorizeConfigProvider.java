package security.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * AuthorizeConfigProvider.java
 *
 * @author maoning
 *
 * @date 2018-10-17 23:56
 */
public interface AuthorizeConfigProvider {

    /**
     * 配置URL认证规则
     *
     * @param config
     * @return  返回的boolean表示配置中是否有针对anyRequest的配置。在整个授权配置中，
     *          应该有且仅有一个针对anyRequest的配置，如果所有的实现都没有针对anyRequest的配置，
     *          系统会自动增加一个anyRequest().authenticated()的配置。如果有多个针对anyRequest
     *          的配置，则会抛出异常。
     */
    boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) throws Exception;

}
