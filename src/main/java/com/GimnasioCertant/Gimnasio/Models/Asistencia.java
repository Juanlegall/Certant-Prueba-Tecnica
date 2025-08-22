package com.GimnasioCertant.Gimnasio.Models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdAsistencia;

    @JoinColumn(name = "IdReserva")
    @ManyToOne
    private Reservas reserva;

    @JoinColumn(name = "IdEstadoAsistencia")
    @ManyToOne
    private EstadoAsistencia estadoasistencia;
    @Column(name="beneficio", nullable = false)
    private boolean Beneficio=false;
}

