package com.GimnasioCertant.Gimnasio.Controllers;

import com.GimnasioCertant.Gimnasio.Dto.dtoClasexReserva;
import com.GimnasioCertant.Gimnasio.Models.Clase;
import com.GimnasioCertant.Gimnasio.Models.EstadoReserva;
import com.GimnasioCertant.Gimnasio.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private ClaseServicio claseServ;
    @GetMapping("/gestionClase")
    public String vistaGestionClase(Model model){
        model.addAttribute("ListaClase", claseServ.ListarClases());
        return "gestionClase";
    }
    @Autowired
    ProfesorServicio profeServ;
    @Autowired
    SucursalServicio sucuServ;
    @Autowired
    private TipoClaseServicio tipoclasServ;
    @GetMapping("/altaClase")
    public String vistaAltaClase(Model model){
        model.addAttribute("Clase", new Clase());
        model.addAttribute("ListaProfesores", profeServ.ListarProfesores());
        model.addAttribute("ListaSucursales", sucuServ.ListarSucursales());
        model.addAttribute("ListaTipoClase", tipoclasServ.ListarTiposClase());
        return "altaClase";

    }
    @Autowired
    EstadoClaseServicio estadoServ;
    @PostMapping("/Guardar")
    public String GuardarClase(@ModelAttribute Clase clase){
        clase.setEstadoclase(estadoServ.buscarxId(1));
        claseServ.altaClase(clase);
        return "redirect:/Admin/altaClase";
    }
    @Autowired
    private SocioServicio socioServ;
    @GetMapping("/gestionCliente")
    public String vistaGestionCliente(Model model){
        model.addAttribute("ListaCliente", socioServ.ListarSocios());
        return "gestionCliente";
    }
    @Autowired ReservasServicio resServ;
    @GetMapping("/gestionReserva")
    public String vistaGestionReserva(Model model){
        model.addAttribute("listaReservas", resServ.ListarReservas());
        return "gestionReserva";
    }
    @GetMapping("/controlAsistencia")
    public String vistaControlAsistencia(Model model){
        model.addAttribute("clasesDisponibles",claseServ.ListaClasesDisponibles());
        return "controlAsistencia";
    }
    @GetMapping("/historialAsistencia")
    public String vistahistorialAsistencia(Model model){
        model.addAttribute("sociosDisponibles",socioServ.ListarSocios());
        return "estadisticaAsistencia";
    }
    @Autowired
    private EstadoReservaServicio estResServ;
    @GetMapping("/estadisticaClaseDemanda")
    public String listaReservasxClase(Model model, @RequestParam(value = "estado", required = false) Integer estado){
        List<dtoClasexReserva> reservasxclase= claseServ.ListarReservasxClase(estado);
        model.addAttribute("tipoEstado", estResServ.ListarEstadosReserva());
        model.addAttribute("reservasxclase", reservasxclase);
        return "estadisticaClaseDemanda";
    }
    @GetMapping("/estadisticaCantidadReserva")
    public String vistaCantidadReserva (Model model, @RequestParam(value = "desde", required = false)LocalDate desde,
                                        @RequestParam(value="hasta", required = false)LocalDate hasta){
        model.addAttribute("listaCantidadReserva", resServ.listaCapacidad(desde, hasta));
        return "estadisticaClaseCapacidad";
    }
}
