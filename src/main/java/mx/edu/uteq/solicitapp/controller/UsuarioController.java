/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.controller;

import mx.edu.uteq.solicitapp.service.ICubiculoService;
import mx.edu.uteq.solicitapp.service.IProfesorService;
import mx.edu.uteq.solicitapp.service.IUsuarioService;
import static mx.edu.uteq.solicitapp.util.EncriptarPassword.encriptarPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ricardo
 */
@Controller
public class UsuarioController {
    
    @Autowired
    IUsuarioService usuarioService;
    
    @Autowired
    IProfesorService profesorService;
    
    @Autowired
    ICubiculoService cubiculoService;

    @GetMapping("/")
    public String page(Model model) {
        return "solicitarTurno";
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @PostMapping(path = "/registerusuario")
    @ResponseBody
    public ModelAndView registerusuario(
            @RequestParam("nombUsua") String nombUsua,
            @RequestParam("correoUsua") String correoUsua,
            @RequestParam("contraUsua") String contraUsua,
            @RequestParam("codCubi") String codCubi) {

            usuarioService.insert(nombUsua, correoUsua, encriptarPassword(contraUsua));
            cubiculoService.insert(codCubi, "Si");
            profesorService.insert(cubiculoService.getLastId(), usuarioService.getLastId());

        return new ModelAndView("redirect:/login");
    }

}
