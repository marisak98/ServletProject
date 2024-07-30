package com.touhousoft.taskproject.model;

/**
 * MiembroEquipo
 */
public class MiembroEquipo {

  private int id;
  private String nombre;
  private String correo;
  private String rol;

  public MiembroEquipo(int id, String nombre, String correo, String rol) {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
    this.rol = rol;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

  @Override
  public String toString() {
    return "MiembrosEquipo{" + "id=" + id + ", nombre='" + nombre + '\'' + ", correo='" + correo + '\'' + ", rol='"
        + rol + '\'' + '}';
  }
}