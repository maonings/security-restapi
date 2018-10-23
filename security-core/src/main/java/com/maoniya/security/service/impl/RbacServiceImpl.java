package security.service.impl;

import security.authorize.AuthorizeService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * describe: 基于角色的权限认证处理
 *
 * @author maoniya.com
 * @date 2018/10/23
 */
@Service
public class RbacServiceImpl implements AuthorizeService {

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        System.out.println("into RbacService。。。");
        User user = (User) authentication.getPrincipal();
        if (user != null) {
            System.out.println(user);
            return true;
        }
        return false;
    }
}
