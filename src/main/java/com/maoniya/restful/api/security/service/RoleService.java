package com.maoniya.restful.api.security.service;

import com.maoniya.restful.api.security.entity.Role;

/**
 * date:  Created in 2018/9/27 18:20
 *
 * @author maoning
 */
public interface RoleService extends BaseService<Role, Integer> {

    /**
     * 根据ID查询Role
     * @param id
     * @return
     */
    Role findByID(int id);

}
