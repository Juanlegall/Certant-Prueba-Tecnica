package com.GimnasioCertant.Gimnasio.Services;

import com.GimnasioCertant.Gimnasio.Models.EstadoReserva;
import com.GimnasioCertant.Gimnasio.Repositorys.EstadoReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoReservaServicio {

    @Autowired
    private EstadoReservaRepositorio estadoReservaRepositorio;

    public List<EstadoReserva> ListarEstadosReserva() {
        return estadoReservaRepositorio.findAll();
    }

    public EstadoReserva buscarxId(int id) {
        return estadoReservaRepositorio.findById(id).orElse(null);
    }
}
