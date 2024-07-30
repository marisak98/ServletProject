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
            rsConsulta.getInt("id"),
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

}
