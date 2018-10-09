package com.maoniya.restful.api.security.service.impl;

import com.maoniya.restful.api.security.service.UserService;
import com.maoniya.restful.api.security.entity.User;
import com.maoniya.restful.api.security.service.UserService;
import org.springframework.stereotype.Service;

/**
 * date:  Created in 2018/9/27 18:26
 *
 * @author maoning
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

    @Override
    public User findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return findOne(user);
    }
}
