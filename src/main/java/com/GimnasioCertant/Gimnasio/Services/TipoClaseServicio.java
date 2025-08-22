package com.GimnasioCertant.Gimnasio.Services;


import com.GimnasioCertant.Gimnasio.Models.TipoClase;
import com.GimnasioCertant.Gimnasio.Repositorys.TipoClaseRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoClaseServicio {

    @Autowired
    private TipoClaseRepositorio tipoClaseRepositorio;

    public List<TipoClase> ListarTiposClase() {
        return tipoClaseRepositorio.findAll();
    }

    public TipoClase buscarxId(int id) {
        return tipoClaseRepositorio.findById(id).orElse(null);
    }

}

