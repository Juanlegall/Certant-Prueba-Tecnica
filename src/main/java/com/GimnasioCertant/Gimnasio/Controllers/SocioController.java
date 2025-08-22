package com.GimnasioCertant.Gimnasio.Controllers;

import com.GimnasioCertant.Gimnasio.Models.Clase;
import com.GimnasioCertant.Gimnasio.Models.EstadoReserva;
import com.GimnasioCertant.Gimnasio.Models.Socio;
import com.GimnasioCertant.Gimnasio.Models.Usuario;
import com.GimnasioCertant.Gimnasio.Services.ClaseServicio;
import com.GimnasioCertant.Gimnasio.Services.EstadoReservaServicio;
import com.GimnasioCertant.Gimnasio.Services.ReservasServicio;
import com.GimnasioCertant.Gimnasio.Services.SocioServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Socio")
public class SocioController {
    @Autowired
    private SocioServicio socioServ;
    @Autowired
    private ClaseServicio claseServ;
    @Autowired
    private EstadoReservaServicio estResServ;
    @Autowired
    private ReservasServicio resServ;
    @GetMapping("/ClienteHome")
    public String vistaClienteHome(Model model, HttpSession session){
        Usuario usuario=(Usuario) session.getAttribute("SocioSession");
        Socio socio=socioServ.buscarPorUsuario(usuario);
        model.addAttribute("clasesDelMes", socioServ.SocioxClase(socio.getIdSocio()));
        return "clienteHome";
    }
    @GetMapping("/ClienteReserva")
    public String vistaClienteReserva(Model model, HttpSession session){
        Usuario usuario=(Usuario) session.getAttribute("SocioSession");
        Socio socio=socioServ.buscarPorUsuario(usuario);
        model.addAttribute("clases", claseServ.clasesDisponibles(socio));
        return "clienteReserva";
    }

    @PostMapping("/altaReserva")
    public String crearReserva(@RequestParam("idClase") int IdClase, HttpSession session){
        Usuario usuario=(Usuario) session.getAttribute("SocioSession");
        Socio socio=socioServ.buscarPorUsuario(usuario);
        Clase clase = claseServ.buscarxId(IdClase);
        EstadoReserva estado= estResServ.buscarxId(2);
        resServ.ConfirmarReserva(clase, socio, estado);
        return "redirect:/Socio/ClienteReserva";
    }
    @GetMapping("/MisReservas")
    public String MisReservas(Model model, HttpSession session){
        Usuario usuario=(Usuario) session.getAttribute("SocioSession");
        Socio socio=socioServ.buscarPorUsuario(usuario);
        model.addAttribute("misReservas", resServ.claseReservadas(socio));
        return "clienteMisReservas";
    }
}
