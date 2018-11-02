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
package edu.codespring.blog.service;

import edu.codespring.blog.model.BlogPost;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@ApplicationScoped
@Path("blog")
public class BlogRestService {

    @Inject
    private BlogPostService blogPostService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public void createBlogPost(BlogPost blogPost) {

        blogPostService.createBlogPost(blogPost);
    }

    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBlogPost() {

        final List<BlogPost> allBlogPosts = blogPostService.findAllBlogPosts();
        return Response.ok().entity(allBlogPosts).build();
    }

    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlogPost(@PathParam("id") Long id) {
        final BlogPost blogPost = blogPostService.findBlogPostById(id);

        return Response.status(Status.OK).type(MediaType.APPLICATION_JSON)
                       .entity(blogPost).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "HelloWorldBlogPost";
    }
}