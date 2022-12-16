package com.prueba.stefanini.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaRequest {
    private Long id;
    @NotNull
    @NotBlank
    private String nombres;
    @NotNull
    @NotBlank
    private String apellidos;
    @NotNull
    @NotBlank
    private String direccion;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String celular;
}
