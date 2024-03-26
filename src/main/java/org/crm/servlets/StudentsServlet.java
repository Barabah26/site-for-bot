package org.crm.servlets;

import org.crm.Admin;
import org.crm.Auth;
import org.crm.Student;
import org.crm.services.AdminService;
import org.crm.services.FreemarkerService;
import org.crm.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class StudentsServlet extends HttpServlet {

    private StudentService studentService;
    private AdminService adminService;
    private FreemarkerService freemarker;

    public StudentsServlet(FreemarkerService freemarker, AdminService adminService, StudentService studentService) {
        this.freemarker = freemarker;
        this.adminService = adminService;
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> usersForRender = new HashMap<>();
        Optional<String> getAdmin = Auth.getCookieValue(req);
        String adminUsername = "";

        if (getAdmin.isPresent()) {
            String adminId = getAdmin.get();
            Optional<Admin> adminOptional = adminService.getAdminById(Long.parseLong(adminId));
            adminUsername = adminOptional.map(Admin::getUsername).orElse("Не знайдено імені");
        }

        List<Student> students = studentService.getAllStudentsFromDB();
        usersForRender.put("adminIN", adminUsername);
        usersForRender.put("students", students); // Передача списку студентів у шаблон

        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter w = resp.getWriter()) {
            freemarker.render("main-page.ftl", usersForRender, w);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentIdParam = req.getParameter("studentId");

        if (studentIdParam != null) {
            long studentId = Long.parseLong(studentIdParam);
            studentService.updateStatus(studentId);
        }

        studentService.clearStudentList();
        resp.sendRedirect("/students");
    }


}
