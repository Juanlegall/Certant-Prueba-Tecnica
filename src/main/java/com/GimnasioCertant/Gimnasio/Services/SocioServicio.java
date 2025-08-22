package com.GimnasioCertant.Gimnasio.Services;

import com.GimnasioCertant.Gimnasio.Models.Clase;
import com.GimnasioCertant.Gimnasio.Models.Socio;
import com.GimnasioCertant.Gimnasio.Models.Usuario;
import com.GimnasioCertant.Gimnasio.Repositorys.AsistenciaRepositorio;
import com.GimnasioCertant.Gimnasio.Repositorys.SocioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SocioServicio {

    @Autowired
    private SocioRepositorio socioRepositorio;
@Autowired
private AsistenciaServicio asistenciaServicio;
    @Autowired
    private ClaseServicio claseServicio;

    @Autowired
    private ReservasServicio reservasServicio;
    public List<Socio> ListarSocios() {
        return socioRepositorio.findAll();
    }

    public Socio buscarxId(int id) {
        return socioRepositorio.findById(id).orElse(null);
    }
    public Socio altaSocio(Socio socio) {
        return socioRepositorio.save(socio);
    }
    public void bajaSocio(int id) {
        socioRepositorio.deleteById(id);
    }
    public List<Socio> socioSinReserva(int idClase, int idEstadoReserva){ return socioRepositorio.socioSinReserva(idClase, idEstadoReserva); }
    public Socio buscarPorUsuario(Usuario usuario){
        return socioRepositorio.findByUsuario(usuario);
    }
    public Long SocioxClase(int idSocio){
        int mes= LocalDate.now().getMonthValue();
        Long asistencias=socioRepositorio.ClasexSocio(idSocio, mes);
        System.out.println("Valor de asistencias para socio " + idSocio + " en mes " + mes + ": " + asistencias);
        if(asistencias!=null && asistencias>=10L){
            asistencias= 0L;
            System.out.println("asistemcia....");
            asistenciaServicio.asistenciaModificadaxBeneficio(idSocio, mes);
            Clase clase=claseServicio.claseBeneficio(mes);
            System.out.println("asistemcia....");
            Socio socio= buscarxId(idSocio);
            reservasServicio.entregarBeneficio(socio,clase);
            return asistencias;
        }
        return asistencias;
    }
}

