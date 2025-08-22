package com.GimnasioCertant.Gimnasio.Controllers;

import com.GimnasioCertant.Gimnasio.Dto.dtoClasexReserva;
import com.GimnasioCertant.Gimnasio.Dto.dtoUsuxSoc;
import com.GimnasioCertant.Gimnasio.Models.*;
import com.GimnasioCertant.Gimnasio.Repositorys.UsuarioRepositorio;
import com.GimnasioCertant.Gimnasio.Services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Redirect")

public class RedireccionesController {
    @Autowired
    private SocioServicio socioServ;
    private void listaDeSocio(Model model){
        model.addAttribute("ListaCliente", socioServ.ListarSocios());
    }
   @GetMapping("/login")
    public String vistaLogin(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
   }
   @GetMapping("/Registrarse")
    public String vistaRegistrarse(Model model){
        model.addAttribute("usuaxsoc", new dtoUsuxSoc());
        return "RegistrarSocio";
   }
   @Autowired
   private RegistroServicio regServ;
   @PostMapping("/GuardarSocio")
    public String guardarSocio(dtoUsuxSoc dtoUxS){
        regServ.AltaUsuario(dtoUxS);
return "redirect: /Redirect/login";
   }
    @Autowired
    private UsuarioServicio usuServ;
    @PostMapping("/Ingresar")
    public String ingresar(@ModelAttribute Usuario us, HttpSession session){
       Optional<Usuario> verificar=usuServ.login(us);
       if(verificar.isPresent()){
               session.setAttribute("SocioSession",verificar.get());
           if(verificar.get().isRol()){
               return "redirect:/Socio/ClienteHome";
           }
           else return "redirect:/Admin/gestionClase";
       }
       return "redirect:/Redirect/login";
   }
   @GetMapping("/logout")
   public String logout(HttpSession session){
        session.setAttribute("SocioSession", null);
        return "redirect:/Redirect/login";
   }
}
