package com.GimnasioCertant.Gimnasio.Models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class ProfesorxTipoClase implements Serializable {
    @EmbeddedId
    private ProfesorxTipoClasePK idProfesorxTipoClase;
    private boolean Estado;
}
