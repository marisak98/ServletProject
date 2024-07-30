package com.touhousoft.taskproject.model;

/**
 * usuario
 */
public class usuario {

  private String nombre;
  private String apellido;
  private String phone;
  private String Mobil;
  private String direccion;
  private String user;
  private String password;
  private Long idMiembro;

  public usuario(String user, String password, Long idMiembro) {
    this.user = user;
    this.password = password;
    this.idMiembro = idMiembro;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMobil() {
    return Mobil;
  }

  public void setMobil(String mobil) {
    this.Mobil = mobil;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Long getIdMiembro() {
    return idMiembro;
  }

  public void setIdMiembros(Long idMiembro) {
    this.idMiembro = idMiembro;
  }
}
