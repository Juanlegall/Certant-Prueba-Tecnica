package com.GimnasioCertant.Gimnasio.Controllers;

import com.GimnasioCertant.Gimnasio.Dto.dtoClasexReserva;
import com.GimnasioCertant.Gimnasio.Models.Asistencia;
import com.GimnasioCertant.Gimnasio.Models.Clase;
import com.GimnasioCertant.Gimnasio.Models.Reservas;
import com.GimnasioCertant.Gimnasio.Models.Socio;
import com.GimnasioCertant.Gimnasio.Services.AsistenciaServicio;
import com.GimnasioCertant.Gimnasio.Services.ClaseServicio;
import com.GimnasioCertant.Gimnasio.Services.ReservasServicio;
import com.GimnasioCertant.Gimnasio.Services.SocioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Api")
public class ApiRest {
    @Autowired
    private ClaseServicio claseServ;

    @GetMapping("/getClase/{idClase}")
    public ResponseEntity<Clase> getClase(@PathVariable int idClase) {
        System.out.println(claseServ.buscarxId(idClase));
        return ResponseEntity.ok(claseServ.buscarxId(idClase));
    }

    @Autowired
    private SocioServicio socioServ;

    @GetMapping("/ListaSocio/{idClase}")
    public ResponseEntity<List<Socio>> listaSocio(@PathVariable int idClase) {
        int idEstado = 1;
        List<Socio> lista = socioServ.socioSinReserva(idClase, idEstado);
        return ResponseEntity.ok(lista);
    }

    @Autowired
    private ReservasServicio resServ;

    @PostMapping("/cancelar")
    public ResponseEntity<Void> cancelarReserva(@ModelAttribute("idReserva") int idReserva) {
        resServ.cancelarReserva(idReserva);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/Socio/MisReservas")).build();
    }

    @PostMapping("/reanotarme")
    public ResponseEntity<String> reanotarme(@ModelAttribute("idReserva") int idReserva) {
        if (resServ.reanotarReserva(idReserva)) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/Socio/MisReservas")).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Espacio de la clase lleno");
        }

    }
    @GetMapping("/Participantes/{idClase}")
    public ResponseEntity<List<Reservas>>ListaParticipantes(@PathVariable int idClase){
        List<Reservas> listaParticipantes= resServ.listaParticipantes(idClase);
        return ResponseEntity.ok(listaParticipantes);

    }
    @Autowired
    private AsistenciaServicio asistServ;
    @PostMapping("/MarcarPresente/{idreserva}")
    public ResponseEntity<Void> MarcarPresente(@PathVariable int idreserva){
        asistServ.MarcarPresente(resServ.buscarxId(idreserva));
        return ResponseEntity.ok().build();
    }
    @PostMapping("/MarcarAusente/{idreserva}")
    public ResponseEntity<Void> MarcarAusente(@PathVariable int idreserva){
        Reservas res=resServ.buscarxId(idreserva);
        asistServ.MarcarAusente(res);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/Asistencia/{idSocio}")
    public ResponseEntity<List<Asistencia>> historialAsistencia(@PathVariable int idSocio){
        List<Asistencia> historial= asistServ.historialAsistencia(idSocio);
        return ResponseEntity.ok(historial);
    }
}