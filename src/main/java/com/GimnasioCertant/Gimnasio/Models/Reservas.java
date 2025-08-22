package com.GimnasioCertant.Gimnasio.Models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdReserva;

    @JoinColumn(name = "IdSocio")
    @ManyToOne
    @ToString.Exclude
    private Socio socio;


    @ManyToOne
    @JoinColumn(name = "IdClase")
    @JsonIgnoreProperties("reservas")
    @ToString.Exclude
    private Clase clase;
    @JoinColumn(name = "IdEstadoReserva")
    @ManyToOne
    private EstadoReserva estadoreserva;
}
