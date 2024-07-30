package com.touhousoft.taskproject.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

  public ArrayList<MiembroEquipo> getMiembrosEquipo() {
    MiembroEquipo miembrosEquipo = null;
    ArrayList<MiembroEquipo> miembrosEquipoList = new ArrayList<>();

    Statement stmt;
    ResultSet res;
    String query = "SELECT * FROM miembros_equipo";

    try {
      connect.getConnection();
      stmt = connect.getJdbcConnection().createStatement();
      res = stmt.executeQuery(query);
      while (res.next()) {
        miembrosEquipo = new MiembroEquipo(
            res.getLong("id"),
            res.getString("nombre"),
            res.getString("correo"),
            res.getString("rol"));
        miembrosEquipoList.add(miembrosEquipo);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return miembrosEquipoList;
  }

  public MiembroEquipo getMiembroEquipoById(Long id) {
    MiembroEquipo miembrosEquipo = null;
    Statement stmt;
    ResultSet res;
    String query = "SELECT * FROM miembros_equipo WHERE id = " + id;

    try {
      connect.getConnection();
      stmt = connect.getJdbcConnection().createStatement();
      res = stmt.executeQuery(query);
      while (res.next()) {
        miembrosEquipo = new MiembroEquipo(
            res.getLong("id"),
            res.getString("nombre"),
            res.getString("correo"),
            res.getString("rol"));
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return miembrosEquipo;
  }

  public boolean updateMiembrosEquipo(MiembroEquipo miembrosEquipo) {
    boolean status = false;

    String query = "UPDATE miembros_equipo SET nombre = ?, correo = ?, rol = ? WHERE id = ?";

    try {
      connect.getConnection();
      try (PreparedStatement pstmt = connect.getJdbcConnection().prepareStatement(query)) {
        pstmt.setString(1, miembrosEquipo.getNombre());
        pstmt.setString(2, miembrosEquipo.getCorreo());
        pstmt.setString(3, miembrosEquipo.getRol());
        pstmt.setLong(4, miembrosEquipo.getId());
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return status;
  }

  public boolean deleteMiembrosEquipo(Long id) {
    boolean status = false;
    String query = "DELETE FROM miembros_equipo WHERE id = ?";

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
