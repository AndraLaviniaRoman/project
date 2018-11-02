package edu.codespring.blog.service.impl;

import edu.codespring.blog.dao.BlogPostDao;
import edu.codespring.blog.dao.RepositoryException;
import edu.codespring.blog.model.BlogPost;
import edu.codespring.blog.service.BlogPostService;
import edu.codespring.blog.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
//@ApplicationScoped

@Stateless
@DeclareRoles("user-role")
public class BlogPostServiceImpl implements BlogPostService {
    private static final Logger LOG = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    // sure is ugly to initialize a dependency here
    // I wonder if there is a more elegant way...
    @Inject
    private BlogPostDao blogPostDao;

    @Override
    @PermitAll
    public List<BlogPost> findAllBlogPosts() throws ServiceException {
        try {
            return blogPostDao.findAll();
        }
        catch (RepositoryException e) {
            LOG.error("findAllBlogPosts failed", e);
            throw new ServiceException("findAllBlogPosts failed", e);
        }
    }

    @Override
    public BlogPost findBlogPostById(Long id) throws ServiceException {
        try {
            return blogPostDao.findById(id);
        }
        catch (RepositoryException e) {
            LOG.error("findBlogPostById failed", e);
            throw new ServiceException("findBlogPostById failed", e);
        }
    }

    @Override
    @RolesAllowed("user-role")
    public void createBlogPost(BlogPost blogPost) throws ServiceException {
        try {

            blogPostDao.create(blogPost);
        }
        catch (RepositoryException e) {
            LOG.error("createBlogPost failed", e);
            throw new ServiceException("createBlogPost failed", e);
        }
    }

    @Override
    public Collection<BlogPost> findBlogPostByTitle(String title) throws ServiceException {
        //        try {
        //            return baseDao.findByTitle(title);
        //        } catch (RepositoryException e) {
        //            LOG.error("findBlogPostByTitle failed", e);
        //            throw new ServiceException("findBlogPostByTitle failed", e);
        //        }
        return null;
    }
}
