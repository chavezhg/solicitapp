/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.controller;

import java.util.List;
import mx.edu.uteq.solicitapp.model.entity.Profesor;
import mx.edu.uteq.solicitapp.model.entity.RequestSolicitud;
import mx.edu.uteq.solicitapp.model.entity.Solicitud;
import mx.edu.uteq.solicitapp.model.entity.Turno;
import mx.edu.uteq.solicitapp.model.entity.Usuario;
import mx.edu.uteq.solicitapp.service.IProfesorService;
import mx.edu.uteq.solicitapp.service.ISolicitudService;
import mx.edu.uteq.solicitapp.service.ITurnoService;
import mx.edu.uteq.solicitapp.service.IUsuarioService;
import static mx.edu.uteq.solicitapp.util.EncriptarPassword.encriptarPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ricardo
 */
@Controller
public class TurnoController {
    
    @Autowired
    IProfesorService profesorService;
    
    @Autowired
    ISolicitudService solicitudService;
    
    @Autowired
    ITurnoService turnoService;
    
    @Autowired
    IUsuarioService usuarioService;
    
    @GetMapping("/solicitarTurno")
    public String solicitarTurno(Model model) {
        model.addAttribute("profesores", profesorService.getAll());
        return "solicitarTurno";
    }
    
    @PostMapping(path = "/registrarTurno")
    @ResponseBody
    public Turno registerusuario(
            @RequestBody RequestSolicitud requestSolicitud, Model model) {

            solicitudService.insert(requestSolicitud.idProf, requestSolicitud.nomAlumnSoli, requestSolicitud.matAlumnSoli, requestSolicitud.asuntoSoli);
            turnoService.insert(solicitudService.getLastId(), "Pendiente");
            
            Turno find = new Turno();
            find.idTurn = Long.parseLong(turnoService.getLastId());
            Turno turno = turnoService.findById(find);

        return turno;
    }
    
    @GetMapping("/verTurnos")
    public String verTurnos(Model model) {
        model.addAttribute("turnos", turnoService.getAllAceptados());
        return "turnos";
    }
    
    /*@PostMapping(path = "/aceptarTurno")
    @ResponseBody
    public ModelAndView aceptarTurno(
            @RequestBody Turno turno) {

            turnoService.update(turno.getIdTurn().toString(), "Aceptado");

        return new ModelAndView("redirect:/principal?mensaje=1");
    }
    
    @PostMapping(path = "/rechazarTurno")
    @ResponseBody
    public ModelAndView rechazarTurno(
            @RequestBody Turno turno) {

            turnoService.update(turno.getIdTurn().toString(), "Rechazado");

        return new ModelAndView("redirect:/principal?mensaje=1");
    }*/

}
