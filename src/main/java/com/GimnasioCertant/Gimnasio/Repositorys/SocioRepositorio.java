package com.GimnasioCertant.Gimnasio.Repositorys;

import com.GimnasioCertant.Gimnasio.Models.Socio;
import com.GimnasioCertant.Gimnasio.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SocioRepositorio extends JpaRepository<Socio, Integer> {
    @Query(value="""
            Select * from Socio socio where not exists(select 1 from Reservas resSoc 
            where resSoc.IdSocio= socio.IdSocio and resSoc.IdClase= :IdClase and resSoc.IdEstadoReserva= :IdEstadoReserva)
            """, nativeQuery = true)
    List<Socio> socioSinReserva(@Param("IdClase") int idClase, @Param("IdEstadoReserva") int idEstadoReserva);
    Socio findByUsuario(Usuario usuario);
    @Query("Select COUNT(a.IdAsistencia) " +
            "from Asistencia a " +
            "where a.estadoasistencia.IdEstadoAsistencia = 1 " +
            "And FUNCTION('MONTH',a.reserva.clase.Fecha) = :mes "+
            "And a.reserva.socio.IdSocio = :idSocio " +
            "And a.Beneficio=false")
    Long ClasexSocio(@Param("idSocio") int idSocio, @Param("mes") int mes);
}
