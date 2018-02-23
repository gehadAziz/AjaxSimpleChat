/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTOs.User;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet{
      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User newUser = new User();
        newUser.setName(username);
        newUser.setPassword(password);
        newUser.setId(CurrentSession.uID);
        CurrentSession.uID++;
        CurrentSession.allUsers.add(newUser);
        CurrentSession.activeUsers.add(newUser);
        
        HttpSession session = request.getSession(true);
        
        session.setAttribute("username",username);
        response.sendRedirect("home.html");
        
    }
    
}
