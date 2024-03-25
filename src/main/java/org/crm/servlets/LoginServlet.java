package org.crm.servlets;

import org.crm.Admin;
import org.crm.Auth;
import org.crm.services.AdminService;
import org.crm.services.FreemarkerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Optional;

public class LoginServlet extends HttpServlet {
    private final FreemarkerService freemarker;
    private boolean isLoginValid = true;
    private AdminService adminService;
    public LoginServlet(FreemarkerService freemarker, AdminService adminService) {
        this.freemarker = freemarker;
        this.adminService = adminService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> usersForRender = new HashMap<>();
        String massage = isLoginValid ? "" : "Incorrect login or password";
        usersForRender.put("errorMassage", massage);

        try (PrintWriter w = resp.getWriter()) {
            freemarker.render("login.ftl", usersForRender, w);
        }
        isLoginValid = true;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        adminService.getAdminByLoginAndPasswordFromDB(login, password);

        Optional<Admin> admin = adminService.getAdminByLoginAndPassword(login, password);

        if (admin.isEmpty()){
            isLoginValid = false;
            resp.sendRedirect("/login");
        } else if (login.equals(admin.get().getLogin()) && password.equals(admin.get().getPassword())) {
            Auth.setCookieValue(String.valueOf(admin.get().getId()), resp);
            resp.sendRedirect("/main-page");
        }

    }
}
