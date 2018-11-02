/*
 * *************************************************************************
 * Copyright (C) Wolters Kluwer Financial Services. All rights reserved.
 *
 * This computer program is protected by copyright law and international 
 * treaties. Unauthorized reproduction or distribution of this program, 
 * or any portion of it, may result in severe civil and criminal penalties, 
 * and will be prosecuted to the maximum extent possible under the law.
 * *************************************************************************
 */
package edu.codespring.blog.dao;

import edu.codespring.blog.model.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {

    void create(T t);

    List<T> findAll();

    T findById(Long id);

    void delete(Long id);


}
