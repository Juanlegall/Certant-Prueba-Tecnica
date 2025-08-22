package com.GimnasioCertant.Gimnasio.Models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdClase;
    private String Descripcion;
    private int CapacidadMaxima;
    private LocalDate Fecha;
    private LocalTime HorarioInicio, HorarioFin;

    @JoinColumn(name = "IdSucursal")
    @ManyToOne
    private Sucursal sucursal;

    @OneToMany(mappedBy = "clase")
    @JsonManagedReference
    private List<Reservas> reservas = new ArrayList<>();

    @JoinColumn(name = "IdTipoClase")
    @ManyToOne
    private TipoClase tipoclase;

    @JoinColumn(name = "IdProfesor")
    @ManyToOne
    private Profesor profesor;

    @JoinColumn(name = "IdEstadoClase")
    @ManyToOne
    private EstadoClase estadoclase;
}

