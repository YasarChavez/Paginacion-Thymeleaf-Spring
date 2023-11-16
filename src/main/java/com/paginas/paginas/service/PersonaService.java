package com.paginas.paginas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.paginas.paginas.entity.Persona;
import com.paginas.paginas.repository.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Page<Persona> paginar(Pageable pageable) {
        return personaRepository.findAll(pageable);
    }

    public void cargarPersonas(int cantidad){
        for (int index = 0; index < cantidad; index++) {
            Persona persona = new Persona();
            persona.setNombre("Persona "+(index+1));
            persona.setApellido("Apellido "+(index+1));
            personaRepository.save(persona);
        }
    }
}
