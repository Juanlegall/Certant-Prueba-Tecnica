package com.GimnasioCertant.Gimnasio.Dto;

import java.time.LocalDate;

public class dtoClaseCapacidad {
    private Integer idClase;
    private String descripcion;
    private LocalDate fecha ;
    private Integer capacidadMaxima;
    private Long cantidadReserva;
    public dtoClaseCapacidad(Integer idClase, String descripcion, LocalDate fecha, Integer capacidadMaxima, Long cantidadReserva) {
        this.idClase = idClase;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadReserva = cantidadReserva;
    }

    // Getters y Setters
    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
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

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Long getCantidadReserva() {
        return cantidadReserva;
    }

    public void setCantidadReserva(Long cantidadReserva) {
        this.cantidadReserva = cantidadReserva;
    }
}
