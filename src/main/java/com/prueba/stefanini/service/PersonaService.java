package com.prueba.stefanini.service;

import java.util.List;

import com.prueba.stefanini.domain.PersonaRequest;
import com.prueba.stefanini.domain.PrimosResponse;
import com.prueba.stefanini.entity.PersonaEntity;

public interface PersonaService {
    public PersonaEntity crearPersona(PersonaRequest persona);
    public PersonaEntity actualizarPersona(PersonaRequest personaEntity);
    public List<PersonaEntity> listarPersonas();
    public PersonaEntity listarPersonaById(Long id);
    public Boolean eliminarPersona(Long id);
    public PrimosResponse contarPrimos();
}
