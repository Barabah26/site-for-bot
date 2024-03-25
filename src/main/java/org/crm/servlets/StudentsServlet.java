package org.crm.servlets;

import org.crm.services.FreemarkerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class StudentsServlet extends HttpServlet {

    private FreemarkerService freemarker;

    public StudentsServlet(FreemarkerService freemarker) {
        this.freemarker = freemarker;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> usersForRender = new HashMap<>();
        try (PrintWriter w = resp.getWriter()) {
            freemarker.render("main-page.ftl", usersForRender, w);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
