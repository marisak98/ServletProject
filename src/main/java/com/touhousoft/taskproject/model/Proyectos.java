package com.touhousoft.taskproject.model;

import java.time.LocalDate;

public class Proyectos {
  private Long id;
  private String nombre;
  private String descripcion;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private Estado status;

  public Proyectos(Long id, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
      Estado status) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public LocalDate getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public LocalDate getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
  }

  public Estado getStatus() {
    return status;
  }

  public void setStatus(Estado status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Proyectos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
        + fechaInicio
        + ", fechaFin=" + fechaFin + ", status=" + status + "]";
  }
}
