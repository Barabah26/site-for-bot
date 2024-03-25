package org.crm.servlets;


import org.crm.Auth;
import org.crm.services.FreemarkerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    private final FreemarkerService freemarker;

    public LogoutServlet(FreemarkerService freemarker) {
        this.freemarker = freemarker;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Auth.clearCookie(resp);
        resp.sendRedirect("/login");
    }
}
