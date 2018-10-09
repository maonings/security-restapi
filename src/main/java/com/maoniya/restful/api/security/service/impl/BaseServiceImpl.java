package com.maoniya.restful.api.security.service.impl;

import com.maoniya.restful.api.security.service.BaseService;
import com.maoniya.restful.api.security.dao.BaseMapper;
import com.maoniya.restful.api.security.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * date:  Created in 2018/9/27 18:28
 *
 * @author maoning
 */
@Service
public class BaseServiceImpl<E extends Serializable, ID> implements BaseService<E, ID> {

    @Autowired
    private BaseMapper<E, ID> baseMapper;

    @Override
    public void insert(E e) {
        baseMapper.insert(e);
    }

    @Override
    public void delete(ID id) {
        baseMapper.delete(id);
    }

    @Override
    public void update(E e) {
        baseMapper.update(e);
    }

    @Override
    public E findOne(E e) {
        return baseMapper.findOne(e);
    }

    @Override
    public List<E> listAll() {
        return listAll(null);
    }

    @Override
    public List<E> listAll(E e) {
        return baseMapper.listAll(e);
    }
}
