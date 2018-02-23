package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DTOs.User;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gehad
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
         // PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean found = false;
        for (User user : CurrentSession.allUsers) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                CurrentSession.activeUsers.add(user);
                HttpSession session = request.getSession(true);
                session.setAttribute("username", username);
                response.sendRedirect("home.html");
                found = true;
                break;
            }
        }
        if (found == false) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
         //   out.print("<h1 class=\"underlineHover\" href=\"signup.html\">Invalid user name or password</h1>\n" );
              dispatcher.include(request, response);
             response.getOutputStream().print("<h1  id='formContent2' align=\"center\" class=\"underlineHover\" href=\"#\">Invalid user name or password</h1>\n");

        }
        
    }
}
