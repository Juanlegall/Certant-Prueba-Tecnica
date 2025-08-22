package com.GimnasioCertant.Gimnasio.Services;

import com.GimnasioCertant.Gimnasio.Dto.dtoUsuxSoc;
import com.GimnasioCertant.Gimnasio.Models.Socio;
import com.GimnasioCertant.Gimnasio.Models.Usuario;
import com.GimnasioCertant.Gimnasio.Repositorys.SocioRepositorio;
import com.GimnasioCertant.Gimnasio.Repositorys.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroServicio {

        @Autowired
        private SocioRepositorio socioRepo;
        @Autowired
        private UsuarioRepositorio UsuarioRepo;

        @Transactional
        public boolean AltaUsuario(dtoUsuxSoc UsuarioDt) {
                Socio soc = new Socio();
                Optional<Usuario> optUs=UsuarioRepo.findByNombreUsuario(UsuarioDt.getNombreUsuario());
                if(optUs.isPresent()) return false;
                soc.setNombre(UsuarioDt.getNombre());
                soc.setEmail(UsuarioDt.getEmail());
                soc.setTelefono(UsuarioDt.getTelefono());

                Usuario us = new Usuario();
                us.setNombreUsuario(UsuarioDt.getNombreUsuario());

                us.setContrasena(UsuarioDt.getContrasenia());
                us.setRol(true);
                Usuario usId = UsuarioRepo.save(us);
                soc.setUsuario(usId);
                socioRepo.save(soc);
                return true;
        }
    }
