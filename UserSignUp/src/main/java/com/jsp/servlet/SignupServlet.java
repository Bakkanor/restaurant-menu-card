package com.jsp.servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        // Programmatic  configuration
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
         configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://dpg-d6crach5pdvs73f93pcg-a:5432/restaurant_sbm3");
        configuration.setProperty("hibernate.connection.username", "restaurant_user");
        configuration.setProperty("hibernate.connection.password", "qvaq0YwP70ShVopCOpoJBtPMD04WMaRu");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "true");

        // Add annotated classes
        configuration.addAnnotatedClass(User.class);

        // Build the SessionFactory
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password); // In a real application, hash the password before storing it

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
        	
        	 transaction = session.beginTransaction();
             session.save(user);
             session.persist(user);
             transaction.commit();
             response.getWriter().println("<html><body><h1 style=color:green;> Account Is Created Successfully! Try To Login</h1></body></html><br>");
             request.getRequestDispatcher("login.jsp").include(request, response);
         } catch (Exception e) {
             if (transaction != null) {
                 transaction.rollback();
             }
             e.printStackTrace();
             response.getWriter().println("<html><body><h1>Error occured while storing data into the database </h1></body></html>");
         }
         init();
     }

     @Override
     public void destroy() {
         if (sessionFactory != null) {
             sessionFactory.close();
         }
     }

 }
