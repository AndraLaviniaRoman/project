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

import edu.codespring.blog.model.BlogPost;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class BaseDaoImpl implements BlogPostDao {

    @PersistenceContext(unitName = "blogPu")
    private EntityManager entityManager;

    public BaseDaoImpl() {

    }

    @Override
    public void create(BlogPost obj) {
        entityManager.persist(obj);
    }

    @Override
    public List<BlogPost> findAll() {
        return entityManager.createQuery("from " + BlogPost.class.getName(), BlogPost.class).getResultList();
    }

    @Override
    public BlogPost findById(Long id) {
        return entityManager.find(BlogPost.class, id);
    }

    @Override
    public Collection<BlogPost> findByTitle(String title) {
        return null;
    }
}