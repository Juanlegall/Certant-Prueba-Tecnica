package com.GimnasioCertant.Gimnasio.Services;


import com.GimnasioCertant.Gimnasio.Dto.dtoClasesDisponiblesxSocio;
import com.GimnasioCertant.Gimnasio.Dto.dtoClasexReserva;
import com.GimnasioCertant.Gimnasio.Models.*;
import com.GimnasioCertant.Gimnasio.Repositorys.ClaseRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.List;

@Service
public class ClaseServicio {

    @Autowired
    private ClaseRepositorio claseRepositorio;

    public List<Clase> ListarClases() {
        return claseRepositorio.findAll();
    }

    public Clase buscarxId(int id) {
        return claseRepositorio.findById(id).orElse(null);
    }

    public Clase altaClase(Clase clase) {
        return claseRepositorio.save(clase);
    }

    public void bajaClase(int id) {
        claseRepositorio.deleteById(id);
    }

    public List<dtoClasesDisponiblesxSocio> clasesDisponibles(Socio socio){
        int idSocio=socio.getIdSocio();
        return claseRepositorio.clasesDisponibles(idSocio);
    }
    public List<Clase> ListaClasesDisponibles(){
        return claseRepositorio.ListaClasesDisponibles();
    }
    public List<dtoClasexReserva> ListarReservasxClase(Integer estado){
        return claseRepositorio.cantReservasxClase(estado);
    }
    public Clase claseBeneficio(int mes){
        System.out.println("creaclasee....");
        Clase clase= new Clase();
        Profesor profe= new Profesor();
        TipoClase tClase= new TipoClase();
        EstadoClase eClase= new EstadoClase();
        Sucursal suc= new Sucursal();
        clase.setDescripcion("sesión personalizada");
        clase.setFecha(YearMonth.of(LocalDate.now().getYear(), mes).atEndOfMonth());
        profe.setIdProfesor(4);
        clase.setProfesor(profe);
        clase.setHorarioInicio(LocalTime.parse("12:00:00"));
        clase.setHorarioFin(LocalTime.parse("22:00:00"));
        clase.setCapacidadMaxima(1);
        tClase.setIdTipoClase(4);
        clase.setTipoclase(tClase);
        eClase.setIdEstadoClase(1);
        clase.setEstadoclase(eClase);
        suc.setIdSucursal(1);
        clase.setSucursal(suc);
        return claseRepositorio.save(clase);
    }
}

