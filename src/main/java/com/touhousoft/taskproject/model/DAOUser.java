package com.touhousoft.taskproject.model;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * DAOUser
 */
public class DAOUser {

  private ConnectionDB connectionDB;

  public DAOUser(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
    connectionDB = new ConnectionDB(jdbcUrl, jdbcUsername, jdbcPassword);
  }

  public ConnectionDB getConnectionDB() {
    return connectionDB;
  }

  public boolean registerUser(usuario user) {
    boolean status = false;

    Statement stmt;
    String queryInsert = "INSERT INTO usuarios VALUES (null, '"
        + user.getUser() + "', '"
        + user.getPassword() + "', '"
        + user.getIdMiembro() + "')";

    try {
      connectionDB.getConnection();
      stmt = connectionDB.getJdbcConnection().createStatement();
      stmt.execute(queryInsert);
      status = true;
      stmt.close();
      connectionDB.Disconnect();
    } catch (SQLException ex) {
      ex.printStackTrace();
      status = false;
    }
    return status;
  }
}
