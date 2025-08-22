package com.GimnasioCertant.Gimnasio.Services;

import com.GimnasioCertant.Gimnasio.Models.Profesor;
import com.GimnasioCertant.Gimnasio.Repositorys.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServicio {

    @Autowired
    private ProfesorRepositorio profesorRepositorio;

    public List<Profesor> ListarProfesores() {
        return profesorRepositorio.findAll();
    }

    public Profesor buscarxId(int id) {
        return profesorRepositorio.findById(id).orElse(null);
    }

    public Profesor altaProfesor(Profesor profesor) {
        return profesorRepositorio.save(profesor);
    }

    public void bajaProfesor(int id) {
        profesorRepositorio.deleteById(id);
    }
}

