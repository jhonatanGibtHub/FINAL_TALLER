package com.tallerdesarrollo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rol_privilegio")
public class RolePrivilegeModel {
    @Id
    @Column(name = "rol_nombre", nullable = false)
    private String rolNombre;

    @Column(name = "privilegio_nombre", nullable = false)
    private String privilegioNombre;
}
