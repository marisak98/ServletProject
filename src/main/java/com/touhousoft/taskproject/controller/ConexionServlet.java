package com.touhousoft.taskproject.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.touhousoft.taskproject.model.DAOMiembroEquipo;
import com.touhousoft.taskproject.model.DAOProyectos;
import com.touhousoft.taskproject.model.DAOTareas;
import com.touhousoft.taskproject.model.DAOUser;
import com.touhousoft.taskproject.model.Estado;
import com.touhousoft.taskproject.model.MiembroEquipo;
import com.touhousoft.taskproject.model.Proyectos;
import com.touhousoft.taskproject.model.Tareas;
import com.touhousoft.taskproject.model.usuario;
import com.touhousoft.taskproject.utils.LocalDataAdapter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.*;

/**
 * ConexionServlet
 */
@WebServlet("/conexion/*")
public class ConexionServlet extends HttpServlet {

  private String jdbcUrl;
  private String jdbcUsername;
  private String jdbcPassword;
  private DAOUser dao;
  private DAOProyectos daoProyectos;
  String InterfazProyectos = "/jsp/app/project.jsp";
  String miembrosInterfaz = "/jsp/app/profile.jsp";

  @Override
  public void init() throws ServletException {
    ServletContext context = getServletContext();
    jdbcUrl = context.getInitParameter("jdbcUrl");
    jdbcUsername = context.getInitParameter("jdbcUsername");
    jdbcPassword = context.getInitParameter("jdbcPassword");
    try {
      dao = new DAOUser(jdbcUrl, jdbcUsername, jdbcPassword);
      daoProyectos = new DAOProyectos(jdbcUrl, jdbcUsername, jdbcPassword); // Inicializar daoProyectos aquí
    } catch (Exception ex) {
      throw new ServletException("Error al inicializar el servlet", ex);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    updateTask(request, response);
  }

  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getPathInfo();
    Long id = null;

    // Verifica si la ruta es /task/getTarea/ID
    if (action != null && action.matches("/task/getTarea/\\d+")) {
      id = Long.parseLong(action.substring(action.lastIndexOf("/") + 1));
      action = "/task/getTarea"; // Para manejar con el case del switch
    } else if (action != null && action.matches("/task/delete/\\d+")) {
      id = Long.parseLong(action.substring(action.lastIndexOf("/") + 1));
      action = "/task/delete";
    } else if (action != null && action.matches("/member/getMember/\\d+")) {
      id = Long.parseLong(action.substring(action.lastIndexOf("/") + 1));
      action = "/member/getMember";
    } else if (action != null && action.matches("/member/delete/\\d+")) {
      id = Long.parseLong(action.substring(action.lastIndexOf("/") + 1));
      action = "/member/delete";
    } else if (action != null && action.matches("/project/getProject/\\d+")) {
      id = Long.parseLong(action.substring(action.lastIndexOf("/") + 1));
      action = "/project/getProject";
    } else if (action != null && action.matches("/project/delete/\\d+")) {
      id = Long.parseLong(action.substring(action.lastIndexOf("/") + 1));
      action = "/project/delete";
    }

    if (action == null) {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    switch (action) {
      case "/project/save":
        saveProject(request, response);
        break;
      case "/project/all":
        getAllProjects(request, response);
        break;
      case "/project/getProject":
        if (id != null) {
          getProjectById(request, response, id);
        } else {
          response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing ID for edit");
        }
        break;
      case "/project/update":
        updateProject(request, response);
        break;
      case "/project/delete":
        if (id != null) {
          deleteProject(request, response, id);
        } else {
          response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing ID for edit");
        }
        break;
      case "/member/save":
        saveMiembrosEq(request, response);
        break;
      case "/member/all":
        getAllMembers(request, response);
        break;
      case "/member/update":
        updateMiembrosEq(request, response);
        break;
      case "/member/getMember":
        if (id != null) {
          getMiembrosEquipoById(request, response, id);
        } else {
          response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing ID for edit");
        }
        break;
      case "/member/delete":
        if (id != null) {
          deleteMiembrosEq(request, response, id);
        } else {
          response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing ID for edit");
        }
        break;
      case "/user/save":
        saveUser(request, response);
        break;
      case "/task/save":
        saveTask(request, response);
        break;
      case "/task/update":
        updateTask(request, response);
        break;
      case "/task/all":
        getAllTasks(request, response);
        break;
      case "/task/getTarea":
        if (id != null) {
          getTaskById(request, response, id);
        } else {
          response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing ID for edit");
        }
        break;
      case "/task/delete":
        if (id != null) {
          deleteTask(request, response, id);
        } else {
          response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing ID for deleteTask");
        }
      default:
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
        break;
    }
  }

  private void saveProject(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    Long id = 0L;
    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");
    LocalDate fechaInicio = parseDate(request.getParameter("fechainicio"));
    LocalDate fechaFin = parseDate(request.getParameter("fechafin"));
    Estado status = Estado.IN_PROGRESS;

    String accion = request.getParameter("accion");

    Proyectos proyecto = new Proyectos(id, nombre, descripcion, fechaInicio, fechaFin, status);
    DAOProyectos daoProyecto = new DAOProyectos(jdbcUrl, jdbcUsername, jdbcPassword);
    boolean isSaved = daoProyecto.registrarProyecto(proyecto);

    if ("Crear".equalsIgnoreCase(accion)) {
      if (isSaved) {
        response.getWriter().write("Proyecto guardado con éxito");
        String message = "Proyecto guardado con exito";

      } else {
        response.getWriter().write("Error al guardar el proyecto");
      }
    } else {
      response.getWriter().write("Acción desconocida");
    }
  }

  private LocalDate parseDate(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return LocalDate.parse(date, formatter);
  }

  private void getAllProjects(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ArrayList<Proyectos> proyectos = daoProyectos.getAllProjects();

    Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDataAdapter()).create();

    String json = gson.toJson(proyectos);
    response.setContentType("application/json");
    response.getWriter().write(json);
  }

  private void getProjectById(HttpServletRequest request, HttpServletResponse response, Long id)
      throws ServletException, IOException {
    DAOProyectos daoProyectos = new DAOProyectos(jdbcUrl, jdbcUsername, jdbcPassword);
    Proyectos proyecto = daoProyectos.getProyectoById(id);

    if (proyecto != null) {
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");

      Gson gson = new GsonBuilder()
          .registerTypeAdapter(LocalDate.class, new LocalDataAdapter())
          .create();
      String json = gson.toJson(proyecto);
      response.getWriter().write(json);
    } else {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  public void updateProject(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String idParam = request.getParameter("id");
    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");
    LocalDate fechaInicio = parseDate(request.getParameter("fechaInicio"));
    LocalDate fechaFin = parseDate(request.getParameter("fechaFin"));
    Estado status = Estado.COMPLETED;
    String accion = request.getParameter("accion");

    if (idParam == null || idParam.isEmpty()) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
      return;
    }

    Long id;
    try {
      id = Long.parseLong(idParam);
    } catch (NumberFormatException e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
      return;
    }

    Proyectos proyecto = new Proyectos(id,
        nombre,
        descripcion,
        fechaInicio,
        fechaFin,
        status);
    DAOProyectos daoProyectos = new DAOProyectos(jdbcUrl, jdbcUsername, jdbcPassword);
    boolean isUpdate = daoProyectos.updateProyecto(proyecto);

    if ("Actualizar".equalsIgnoreCase(accion)) {
      if (isUpdate) {
        response.getWriter().write("Proyecto actualizada con exito");
      } else {
        response.getWriter().write("Error al actualizar el proyecto");
      }

    }

  }

  public void deleteProject(HttpServletRequest request, HttpServletResponse response, Long id)
      throws ServletException, IOException {
    DAOProyectos daoProyectos = new DAOProyectos(jdbcUrl, jdbcUsername, jdbcPassword);
    Proyectos proyectos = daoProyectos.getProyectoById(id);

    if (proyectos != null) {
      boolean isDelete = daoProyectos.deleteProyecto(id);
      if (isDelete) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Proyecto eliminado con exito");
      } else {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el Proyecto");
      }
    } else {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

  }

  /*
   * #############################
   * Miembros Equipo CRUD
   * #############################
   */

  private void saveMiembrosEq(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Long id;
    String nombre;
    String correo;
    String rol;

    id = Long.parseLong(request.getParameter("cedula"));
    nombre = request.getParameter("nombre");
    correo = request.getParameter("correo");
    rol = request.getParameter("rol");
    String accion = request.getParameter("accion");
    String messageConfirm = "";
    String messageError = "";

    MiembroEquipo miembroEquipo = new MiembroEquipo(id, nombre, correo, rol);
    DAOMiembroEquipo daoEq = new DAOMiembroEquipo(jdbcUrl, jdbcUsername, jdbcPassword);

    boolean isSaved = daoEq.registrarMiembroEqipo(miembroEquipo);

    if ("Guardar".equalsIgnoreCase(accion)) {
      if (isSaved) {
        messageConfirm = "Miembro de equipo guardado con exito";
      } else {
        messageError = "Error al guardar el miembro de equipo";
      }
    } else {
      response.getWriter().write("Acción desconocida");
    }

  }

  private void getAllMembers(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    DAOMiembroEquipo daoEquipo = new DAOMiembroEquipo(jdbcUrl, jdbcUsername, jdbcPassword);
    ArrayList<MiembroEquipo> membersList = daoEquipo.getMiembrosEquipo();
    Gson gson = new Gson();
    String json = gson.toJson(membersList);
    response.setContentType("application/json");
    response.getWriter().write(json);

  }

  private void getMiembrosEquipoById(HttpServletRequest request, HttpServletResponse response, Long id)
      throws ServletException, IOException {
    DAOMiembroEquipo daoEq = new DAOMiembroEquipo(jdbcUrl, jdbcUsername, jdbcPassword);
    MiembroEquipo miembroEq = daoEq.getMiembroEquipoById(id);

    if (miembroEq != null) {
      Gson gson = new Gson();
      String json = gson.toJson(miembroEq);
      response.setContentType("application/json");
      response.getWriter().write(json);
    } else {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  private void updateMiembrosEq(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String idParam = request.getParameter("EditId");
    String nombre = request.getParameter("nombre");
    String correo = request.getParameter("correo");
    String rol = request.getParameter("rol");
    String accion = request.getParameter("accion");

    if (idParam == null || idParam.isEmpty()) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID is missing");
      System.out.println(idParam);

      return;
    }
    System.out.println(idParam);
    if (idParam == null || nombre == null || correo == null || rol == null || accion == null) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
      return;
    }

    Long id;
    try {
      id = Long.parseLong(idParam);
    } catch (NumberFormatException e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
      return;
    }

    MiembroEquipo miembroEquipo = new MiembroEquipo(id, nombre, correo, rol);
    DAOMiembroEquipo daoEq = new DAOMiembroEquipo(jdbcUrl, jdbcUsername, jdbcPassword);
    boolean isUpdate = daoEq.updateMiembrosEquipo(miembroEquipo);

    if ("ActualizarM".equalsIgnoreCase(accion)) {
      if (isUpdate) {
        response.getWriter().write("Miembro de equipo actualizado con exito");
      } else {
        response.getWriter().write("Error al actualizar el miembros de equipo");
      }

    }
  }

  public void deleteMiembrosEq(HttpServletRequest request, HttpServletResponse response, Long id)
      throws ServletException, IOException {
    DAOMiembroEquipo daoEq = new DAOMiembroEquipo(jdbcUrl, jdbcUsername, jdbcPassword);
    MiembroEquipo miembrosEquipo = daoEq.getMiembroEquipoById(id);

    if (miembrosEquipo != null) {
      boolean isDelete = daoEq.deleteMiembrosEquipo(id);
      if (isDelete) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Miembros de equipo eliminado con exito");
      } else {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el miembro de equipo");
      }
    } else {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

  }

  /*
   * #############################
   * USUARIOS CRUD
   * #############################
   */

  private void saveUser(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String idMiembroStr = request.getParameter("idMiembro");
    String user = request.getParameter("email");
    String password1 = request.getParameter("password1");
    String password2 = request.getParameter("password2");
    String accion = request.getParameter("accion");

    Long idMiembro = null;
    if (idMiembroStr != null && !idMiembroStr.isEmpty()) {
      try {
        idMiembro = Long.valueOf(idMiembroStr);
      } catch (NumberFormatException e) {
        response.getWriter().write("Cedula inválida");
        return;
      }
    }

    System.out.println(idMiembro);

    if (!password1.equals(password2)) {
      response.getWriter().write("Contraseñas no coinciden");
      return;
    }

    String hashedPassword = BCrypt.withDefaults().hashToString(12, password1.toCharArray());
    usuario users = new usuario(user, hashedPassword, idMiembro);
    DAOUser daoUser = new DAOUser(jdbcUrl, jdbcUsername, jdbcPassword);
    boolean isSaved = dao.registerUser(users);

    if ("Guardar".equalsIgnoreCase(accion)) {
      if (isSaved) {
        response.getWriter().write("Usuario guardado con exito");
      } else {
        response.getWriter().write("Error al guardar el usuario");
      }

    } else {
      response.getWriter().write("Usuario guardado con exito");
    }

  }

  /*
   * #############################
   * TAREAS CRUD
   * #############################
   */

  private void saveTask(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Long id = 0L;
    String nombre = request.getParameter("taskName");
    String descripcion = request.getParameter("taskName");
    LocalDate fechaInicio = parseDate(request.getParameter("taskStartDate"));
    LocalDate fechaFin = parseDate(request.getParameter("taskEndDate"));
    String prioridad = request.getParameter("taskPriority");
    String status = request.getParameter("taskStatus");
    String proyectoIdStr = request.getParameter("projectId");
    String miembroIdStr = request.getParameter("memberId");

    Long proyectoId = null;
    if (proyectoIdStr != null && !proyectoIdStr.isEmpty()) {
      try {
        proyectoId = Long.valueOf(proyectoIdStr);
      } catch (NumberFormatException e) {
        response.getWriter().write("Cedula inválida");
        return;
      }

    }

    Long miembrosId = null;
    if (miembroIdStr != null && !miembroIdStr.isEmpty()) {
      try {
        miembrosId = Long.valueOf(miembroIdStr);
      } catch (NumberFormatException e) {
        response.getWriter().write("Cedula inválida");
        return;
      }
    }

    Tareas tareas = new Tareas(id,
        nombre,
        descripcion,
        fechaInicio,
        fechaFin,
        prioridad,
        status,
        proyectoId,
        miembrosId);
    DAOTareas daoTareas = new DAOTareas(jdbcUrl, jdbcUsername, jdbcPassword);

    boolean isSaved = daoTareas.registerTarea(tareas);

    if (isSaved) {
      response.getWriter().write("Tarea guardada con exito");
    } else {
      response.getWriter().write("Error al guardar la tarea");
    }
  }

  private void getAllTasks(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    DAOTareas daoTareas = new DAOTareas(jdbcUrl, jdbcUsername, jdbcPassword);
    ArrayList<Tareas> tareasList = daoTareas.getTareas();

    Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDataAdapter()).create();

    String json = gson.toJson(tareasList);
    response.setContentType("application/json");
    response.getWriter().write(json);
  }

  private void getTaskById(HttpServletRequest request, HttpServletResponse response, Long id)
      throws ServletException, IOException {
    DAOTareas daoTareas = new DAOTareas(jdbcUrl, jdbcUsername, jdbcPassword);
    Tareas tarea = daoTareas.getTareaById(id);

    if (tarea != null) {
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");

      Gson gson = new GsonBuilder()
          .registerTypeAdapter(LocalDate.class, new LocalDataAdapter())
          .create();
      String json = gson.toJson(tarea);
      response.getWriter().write(json);
    } else {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  public void updateTask(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Long id = 0L;
    String nombre = request.getParameter("taskName");
    String descripcion = request.getParameter("taskName");
    LocalDate fechaInicio = parseDate(request.getParameter("taskStartDate"));
    LocalDate fechaFin = parseDate(request.getParameter("taskEndDate"));
    String prioridad = request.getParameter("taskPriority");
    String status = request.getParameter("taskStatus");
    String proyectoIdStr = request.getParameter("projectId");
    String miembroIdStr = request.getParameter("memberId");
    String accion = request.getParameter("accion");

    Long proyectoId = null;
    if (proyectoIdStr != null && !proyectoIdStr.isEmpty()) {
      try {
        proyectoId = Long.valueOf(proyectoIdStr);
      } catch (NumberFormatException e) {
        response.getWriter().write("Cedula inválida");
        return;
      }

    }

    Long miembrosId = null;
    if (miembroIdStr != null && !miembroIdStr.isEmpty()) {
      try {
        miembrosId = Long.valueOf(miembroIdStr);
      } catch (NumberFormatException e) {
        response.getWriter().write("Cedula inválida");
        return;
      }
    }

    Tareas tareas = new Tareas(id,
        nombre,
        descripcion,
        fechaInicio,
        fechaFin,
        prioridad,
        status,
        proyectoId,
        miembrosId);
    DAOTareas daoTareas = new DAOTareas(jdbcUrl, jdbcUsername, jdbcPassword);
    boolean isUpdate = daoTareas.updateTare(tareas);

    if ("Actualizar".equalsIgnoreCase(accion)) {
      if (isUpdate) {
        response.getWriter().write("Tarea actualizada con exito");
      } else {
        response.getWriter().write("Error al actualizar la tarea");
      }

    }

  }

  public void deleteTask(HttpServletRequest request, HttpServletResponse response, Long id)
      throws ServletException, IOException {
    DAOTareas daoTareas = new DAOTareas(jdbcUrl, jdbcUsername, jdbcPassword);
    Tareas tareas = daoTareas.getTareaById(id);

    if (tareas != null) {
      boolean isDeleted = daoTareas.deleteTarea(id);
      if (isDeleted) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"message\":\"Tarea eliminada con éxito\"}");
      } else {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar la tarea");
      }
    } else {
      response.sendError(HttpServletResponse.SC_NOT_FOUND, "Tarea no encontrada");
    }
  }

}
