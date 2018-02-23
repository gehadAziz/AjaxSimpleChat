/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTOs.User;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gehad
 */
@WebServlet(name = "CurrentSession", urlPatterns = {"/CurrentSession"})
public class CurrentSession extends  HttpServlet{
    public static ArrayList<User> activeUsers = new ArrayList<>();
    public static ArrayList<User> allUsers = new ArrayList<>();
    public static int uID=1;
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //return active users
        Gson gsonMessage = new Gson();
        String activeUsersObject = gsonMessage.toJson(activeUsers);
        PrintWriter out = response.getWriter();
        out.write(activeUsersObject);
        out.close();
    }
}
