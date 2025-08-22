package com.GimnasioCertant.Gimnasio.Services;

import com.GimnasioCertant.Gimnasio.Models.Usuario;
import com.GimnasioCertant.Gimnasio.Repositorys.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
    public Usuario buscarxId(int id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }


public Optional<Usuario> login(Usuario us){
    Optional<Usuario> usuario=usuarioRepositorio.findByNombreUsuario(us.getNombreUsuario());
    if(usuario.isPresent()) {
        Usuario existe=usuario.get();
    if(us.getContrasena().equals(existe.getContrasena())){
        return Optional.of(existe);
    }
    return Optional.empty();
    }
    return Optional.empty();

}


    public Usuario altaUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
    public void bajaUsuario(int id) {
        usuarioRepositorio.deleteById(id);
    }
}
