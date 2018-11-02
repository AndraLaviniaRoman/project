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
package edu.codespring.blog.dto;

public class LoginDTO {

    private String user;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}