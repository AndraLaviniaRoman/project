package edu.codespring.blog.dao;

import edu.codespring.blog.model.BaseEntity;

import java.util.List;

/**
 * General "data access object" interface.
 * Provides common CRUD methods for entities.
 */
public interface Dao<T extends BaseEntity> {

    void create(T obj) throws RepositoryException;

    List<T> findAll() throws RepositoryException;

    T findById(Long id) throws RepositoryException;

    // ...
}
