package com.sideralti.app.controller;

import com.sideralti.app.dto.ProyectoParcialDto;
import com.sideralti.app.model.enums.EstadoProyecto;
import com.sideralti.app.service.ProyectoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping("/estado")
    public String getProyectosByEstado(@RequestParam EstadoProyecto estado, Model model) {
        List<ProyectoParcialDto> proyectos = proyectoService.findByEstadoParcial(estado);
        model.addAttribute("proyectos", proyectos);
        model.addAttribute("estado", estado); // Para mostrar dinámicamente el estado seleccionado
        return "proyectos/proyectos-estado";
    }

}
