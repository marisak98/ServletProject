package com.touhousoft.taskproject.model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * DAOProyectos
 */
public class DAOProyectos {

  public ConnectionDB connect;

  public DAOProyectos(String jdbcUrl, String jbdcUsername, String jdbcPassword) {
    connect = new ConnectionDB(jdbcUrl, jbdcUsername, jdbcPassword);
  }

  public ConnectionDB getConnect() {
    return connect;
  }

  public boolean registrarProyecto(Proyectos proyecto) {
    boolean status = false;

    Statement stmt;
    String queryInserrt = "INSERT INTO proyectos VALUES (null,'"
        + proyecto.getNombre() + "','"
        + proyecto.getDescripcion() + "','"
        + proyecto.getFechaInicio() + "','"
        + proyecto.getFechaFin() + "','"
        + proyecto.getStatus().name() + "')";

    try {
      connect.getConnection();
      stmt = connect.getJdbcConnection().createStatement();
      stmt.execute(queryInserrt);
      status = true;
      stmt.close();
      connect.Disconnect();
    } catch (SQLException ex) {
      status = false;
      ex.printStackTrace();
    }

    return status;
  }

  public ArrayList<Proyectos> getAllProjects() {
    Proyectos proyecto = null;
    ArrayList<Proyectos> proyectosLista = new ArrayList<>();

    Statement stmt;
    ResultSet rsConsulta = null;
    String querySelect = "SELECT * FROM proyectos";

    try {
      connect.getConnection();
      stmt = connect.getJdbcConnection().createStatement();
      rsConsulta = stmt.executeQuery(querySelect);
      while (rsConsulta.next()) {
        proyecto = new Proyectos(
            rsConsulta.getLong("id"),
            rsConsulta.getString("nombre"),
            rsConsulta.getString("descripcion"),
            LocalDate.parse(rsConsulta.getString("fechaInicio")),
            LocalDate.parse(rsConsulta.getString("fechaFin")),
            Estado.valueOf(rsConsulta.getString("estado"))

        );
        proyectosLista.add(proyecto);
        System.out.println(proyectosLista);

      }
      stmt.close();
      connect.Disconnect();
    } catch (SQLException ex) {
      // TODO: handle exception
      // ex.printStackTrace();
    }
    return proyectosLista;
  }

  public Proyectos getProyectoById(Long id) {
    Proyectos proyecto = null;

    String query = "SELECT * FROM proyectos WHERE id = " + id;

    try {
      connect.getConnection();

      try (PreparedStatement pstmt = connect.getJdbcConnection().prepareStatement(query)) {
        pstmt.setLong(1, id);
        try (ResultSet rs = pstmt.executeQuery()) {
          if (rs.next()) {
            proyecto = new Proyectos(
                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getDate("fechaInicio").toLocalDate(),
                rs.getDate("fechaFin").toLocalDate(),
                Estado.valueOf(rs.getString("estado")));
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace(); // Consider replacing with a logging framework
    }
    return proyecto;
  }

  public boolean updateProyecto(Proyectos proyecto) {
    boolean status = false;
    Connection connection;

    String query = "UPDATE proyectos SET nombre = ?, descripcion = ?, fechaInicio = ?, fechaFin = ?,  estado = ? WHERE id = ?";
    try {
      connect.getConnection();
      try (PreparedStatement pstmt = connect.getJdbcConnection().prepareStatement(query)) {
        pstmt.setString(1, proyecto.getNombre());
        pstmt.setString(2, proyecto.getDescripcion());
        pstmt.setDate(3, Date.valueOf(proyecto.getFechaInicio()));
        pstmt.setDate(4, Date.valueOf(proyecto.getFechaFin()));
        pstmt.setString(5, proyecto.getStatus().name());
        pstmt.setLong(6, proyecto.getId());

        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return status;
  }

  public boolean deleteProyecto(Long id) {
    boolean status = false;

    String query = "DELETE FROM proyectos WHERE id = " + id;

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
