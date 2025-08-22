package com.GimnasioCertant.Gimnasio.Repositorys;

import com.GimnasioCertant.Gimnasio.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.NombreUsuario = :nombreUsuario")
     Optional<Usuario> findByNombreUsuario(@Param("nombreUsuario") String NombreUsuario);
}
