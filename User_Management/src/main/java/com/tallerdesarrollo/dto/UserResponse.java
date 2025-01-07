package com.tallerdesarrollo.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Integer idUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String username;
    private String estado;
}
