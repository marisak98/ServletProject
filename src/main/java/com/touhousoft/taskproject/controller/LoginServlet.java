package com.touhousoft.taskproject.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;

import com.touhousoft.taskproject.model.usuario;
import com.touhousoft.taskproject.service.UserService;

/**
 * LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private UserService userService = new UserService();

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.sendRedirect(request.getContextPath() + "/index.jsp");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String user = request.getParameter("email");
    String password = request.getParameter("password");
    Long idMiembro = null;

    usuario users = new usuario(user, password, idMiembro);

    if (userService.isValid(users)) {
      request.getSession().setAttribute("usuario", users);
      response.sendRedirect(request.getContextPath() + "/main/dashboard");
    } else {
      int intentosRestantes = userService.isBlocked();
      request.setAttribute("mensaje", "Credenciales incorrectas, intentos restantes: " + intentosRestantes);
      request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
  }
}
