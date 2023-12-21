package com.school.springboot.reuniones.controllers;

import com.school.springboot.reuniones.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public String getAllPersonas(Model model) {
        model.addAttribute("people", personaService.getAllPersonas());
        return "personas";
    }

}
