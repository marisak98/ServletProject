package com.touhousoft.taskproject.model;

/**
 * DAOUser
 */
public class DAOUser {

  private ConnectionDB connectionDB;

  public DAOUser(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
    connectionDB = new ConnectionDB(jdbcUrl, jdbcUsername, jdbcPassword);
  }
}
