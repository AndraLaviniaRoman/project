package edu.codespring.blog.dao;

import edu.codespring.blog.model.BlogPost;

import java.util.Collection;

public interface BlogPostDao extends Dao<BlogPost> {

    // CRUD methods specific to this entity
    Collection<BlogPost> findByTitle(String title);


}
