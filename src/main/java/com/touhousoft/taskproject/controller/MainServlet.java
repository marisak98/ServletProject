package com.touhousoft.taskproject.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import java.io.IOException;

/**
 * MainServlet
 */
@WebServlet("/main/")
public class MainServlet extends HttpServlet {

  String pathDashboard = "/jsp/app/dashboard.jsp";
  String pathProfile = "/jsp/app/profile.jsp";
  String pathProject = "/jsp/app/project.jsp";
  String pathEmployee = "/jsp/app/employee.jsp";
  String pathReport = "/jsp/app/report.jsp";
  String pathSetting = "/jsp/app/settings.jsp";
  String pathLogout = "/index.jsp";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    if (request.getSession().getAttribute("usuario") == null) {
      response.sendRedirect(request.getContextPath() + "/index.jsp");
      return;
    }

    String path = request.getPathInfo();

    if (path == null || path.equals("/")) {
      request.setAttribute("page", pathDashboard);
      request.getRequestDispatcher("/jsp/sidebar/layout.jsp").forward(request, response);
    } else if (path.equals("/dashboard")) {
      request.setAttribute("page", pathDashboard);
      request.getRequestDispatcher("/jsp/sidebar/layout.jsp").forward(request, response);
    } else if (path.equals("/profile")) {
      request.setAttribute("page", pathProfile);
      request.getRequestDispatcher("/jsp/sidebar/layout.jsp").forward(request, response);
    } else if (path.equals("/project")) {
      request.setAttribute("page", pathProject);
      request.getRequestDispatcher("/jsp/sidebar/layout.jsp").forward(request, response);
    } else if (path.equals("/employee")) {
      request.setAttribute("page", pathEmployee);
      request.getRequestDispatcher("/jsp/sidebar/layout.jsp").forward(request, response);
    } else if (path.equals("/report")) {
      request.setAttribute("page", pathReport);
      request.getRequestDispatcher("/jsp/sidebar/layout.jsp").forward(request, response);
    } else if (path.equals("/settings")) {
      request.setAttribute("page", pathSetting);
      request.getRequestDispatcher("/jsp/sidebar/layout.jsp").forward(request, response);
    } else if (path.equals("/logout")) {
      request.getRequestDispatcher(pathLogout).forward(request, response);
    } else {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }
}
