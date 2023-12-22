package com.school.springboot.reuniones.services;

import com.school.springboot.reuniones.data.PersonaRepository;
import com.school.springboot.reuniones.models.Persona;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getById(long id){
        return personaRepository.findById(id);
    }
}
