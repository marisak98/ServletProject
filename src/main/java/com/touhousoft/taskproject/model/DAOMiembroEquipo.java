package com.touhousoft.taskproject.model;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * DAOMiembroEquipo
 */
public class DAOMiembroEquipo {

  public ConnectionDB connect;

  public DAOMiembroEquipo(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
    connect = new ConnectionDB(jdbcUrl, jdbcUsername, jdbcPassword);
  }

  public ConnectionDB getConnect() {
    return connect;
  }

  public boolean registrarMiembroEqipo(MiembroEquipo miembroEquipo) {
    boolean status = false;

    Statement stmt;

    String query = "INSERT  INTO miembros_equipo VALUES ('"
        + miembroEquipo.getId() + "', '"
        + miembroEquipo.getNombre() + "','"
        + miembroEquipo.getCorreo() + "','"
        + miembroEquipo.getRol() + "')";

    try {
      connect.getConnection();
      stmt = connect.getJdbcConnection().createStatement();
      stmt.execute(query);
      status = true;
      stmt.close();
      connect.Disconnect();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return status;
  }
}
