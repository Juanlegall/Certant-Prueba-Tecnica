package com.GimnasioCertant.Gimnasio.Services;

import com.GimnasioCertant.Gimnasio.Models.ProfesorxTipoClase;
import com.GimnasioCertant.Gimnasio.Models.ProfesorxTipoClasePK;
import com.GimnasioCertant.Gimnasio.Repositorys.ProfesorxTipoClaseRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorxTipoClaseServicio {

    @Autowired
    private ProfesorxTipoClaseRepositorio profesorxTipoClaseRepositorio;

    public List<ProfesorxTipoClase> ListarProfesorxTipoClase() {
        return profesorxTipoClaseRepositorio.findAll();
    }

    public ProfesorxTipoClase buscarxId(ProfesorxTipoClasePK id) {
        return profesorxTipoClaseRepositorio.findById(id).orElse(null);
    }


}
