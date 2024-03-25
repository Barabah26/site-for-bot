package org.crm;

import org.crm.dao.CollectionAdminDAO;
import org.crm.services.AdminService;
import org.crm.services.FreemarkerService;
import org.crm.servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    private static final String DIR_TEMPLATES_NAME = "templates";
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        Connection conn = null;

        try {
            conn = Database.mkConn();
        } catch (SQLException e) {
            System.out.println("Error connection to DB");
        }

        CollectionAdminDAO collectionAdminDAO = new CollectionAdminDAO(conn);
        AdminService adminService = new AdminService(collectionAdminDAO);

        FreemarkerService freemarkerService = new FreemarkerService(DIR_TEMPLATES_NAME);

        ServletContextHandler handler = new ServletContextHandler();

        HttpServlet cssServlet = new CssServlet("templates/css");
        HttpServlet loginServlet = new LoginServlet(freemarkerService, adminService);
        HttpServlet studentsServlet = new StudentsServlet(freemarkerService);
        HttpServlet logoutServlet = new LogoutServlet(freemarkerService);



        handler.addServlet(new ServletHolder(cssServlet), "/css/*");
        handler.addServlet(new ServletHolder(loginServlet), "/login/*");
        handler.addServlet(new ServletHolder(studentsServlet), "/students/*");
        handler.addServlet(new ServletHolder(logoutServlet), "/logout/*");
        handler.addServlet(RedirectServlet.class, "/*");


        server.setHandler(handler);
        server.start();
        server.join();

    }
}
