package com.school.springboot.reuniones.controllers;

import com.school.springboot.reuniones.models.Reunion;
import com.school.springboot.reuniones.services.ReunionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reuniones")
public class ReunionesResController {
    private ReunionService reunionService;

    public ReunionesResController(ReunionService reunionService) {
        this.reunionService = reunionService;
    }

    @GetMapping
    public List<Reunion> getAllReuniones() {
        return reunionService.getAllReuniones();
    }
}
