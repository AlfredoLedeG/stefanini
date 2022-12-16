package com.prueba.stefanini.controller;

import com.prueba.stefanini.domain.ErrorResponse;
import com.prueba.stefanini.domain.PersonaRequest;
import com.prueba.stefanini.entity.PersonaEntity;
import com.prueba.stefanini.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("reto-proyecto/api/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

   @GetMapping
    public ResponseEntity<?> listarPersonas() {
        return ResponseEntity.ok(personaService.listarPersonas());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> listarPersonaById(@PathVariable(required = true) Long id) {
        try {
            PersonaEntity personaEntity = personaService.listarPersonaById(id);

            if (personaEntity == null) {
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            return ResponseEntity.status(200).body(personaEntity);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.builder()
                    .code(500)
                    .status("Error")
                    .mensaje("Ocurrió un error interno en el servidor.")
                    .build());
        }
    }

    @PostMapping
    public ResponseEntity<?> crearPersona(@RequestBody @Valid PersonaRequest persona) {
        try {

            return ResponseEntity.status(201).body(personaService.crearPersona(persona));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.builder()
                    .code(500)
                    .status("Error")
                    .mensaje("Ocurrió un error interno en el servidor.")
                    .build());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarPersona(@RequestBody @Valid PersonaRequest persona) {
        try {

            return ResponseEntity.status(200).body(personaService.actualizarPersona(persona));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.builder()
                    .code(500)
                    .status("Error")
                    .mensaje("Ocurrió un error interno en el servidor.")
                    .build());
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable(required = true) Long id) {

        try {
            boolean deleted = personaService.eliminarPersona(id);

            if (deleted) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.builder()
                    .code(400)
                    .status("Error")
                    .mensaje("No se encontró ningun usuario con el id " + id + ".")
                    .build());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.builder()
                    .code(500)
                    .status("Error")
                    .mensaje("Ocurrió un error interno en el servidor.")
                    .build());
        }
    }
    
    @GetMapping(value="/contar-primos")
    public ResponseEntity<?> contarPrimos() {
        return ResponseEntity.ok(personaService.contarPrimos());
    }
}
