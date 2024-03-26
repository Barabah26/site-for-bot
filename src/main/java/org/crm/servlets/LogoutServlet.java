package org.crm.servlets;


import org.crm.Auth;
import org.crm.services.FreemarkerService;
import org.crm.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    private final FreemarkerService freemarker;
    private StudentService studentService;

    public LogoutServlet(FreemarkerService freemarker, StudentService studentService) {
        this.freemarker = freemarker;
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Auth.clearCookie(resp);
        studentService.clearStudentList();
        resp.sendRedirect("/login");
    }
}
