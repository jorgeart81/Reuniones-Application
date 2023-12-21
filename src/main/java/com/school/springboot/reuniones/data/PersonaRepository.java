package com.school.springboot.reuniones.data;

import com.school.springboot.reuniones.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
