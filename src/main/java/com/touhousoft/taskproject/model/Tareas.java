package com.touhousoft.taskproject.model;

import java.time.LocalDate;

/**
 * Tareas
 */
public class Tareas {

  private Long id;
  private String nombre;
  private String descripcion;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private String prioridad;
  private String state;
  private Long proyectoId;
  private Long miembroEquipoId;

  public Tareas(Long id,
      String nombre,
      String descripcion,
      LocalDate fechaInicio,
      LocalDate fechaFin,
      String prioridad,
      String state,
      Long proyectoId,
      Long miembroEquipoId) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.prioridad = prioridad;
    this.state = state;
    this.proyectoId = proyectoId;
    this.miembroEquipoId = miembroEquipoId;
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

  public String getPrioridad() {
    return prioridad;
  }

  public void setPrioridad(String prioridad) {
    this.prioridad = prioridad;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Long getProyectoId() {
    return proyectoId;
  }

  public void setProyectoId(Long proyectoId) {
    this.proyectoId = proyectoId;
  }

  public Long getMiembrosEquipoId() {
    return miembroEquipoId;
  }

  public void setMiembrosEquipoId(Long miembroEquipoId) {
    this.miembroEquipoId = miembroEquipoId;
  }

  @Override
  public String toString() {
    return "Tareas{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", estado=" + state +
        '}';
  }
}
