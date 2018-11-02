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

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Date;

@Singleton
@Startup
public class Initializer {

    @Inject
    private BlogPostDao blogPostDao;

    @PostConstruct
    public void init()
    {
        BlogPost blogPost = new BlogPost();
        blogPost.setContent("content1");
        blogPost.setTitle("title");
        blogPost.setUploadDate(new Date());
        blogPost.setWriter("andra");
        blogPostDao.create(blogPost);
    }
}