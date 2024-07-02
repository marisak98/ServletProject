package com.touhousoft.taskproject.controller;

import com.touhousoft.taskproject.model.DAOUser;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ConexionServlet
 */
@WebServlet("/conexion")
public class ConexionServlet extends HttpServlet {

  String interfaz = "/index.jsp";
  String jdbcUrl;
  String jdbcUsername;
  String jdbcPassword;

  DAOUser dao;
  String error = null;
  String dbmessage = null;

  public void init() throws ServletException {
    ServletContext context = getServletContext();
    jdbcUrl = context.getInitParameter("jdbcUrl");
    jdbcUsername = context.getInitParameter("jdbcUsername");
    jdbcPassword = context.getInitParameter("jdbcPassword");
    try {
      // Inicializar el objeto DAOpersona con los parámetros obtenidos
      dao = new DAOUser(jdbcUrl, jdbcUsername, jdbcPassword);
      System.out.println("Conectado");
      dbmessage = "Conectado a la base de datos";
    } catch (Exception ex) {
      Logger.getLogger(ConexionServlet.class.getName()).log(Level.SEVERE, null, ex);
      throw new ServletException("Error al inicializar el servlet", ex);
    }

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");
    response.getWriter().write(jdbcUrl + jdbcUsername + jdbcPassword);
    response.getWriter().write("");
    response.getWriter().write(dbmessage);

    request.setAttribute("dbmessage", dbmessage);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
