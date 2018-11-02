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
package edu.codespring.blog;

import edu.codespring.blog.model.BlogPost;
import org.h2.tools.Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Date;

public class MainClass {


    public static void main(String[] args) throws SQLException {


        Server server = new Server();
        server.createTcpServer(new String[] {"-tcpPort", "8092", "-tcpAllowOthers" }).start();
        server.run();

        final BlogPost blogPost = new BlogPost();
        blogPost.setContent("content1");
        blogPost.setTitle("title");
        blogPost.setUploadDate(new Date());
        blogPost.setWriter("andra");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blogPuLocal");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(blogPost);
        em.getTransaction().commit();

        BlogPost blogPost1 = em.find(BlogPost.class, blogPost.getId());

        System.out.println("Blog post added:" + blogPost1.getTitle());

        em.close();
        emf.close();

    }
}