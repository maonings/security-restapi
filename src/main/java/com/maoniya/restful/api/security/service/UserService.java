package com.maoniya.restful.api.security.service;

import com.maoniya.restful.api.security.entity.User;

/**
 * date:  Created in 2018/9/27 18:20
 *
 * @author maoning
 */
public interface UserService extends BaseService<User, Integer> {

    User findByUsername(String username);

}
