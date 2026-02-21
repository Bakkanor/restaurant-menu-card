package com.jsp.servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsp.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        // Programmatic Hibernate configuration
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/LoginPage");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");

        // Add annotated classes
        configuration.addAnnotatedClass(User.class);

        // Build the SessionFactory
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;
        try (Session session = sessionFactory.openSession()) {
            // Fetch user from the database
            user = session.createQuery("FROM User WHERE username = :username AND password = :password", User.class)
                          .setParameter("username", username)
                          .setParameter("password", password) // In a real application, hash the password and compare
                          .uniqueResult();
        }

        if (user != null) {
            // User found, create a session
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user);
            response.sendRedirect("home.html"); // Redirect to profile page
        } else {
            response.getWriter().println("<html><body><h1 style='color:red; font-size: 50px; margin-bottom: 600px; margin-left:10px; text-align:center;'>Invalid Credentials! Please Try Again </h1></body></html>");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        
    }

    @Override
    public void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
