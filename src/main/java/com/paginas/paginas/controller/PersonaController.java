package com.paginas.paginas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.paginas.paginas.entity.Persona;
import com.paginas.paginas.service.PersonaService;

@Controller
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/lista")
    public String listarItems(@PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
        Page<Persona> page = personaService.paginar(pageable);
        model.addAttribute("page", page);
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("totalPages", page.getTotalPages());
        return "lista";
    }

    @GetMapping("/cargar/{cantidad}")
    public String cargarPersonas(@PathVariable("cantidad") int cantidad){
        personaService.cargarPersonas(cantidad);
        return "redirect:/lista";
    }

}
