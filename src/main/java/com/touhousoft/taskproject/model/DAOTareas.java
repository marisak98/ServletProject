package com.touhousoft.taskproject.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * DAOTareas
 */
public class DAOTareas {

  public ConnectionDB connect;

  public DAOTareas(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
    connect = new ConnectionDB(jdbcUrl, jdbcUsername, jdbcPassword);
  }

  public ConnectionDB getConnect() {
    return connect;
  }

  public boolean registerTarea(Tareas tarea) {

    boolean status = false;

    Statement stmt;
    String queryInsert = "INSERT INTO tareas VALUES ( '"
        + tarea.getId() + "', '"
        + tarea.getNombre() + "', '"
        + tarea.getDescripcion() + "', '"
        + tarea.getFechaInicio() + "', '"
        + tarea.getFechaFin() + "', '"
        + tarea.getPrioridad() + "', '"
        + tarea.getState() + "', '"
        + tarea.getProyectoId() + "', '"
        + tarea.getMiembrosEquipoId() + "')";

    try {
      connect.getConnection();
      stmt = connect.getJdbcConnection().createStatement();
      stmt.execute(queryInsert);
      status = true;
      stmt.close();
      connect.Disconnect();
    } catch (SQLException ex) {
      ex.printStackTrace();
      status = false;
    }

    return status;
  }

  public ArrayList<Tareas> getTareas() {
    Tareas tareas = null;
    ArrayList<Tareas> allTasks = new ArrayList<>();

    Statement stmt;
    ResultSet resQuery;
    String query = "SELECT * FROM tareas";

    try {
      connect.getConnection();
      stmt = connect.getJdbcConnection().createStatement();
      resQuery = stmt.executeQuery(query);
      while (resQuery.next()) {
        tareas = new Tareas(
            resQuery.getLong("id"),
            resQuery.getString("nombre"),
            resQuery.getString("descripcion"),
            LocalDate.parse(resQuery.getString("fechaInicio")),
            LocalDate.parse(resQuery.getString("fechaFin")),
            resQuery.getString("prioridad"),
            resQuery.getString("estado"),
            resQuery.getLong("proyectoId"),
            resQuery.getLong("miembroEquipoId"));
        allTasks.add(tareas);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return allTasks;
  }
}
