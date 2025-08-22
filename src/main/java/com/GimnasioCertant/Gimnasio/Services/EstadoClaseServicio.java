package com.GimnasioCertant.Gimnasio.Services;


import com.GimnasioCertant.Gimnasio.Models.EstadoClase;
import com.GimnasioCertant.Gimnasio.Repositorys.EstadoClaseRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoClaseServicio {

    @Autowired
    private EstadoClaseRepositorio estadoClaseRepositorio;

    public List<EstadoClase> ListarEstadosClase() {
        return estadoClaseRepositorio.findAll();
    }

    public EstadoClase buscarxId(int id) {
        return estadoClaseRepositorio.findById(id).orElse(null);
    }
}

