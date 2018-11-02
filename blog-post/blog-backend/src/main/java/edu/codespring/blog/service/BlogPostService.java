package edu.codespring.blog.service;

import edu.codespring.blog.model.BlogPost;

import java.util.Collection;
import java.util.List;

public interface BlogPostService {

    List<BlogPost> findAllBlogPosts() throws ServiceException;

    BlogPost findBlogPostById(Long id) throws ServiceException;

    void createBlogPost(BlogPost blogPost) throws ServiceException;

    Collection<BlogPost> findBlogPostByTitle(String title) throws ServiceException;
}
