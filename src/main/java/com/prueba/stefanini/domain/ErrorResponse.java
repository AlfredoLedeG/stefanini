package com.prueba.stefanini.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private String mensaje;
    private String status;
    private Integer code;
}
