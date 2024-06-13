package com.touhousoft.taskproject.service;

import com.touhousoft.taskproject.model.usuario;

/**
 * UserService
 */
public class UserService {

  private static final Integer MAX_ATTEMPS = 3;
  private Integer attempt = MAX_ATTEMPS;

  public Integer getAttemps() {
    return attempt;
  }

  public void setAttemps(Integer attempt) {
    this.attempt = attempt;
  }

  public boolean isValid(usuario user) {
    if (attempt > 0) {
      if ("admin".equals(user.getUser()) && "1234".equals(user.getPassword())) {
        attempt = MAX_ATTEMPS;
        return true;
      } else {
        attempt--;
        return false;
      }
    }
    return false;
  }

  public int isBlocked() {
    return attempt;
  }
}
