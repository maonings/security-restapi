package com.maoniya.restful.api.security.web.controller;

import com.maoniya.restful.api.security.service.RoleService;
import com.maoniya.restful.api.security.entity.Role;
import com.maoniya.restful.api.security.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * date:  Created in 2018/9/28 14:33
 *
 * @author maoning
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public ResponseModel findByID(@PathVariable int id) {
        Role role = roleService.findByID(id);
        return new ResponseModel(role);
    }

    @GetMapping
    public ResponseModel listAll() {
        return new ResponseModel(roleService.listAll());
    }
}
