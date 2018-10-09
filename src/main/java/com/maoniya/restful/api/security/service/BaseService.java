package com.maoniya.restful.api.security.service;

import java.io.Serializable;
import java.util.List;

/**
 * date:  Created in 2018/9/27 18:28
 *
 * @author maoning
 */
public interface BaseService<E extends Serializable, ID> {

    /**
     * 新增
     * @param e
     */
    void insert(E e);

    /**
     * 删除
     * @param id
     */
    void delete(ID id);

    /**
     * 修改
     * @param e
     */
    void update(E e);

    /**
     * 根据E查询
     * @param e
     * @return
     */
    E findOne(E e);

    /**
     * 查询全部
     * @return
     */
    List<E> listAll();

    /**
     * 根据参数查询
     * @param e
     * @return
     */
    List<E> listAll(E e);
}
