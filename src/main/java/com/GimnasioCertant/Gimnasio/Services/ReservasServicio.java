package com.GimnasioCertant.Gimnasio.Services;

import com.GimnasioCertant.Gimnasio.Dto.dtoClaseCapacidad;
import com.GimnasioCertant.Gimnasio.Models.Clase;
import com.GimnasioCertant.Gimnasio.Models.EstadoReserva;
import com.GimnasioCertant.Gimnasio.Models.Reservas;
import com.GimnasioCertant.Gimnasio.Models.Socio;
import com.GimnasioCertant.Gimnasio.Repositorys.EstadoReservaRepositorio;
import com.GimnasioCertant.Gimnasio.Repositorys.ReservasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservasServicio {

    @Autowired
    private ReservasRepositorio reservasRepositorio;

    public List<Reservas> ListarReservas() {
        return reservasRepositorio.findAll();
    }

    public Reservas buscarxId(int id) {
        return reservasRepositorio.findById(id).orElse(null);
    }

    public Reservas altaReserva(Reservas reserva) {
        return reservasRepositorio.save(reserva);
    }

    public void bajaReserva(int id) {
        reservasRepositorio.deleteById(id);
    }

    public boolean ConfirmarReserva(Clase clase, Socio socio, EstadoReserva estado) {
        if (lugarDisponible(clase) && !existe(socio.getIdSocio(), clase.getIdClase())) {
            Reservas res = new Reservas();
            res.setClase(clase);
            res.setSocio(socio);
            res.setEstadoreserva(estado);
            reservasRepositorio.save(res);
            return true;
        }
        return false;
    }

    public boolean cancelarReserva(int reserva) {
        Reservas res = buscarxId(reserva);
        modificarEstadoReserva(res, 3);
        return true;
    }

    public boolean reanotarReserva(int reserva) {
        Reservas res = buscarxId(reserva);
        if (!lugarDisponible(res.getClase())) {
            return false;
        }
        modificarEstadoReserva(res, 2);
        return true;
    }

    private boolean lugarDisponible(Clase clase) {
        int cant = reservasRepositorio.cantidadReservas(clase.getIdClase());
        if (clase.getCapacidadMaxima() > cant) return true;
        return false;
    }

    private boolean existe(int idsocio, int idclase) {
        List<Reservas> listareserva = ListarReservas();
        for (Reservas res : listareserva) {
            if (res.getSocio().getIdSocio() == idsocio && res.getClase().getIdClase() == idclase)
                return true;
        }
        return false;
    }

    @Autowired
    private EstadoReservaServicio estadoReservaServ;

    private void modificarEstadoReserva(Reservas res, int estado) {
        EstadoReserva estadoReserva = estadoReservaServ.buscarxId(estado);
        res.setEstadoreserva(estadoReserva);
        reservasRepositorio.save(res);
    }

    public List<Reservas> claseReservadas(Socio socio) {
        int idSocio = socio.getIdSocio();
        return reservasRepositorio.claseReservadas(idSocio);
    }

    public List<Reservas> listaParticipantes(int idClase) {
        return reservasRepositorio.listaParticipantes(idClase);
    }

    public List<dtoClaseCapacidad> listaCapacidad(LocalDate desde, LocalDate hasta) {
        return reservasRepositorio.listaControlCapacidad(desde, hasta);
    }

    public void entregarBeneficio(Socio socio, Clase clase) {
        Reservas reserva = new Reservas();
        EstadoReserva estRes = new EstadoReserva();
        estRes.setIdEstadoReserva(5);
        reserva.setEstadoreserva(estRes);
        reserva.setSocio(socio);
        reserva.setClase(clase);
        altaReserva(reserva);
        return;
    }
}

