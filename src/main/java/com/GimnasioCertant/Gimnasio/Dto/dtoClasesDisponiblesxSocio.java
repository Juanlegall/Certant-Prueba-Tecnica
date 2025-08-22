package com.GimnasioCertant.Gimnasio.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class dtoClasesDisponiblesxSocio {
    private int idClase;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime horarioInicio, horarioFin;
    private String sucursal;
    private int capacidadMaxima;
    private Long cantidadReserva;
    public dtoClasesDisponiblesxSocio(int idClase, String descripcion, LocalDate fecha,
                                      LocalTime horarioInicio, LocalTime horarioFin,
                                      String sucursal, int capacidadMaxima, Long cantidadReserva) {
        this.idClase = idClase;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.sucursal = sucursal;
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadReserva = cantidadReserva;
    }

    // Getters y Setters
    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(LocalTime horarioFin) {
        this.horarioFin = horarioFin;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Long getCantidadReserva() {
        return cantidadReserva;
    }

    public void setCantidadReserva(Long cantidadReserva) {
        this.cantidadReserva = cantidadReserva;
    }
}
