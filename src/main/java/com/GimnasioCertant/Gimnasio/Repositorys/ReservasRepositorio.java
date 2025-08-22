package com.GimnasioCertant.Gimnasio.Repositorys;

import com.GimnasioCertant.Gimnasio.Dto.dtoClaseCapacidad;
import com.GimnasioCertant.Gimnasio.Models.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservasRepositorio extends JpaRepository<Reservas, Integer> {
    @Query(
            value="""
                    select count(*) from Reservas where IdClase= :idClase and IdEstadoReserva = 2
                    """, nativeQuery = true)
    int cantidadReservas(@Param("idClase") int idClase);
    @Query(
            value= """ 
                    select * from Reservas where IdSocio= :idsocio
                    """,nativeQuery = true
    )
    List<Reservas> claseReservadas(@Param("idsocio") int idSocio);
    @Query(
            value= """
                     select * from Reservas where IdClase= :idclase and IdEstadoReserva=2
                     """, nativeQuery = true
    )
    List<Reservas> listaParticipantes(@Param("idclase") int IdClase);
    @Query("SELECT new com.GimnasioCertant.Gimnasio.Dto.dtoClaseCapacidad(" +
            "c.IdClase, c.Descripcion, c.Fecha, c.CapacidadMaxima, COUNT(r.IdReserva)) " +
            "FROM Clase c LEFT JOIN c.reservas r " +
            "WITH r.estadoreserva.IdEstadoReserva = 2 " +
            "WHERE (:desde IS NULL OR c.Fecha >= :desde) AND (:hasta IS NULL OR c.Fecha <= :hasta) " +
            "GROUP BY c.IdClase, c.Descripcion, c.Fecha, c.CapacidadMaxima " +
            "ORDER BY COUNT(r.IdReserva) DESC")
    List<dtoClaseCapacidad> listaControlCapacidad(@Param("desde")LocalDate desde, @Param("hasta")LocalDate hasta);

}
