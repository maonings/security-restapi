package com.maoniya.restful.api.security.service.impl;

import com.maoniya.restful.api.security.entity.Role;
import com.maoniya.restful.api.security.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * date:  Created in 2018/9/27 18:26
 *
 * @author maoning
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements RoleService {

    @Override
    public Role findByID(int id) {
        Role role = new Role();
        role.setId(id);
        return findOne(role);
    }
}
