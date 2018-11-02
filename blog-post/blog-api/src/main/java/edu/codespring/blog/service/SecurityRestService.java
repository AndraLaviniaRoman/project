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

import edu.codespring.blog.dto.LoginDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
@Path("security")
public class SecurityRestService {

    @Inject
    private HttpServletRequest httpServletRequest;

    @Inject
    private HttpSession httpSession;

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO loginDTO) throws ServletException {
        if (httpServletRequest.getUserPrincipal() != null) {
            return Response.ok().entity("Already logged in").build();
        }
        try {
            httpServletRequest.login(loginDTO.getUser(), loginDTO.getPassword());
        }
        catch (final ServletException e) {
            return Response.status(Status.UNAUTHORIZED).build();
        }

        return Response.ok().entity("Succesfully logged in").build();
    }

    @Path("logout")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() throws ServletException {

        httpServletRequest.logout();
        httpSession.invalidate();
        return Response.ok().entity("Succesfully logged out").build();
    }
}