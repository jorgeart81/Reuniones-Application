package com.school.springboot.reuniones.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.springboot.reuniones.models.Persona;
import com.school.springboot.reuniones.models.Reunion;
import com.school.springboot.reuniones.services.PersonaService;
import com.school.springboot.reuniones.services.ReunionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscaListener {
    private static final Logger LOG = LoggerFactory.getLogger(BuscaListener.class);

    private final ObjectMapper mapper;
    private final PersonaService personaService;
    private final ReunionService reunionService;

    public BuscaListener(ObjectMapper mapper, PersonaService personaService, ReunionService reunionService) {
        this.mapper = mapper;
        this.personaService = personaService;
        this.reunionService = reunionService;
    }

    public void recibirMensaje(String mensaje) {
        try {
            InfoBusca info = mapper.readValue(mensaje, InfoBusca.class);
            Optional<Persona> person = personaService.getById(info.getIdAsistente());
            if (person.isEmpty()) {
                LOG.warn("Mensaje recibido, pero la persona {} no existe", info.getIdAsistente());
            }
            Optional<Reunion> meeting = reunionService.getById(info.getIdReunion());
            if (meeting.isEmpty()) {
                LOG.warn("Mensaje recibido, pero la reunión {} no existe", info.getIdReunion());
            }
            if (person.isPresent() && meeting.isPresent()) {
                LOG.info("{} {} tiene una reunión a las {}",
                        person.get().getNombre(),
                        person.get().getApellidos(),
                        meeting.get().getFecha());
            }
        } catch (JsonProcessingException e) {
            LOG.warn("Wrong message", e);
        }
    }
}
