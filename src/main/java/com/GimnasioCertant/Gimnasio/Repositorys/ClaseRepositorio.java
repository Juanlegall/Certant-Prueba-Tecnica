package com.GimnasioCertant.Gimnasio.Repositorys;

import com.GimnasioCertant.Gimnasio.Dto.dtoClasesDisponiblesxSocio;
import com.GimnasioCertant.Gimnasio.Dto.dtoClasexReserva;
import com.GimnasioCertant.Gimnasio.Models.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClaseRepositorio extends JpaRepository<Clase, Integer> {
    @Query("""
    select new com.GimnasioCertant.Gimnasio.Dto.dtoClasesDisponiblesxSocio(
        c.IdClase ,c.Descripcion, c.Fecha, c.HorarioInicio, c.HorarioFin, c.sucursal.Nombre, c.CapacidadMaxima, COUNT(r.IdReserva)
    )
    from Clase c LEFT JOIN Reservas r
    on r.clase.IdClase = c.IdClase
    where c.tipoclase.IdTipoClase != 4 AND c.IdClase NOT IN (
          SELECT r2.clase.IdClase
          FROM Reservas r2
          WHERE r2.socio.IdSocio = :idsocio
      )
    group by c.IdClase, c.Descripcion
    ORDER BY c.Descripcion
""")
    List<dtoClasesDisponiblesxSocio> clasesDisponibles(@Param("idsocio") int idsocio);
    @Query(
            value= """ 
                    select * from Clase where IdEstadoClase=1
                    """,nativeQuery = true
    )
    List<Clase> ListaClasesDisponibles();
    @Query(value= """
                 SELECT new com.GimnasioCertant.Gimnasio.Dto.dtoClasexReserva(
                        c.IdClase,
                        c.tipoclase.Descripcion,
                        COUNT(r.IdReserva))
                    FROM Clase c
                    LEFT JOIN Reservas r
                           ON r.clase.IdClase = c.IdClase
                           WHERE (:estado is null or r.estadoreserva.IdEstadoReserva= :estado)
                    GROUP BY c.tipoclase.Descripcion
                    ORDER BY COUNT(r.IdReserva) DESC
            """)
    List<dtoClasexReserva> cantReservasxClase(@Param("estado") Integer estado);

}