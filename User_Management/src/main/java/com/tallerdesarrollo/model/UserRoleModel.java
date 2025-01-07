package com.tallerdesarrollo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario_rol")
public class UserRoleModel {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserModel usuario;

    @Column(name = "rol_nombre", nullable = false)
    private String rolNombre;
}
