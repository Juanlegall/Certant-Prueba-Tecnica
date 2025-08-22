package com.GimnasioCertant.Gimnasio.Services;

import com.GimnasioCertant.Gimnasio.Models.Asistencia;
import com.GimnasioCertant.Gimnasio.Models.EstadoAsistencia;
import com.GimnasioCertant.Gimnasio.Models.Reservas;
import com.GimnasioCertant.Gimnasio.Repositorys.AsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServicio {

    @Autowired
    private AsistenciaRepositorio asistenciaRepositorio;

    public List<Asistencia> ListarAsistencias() {
        return asistenciaRepositorio.findAll();
    }

    public Asistencia buscarxId(int id) {
        return asistenciaRepositorio.findById(id).orElse(null);
    }

    public Asistencia altaAsistencia(Asistencia asistencia) {

        return asistenciaRepositorio.save(asistencia);
    }

    public void bajaAsistencia(int id) {
        asistenciaRepositorio.deleteById(id);
    }
    private Optional<Asistencia> existeSocioClase(Reservas reserva){
        List<Asistencia> lista=ListarAsistencias();
        for(Asistencia asist: lista){
            if(reserva.getIdReserva()==asist.getReserva().getIdReserva()){
                return Optional.of(asist);
            }
        }
        return Optional.empty();
    }
    public void MarcarPresente(Reservas reserva){
        Optional<Asistencia> optAsist=existeSocioClase(reserva);
        int estado=1;
        if(optAsist.isEmpty()){
            Asistencia asist=new Asistencia();
            ObjetoNuevo(asist, reserva, estado);
            altaAsistencia(asist);
            return ;
        }
        modificarAsistencia(optAsist, estado);
    }
    public void MarcarAusente(Reservas reserva){
        System.out.println("ReservaSocio"+reserva);
        Optional<Asistencia> optAsist=existeSocioClase(reserva);
        int estado=2;
        if(optAsist.isEmpty()){
            Asistencia asist=new Asistencia();
            ObjetoNuevo(asist, reserva, estado);
            altaAsistencia(asist);
            return ;
        }
        modificarAsistencia(optAsist, estado);
    }
    public void modificarAsistencia(Optional<Asistencia> optAsist, int estado){
        Asistencia asist= optAsist.get();
        EstadoAsistencia estAsist= new EstadoAsistencia();
        estAsist.setIdEstadoAsistencia(estado);
        asist.setEstadoasistencia(estAsist);
        altaAsistencia(asist);
    }
    private void ObjetoNuevo(Asistencia asist, Reservas reserva, int estado){
        asist.setReserva(reserva);
        EstadoAsistencia estAsist= new EstadoAsistencia();
        estAsist.setIdEstadoAsistencia(estado);
        asist.setEstadoasistencia(estAsist);
    }
    public List<Asistencia> historialAsistencia(int idSocio){
        return asistenciaRepositorio.historialAsistencia(idSocio);
    }
    public void asistenciaModificadaxBeneficio(int idSocio, int mes){
        asistenciaRepositorio.modificarAsistencia(mes, idSocio);
    }

}
