package com.GimnasioCertant.Gimnasio.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
    @NoArgsConstructor
    @Entity
public class Socio {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
private int IdSocio;
        private String Nombre, Email, Telefono;
        private boolean Estado;
        @JoinColumn(name="IdUsuario")
        @OneToOne
        @ToString.Exclude
        private Usuario usuario;
        /* En caso de que alguna tabla tenga clave foranea agregala de la siguiente manera
        @JoinColumn(name="NombreColumna")
        @ManyToOne
        NombreClasePadre nombreObjeto(nombre de la clase ej private TipoClase tipoclase)
         */
}
