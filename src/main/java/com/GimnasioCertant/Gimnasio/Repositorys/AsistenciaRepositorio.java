package com.GimnasioCertant.Gimnasio.Repositorys;

import com.GimnasioCertant.Gimnasio.Models.Asistencia;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsistenciaRepositorio extends JpaRepository<Asistencia, Integer> {
    @Query(value="""
select asist.* from asistencia as asist inner join Reservas as res on asist.idreserva=res.idreserva
where res.IdSocio= :idSocio
                 """, nativeQuery = true)
    List<Asistencia> historialAsistencia(@Param("idSocio") int idSocio);

    @Transactional
    @Modifying
    @Query("UPDATE Asistencia a SET a.Beneficio = true " +
            "WHERE a.estadoasistencia.IdEstadoAsistencia = 1 " +
            "AND FUNCTION('MONTH', a.reserva.clase.Fecha) = :mes " +
            "AND a.reserva.socio.IdSocio = :idSocio " +
            "AND a.Beneficio = false")
    int modificarAsistencia(@Param("mes") int mes, @Param("idSocio") int idSocio);
}
