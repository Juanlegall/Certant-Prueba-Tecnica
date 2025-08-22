package com.GimnasioCertant.Gimnasio.Models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
@Embeddable
public class ProfesorxTipoClasePK {

    @ManyToOne
    @JoinColumn(name="IdProfesor")
    private Profesor IdProfesor;
    @ManyToOne
    @JoinColumn(name="IdTipoClase")
    private TipoClase IdTipoClase;
}
