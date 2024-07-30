package com.touhousoft.taskproject.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

  public Tareas getTareaById(Long id) {
    Tareas tareas = null;

    String query = "SELECT * FROM tareas WHERE id = " + id;

    try {
      connect.getConnection();

      try (PreparedStatement pstmt = connect.getJdbcConnection().prepareStatement(query)) {
        pstmt.setLong(1, id);
        try (ResultSet rs = pstmt.executeQuery()) {
          if (rs.next()) {
            tareas = new Tareas(
                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getDate("fechaInicio").toLocalDate(),
                rs.getDate("fechaFin").toLocalDate(),
                rs.getString("prioridad"),
                rs.getString("estado"),
                rs.getLong("proyectoId"),
                rs.getLong("miembroEquipoId"));
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace(); // Consider replacing with a logging framework
    }
    return tareas;
  }

  public boolean updateTare(Tareas tarea) {
    boolean status = false;
    Connection connection;

    String query = "UPDATE tareas SET nombre = ?, descripcion = ?, fechaInicio = ?, fechaFin = ?, prioridad = ?, estado = ?, proyectoId = ?, miembroEquipoId = ? WHERE id = ?";
    try {
      connect.getConnection();
      try (PreparedStatement pstmt = connect.getJdbcConnection().prepareStatement(query)) {
        pstmt.setString(1, tarea.getNombre());
        pstmt.setString(2, tarea.getDescripcion());
        pstmt.setDate(3, Date.valueOf(tarea.getFechaInicio()));
        pstmt.setDate(4, Date.valueOf(tarea.getFechaFin()));
        pstmt.setString(5, tarea.getPrioridad());
        pstmt.setString(6, tarea.getState());
        pstmt.setLong(7, tarea.getProyectoId());
        pstmt.setLong(8, tarea.getMiembrosEquipoId());
        pstmt.setLong(9, tarea.getId());

        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return status;
  }

  public boolean deleteTarea(Long id) {
    boolean status = false;

    String query = "DELETE FROM tareas WHERE id = " + id;

    try (PreparedStatement pstmt = connect.getJdbcConnection().prepareStatement(query)) {
      pstmt.setLong(1, id);
      int rowsAffected = pstmt.executeUpdate();
      return rowsAffected > 0;
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return status;
  }
}
