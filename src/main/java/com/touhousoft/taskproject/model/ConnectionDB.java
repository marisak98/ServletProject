package com.touhousoft.taskproject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionDB
 */
public class ConnectionDB {
  private String jdbcUrl;
  private String jdbcUsername;
  private String jdbcPassword;

  private Connection jdbcConnection;

  public ConnectionDB(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
    this.jdbcUrl = jdbcUrl;
    this.jdbcUsername = jdbcUsername;
    this.jdbcPassword = jdbcPassword;
  }

  public void getConnection() throws SQLException {
    if (jdbcConnection == null || jdbcConnection.isClosed()) {
      try {
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("[+] Conectando con la base de datos...");
        System.out.println("[+] Conexion exitosa");
      } catch (ClassNotFoundException ex) {
        System.out.println("[-] Error al cargar el driver");
        throw new SQLException(ex);
      }
    }
    jdbcConnection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
  }

  public void Disconnect() throws SQLException {
    if (jdbcConnection != null && !jdbcConnection.isClosed()) {
      jdbcConnection.close();
    }
  }

  public Connection getJdbcConnection() {
    return jdbcConnection;
  }
}
