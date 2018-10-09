package com.maoniya.restful.api.security.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * date:  Created in 2018/9/27 17:29
 *
 * @author maoning
 */
@Repository
public interface BaseMapper<E extends Serializable, ID> {

    void insert(E e);

    void delete(ID id);

    void update(E e);

    E findOne(E e);

    List<E> listAll(E e);

}
