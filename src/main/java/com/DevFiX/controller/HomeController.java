package com.DevFiX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Ventana: Sobre Nosotros (Empresa)
    @GetMapping("/nosotros")
    public String mostrarNosotros() {
        return "nosotros";
    }

    // Ventana: Visítanos
    @GetMapping("/visitanos")
    public String mostrarVisitanos() {
        return "visitanos";
    }

    // Ventana: Comentarios
    @GetMapping("/comentarios")
    public String mostrarComentarios() {
        return "comentarios";
    }
}