package com.devfix.controller;

import com.devfix.model.Comentario;
import com.devfix.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @GetMapping("/")
    public String index() {
        return "nosotros"; // Tu página principal
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros";
    }

    @GetMapping("/visitanos")
    public String visitanos() {
        return "visitanos";
    }

    // Muestra el formulario Y la lista de comentarios
    @GetMapping("/comentarios")
    public String comentarios(Model model) {
        // Para el formulario vacío
        model.addAttribute("comentario", new Comentario());

        // Para la lista de abajo (consulta a la BD)
        model.addAttribute("listaComentarios", comentarioRepository.findAll());

        return "comentarios";
    }

    // Recibe los datos del formulario y los guarda
    @PostMapping("/guardar-comentario")
    public String guardarComentario(@ModelAttribute Comentario comentario) {
        comentarioRepository.save(comentario);
        return "redirect:/comentarios"; // Recarga la página para ver el nuevo comentario
    }
}