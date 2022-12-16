package com.prueba.stefanini.service.impl;

import com.prueba.stefanini.domain.PersonaRequest;
import com.prueba.stefanini.domain.PrimosResponse;
import com.prueba.stefanini.entity.PersonaEntity;
import com.prueba.stefanini.repository.PersonaRepository;
import com.prueba.stefanini.service.PersonaService;
import com.prueba.stefanini.utils.UtilsFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaEntity crearPersona(PersonaRequest persona) {
        PersonaEntity personaEntity = PersonaEntity.builder()
                .nombres(persona.getNombres())
                .apellidos(persona.getApellidos())
                .direccion(persona.getDireccion())
                .email(persona.getEmail())
                .celular(persona.getCelular())
                .build();
        return personaRepository.save(personaEntity);
    }

    @Override
	public PrimosResponse contarPrimos() {
    	return PrimosResponse.builder()
    			.total(personaRepository.findAll().stream()
    	                .filter(x-> UtilsFunctions.esPrimo(x.getNombres().length()))
    	                .collect(Collectors.toList()).size())
    			.build();
	}

	@Override
    public PersonaEntity actualizarPersona(PersonaRequest persona) {
        PersonaEntity personaEntity = PersonaEntity.builder()
                .id(persona.getId())
                .nombres(persona.getNombres())
                .apellidos(persona.getApellidos())
                .direccion(persona.getDireccion())
                .email(persona.getEmail())
                .celular(persona.getCelular())
                .build();
        return personaRepository.save(personaEntity);
    }

    @Override
    public List<PersonaEntity> listarPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public PersonaEntity listarPersonaById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean eliminarPersona(Long id) {
        PersonaEntity persona = personaRepository.findById(id).orElse(null);
        if(persona == null) return false;

        personaRepository.deleteById(id);
        return true;
    }
}
