package com.GimnasioCertant.Gimnasio.Dto;

public class dtoClasexReserva {
    private Integer idClase;
    private String descripcion;
    private Long cantidadReservas;

    public dtoClasexReserva(Integer idClase, String descripcion, Long cantidadReservas) {
        this.idClase = idClase;
        this.descripcion = descripcion;
        this.cantidadReservas = cantidadReservas;
    }

    // getters y setters
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

    public Long getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(Long cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }
}

