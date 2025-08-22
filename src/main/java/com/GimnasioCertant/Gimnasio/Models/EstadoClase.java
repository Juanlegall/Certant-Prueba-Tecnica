package com.GimnasioCertant.Gimnasio.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class EstadoClase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdEstadoClase;
    private String Descripcion;
}
