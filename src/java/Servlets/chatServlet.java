package Servlets;


import DTOs.User;
import DTOs.chatDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gehad
 */
@WebServlet(name = "chatServlet", urlPatterns = {"/chatServlet"})
public class chatServlet extends HttpServlet {

    static ArrayList<chatDTO> mychat = new ArrayList<>();
    chatDTO newMsg;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //   PrintWriter out = response.getWriter();
        newMsg = new chatDTO();
        String name =  (String) request.getSession(false).getAttribute("username");
        String id = request.getSession().getId();
        System.err.println(id);
        newMsg.setName(name);
        System.err.println(name);
        newMsg.setMessage(request.getParameter("msg"));
        mychat.add(newMsg);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ArrayList<String> messages = new ArrayList<>();
        for (chatDTO chat : mychat) {
            messages.add(builGsonFromObject(chat));
        }

        out.print(messages);
      //  mychat.clear();
        messages.clear();
    }

    private String builGsonFromObject(chatDTO chDTO) {
        Gson myGson = new Gson();
        return myGson.toJson(chDTO);
    }

}
