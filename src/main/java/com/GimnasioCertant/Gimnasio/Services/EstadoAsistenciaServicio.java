package com.GimnasioCertant.Gimnasio.Services;

import com.GimnasioCertant.Gimnasio.Models.EstadoAsistencia;
import com.GimnasioCertant.Gimnasio.Repositorys.EstadoAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoAsistenciaServicio {

    @Autowired
    private EstadoAsistenciaRepositorio estadoAsistenciaRepositorio;

    public List<EstadoAsistencia> ListarEstadosAsistencia() {
        return estadoAsistenciaRepositorio.findAll();
    }

    public EstadoAsistencia buscarxId(int id) {
        return estadoAsistenciaRepositorio.findById(id).orElse(null);
    }

}
